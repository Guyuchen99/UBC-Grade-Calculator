package ui;

import model.Grade;
import model.GradeList;
import model.TargetGrade;
import org.json.JSONException;
import persistence.GradeReader;
import persistence.GradeWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a Grade Calculator Console Application
 */

public class GradeCalculator {

    private static final String JSON_DATA = "./data/grade_calculator.json";
    private Scanner scanner;
    private GradeList myGradeList;
    private GradeWriter gradeWriter;
    private GradeReader gradeReader;

    // EFFECTS: runs the grade calculator console application
    public GradeCalculator() throws FileNotFoundException {
        scanner = new Scanner(System.in);
        myGradeList = new GradeList();
        gradeWriter = new GradeWriter(JSON_DATA);
        gradeReader = new GradeReader(JSON_DATA);

        runGradeCalculator();
    }

    // EFFECTS: processes user command and run specific methods
    private void runGradeCalculator() {
        int operation;

        System.out.println("\nWelcome to the UBC Grade Calculator!!!");

        do {
            displayMenu();
            operation = scanner.nextInt();

            if (operation == 5) {
                goodbyeMessage();

            } else if (operation == 4) {
                loadPreviouslySaved();
                displayContinueOption();

            } else if (operation == 3) {
                saveCurrent();
                displayContinueOption();

            } else if (operation == 2) {
                runSetTarget();
                displayContinueOption();

            } else if (operation == 1) {
                runCalculateGrade();
                displayContinueOption();

            } else {
                System.out.print("\nUnknown Input Detected! Try Again!\n");
            }

        } while (operation != 5);

    }

    // EFFECTS: displays menu of options to the user
    private void displayMenu() {
        System.out.println("\nPlease Select an Option"
                + "\n 1. Calculate Grade"
                + "\n 2. Setting Target"
                + "\n 3. Save Current Calculation"
                + "\n 4. Load Previous Saved Calculation"
                + "\n 5. Quit");
        System.out.print("\nYour Option: ");
    }

    // EFFECTS: displays the options of whether to continue or not to the user
    private void displayContinueOption() {
        if (endProgram()) {
            goodbyeMessage();
            System.exit(0);
        }
    }

    // EFFECTS: ask user whether to terminate or not
    public boolean endProgram() {
        int operation;

        while (true) {
            System.out.println("\nWould You Like To Continue? Yes(1) or No(2)");
            operation = scanner.nextInt();

            if (operation == 1) {
                return false;

            } else if (operation == 2) {
                return true;

            } else {
                System.out.print("\nUnknown Input Detected! Try Again!\n");
            }
        }
    }

    // EFFECTS: displays the goodbye message to the user
    private void goodbyeMessage() {
        System.out.println("\nThank you for using the UBC Grade Calculator! \nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: processes user input and gathering essential information to calculate grade average
    private void runCalculateGrade() {
        NumberFormat percent = NumberFormat.getPercentInstance();
        int operation;
        String course;
        String name;
        double grade;
        double weighting;

        System.out.println("\n---Calculating Grade---");
        myGradeList = new GradeList();

        System.out.print("Enter Your Course Name: ");
        scanner.nextLine();
        course = scanner.nextLine();

        do {
            System.out.print("Enter Your Component Name: ");
            name = scanner.next();
            scanner.nextLine();
            System.out.print("Enter Your Component Grade: ");
            grade = scanner.nextDouble();
            System.out.print("Enter Your Component Weighting: ");
            weighting = scanner.nextDouble();

            myGradeList.addGrade(course, new Grade(name, grade, weighting));

            System.out.println("\nIs there another component that you like to enter: Yes (1) or No (2)");
            operation = scanner.nextInt();
            System.out.println();

        } while (operation == 1);

        System.out.println("Your Final Grade Would Be: "
                + percent.format(myGradeList.calculateGradeAverage())
                + " or "
                + myGradeList.convertToLetterGrade(myGradeList.calculateGradeAverage()));
    }

    // MODIFIES: this
    // EFFECTS: processes user input and gathering essential information to calculate target grade
    private void runSetTarget() {
        NumberFormat percent = NumberFormat.getPercentInstance();
        double currentGrade;
        double targetGrade;
        double weighting;

        System.out.println("\n---Setting Target---");

        System.out.print("Enter Your Current Grade: ");
        currentGrade = scanner.nextDouble();
        System.out.print("Enter Your Target Grade: ");
        targetGrade = scanner.nextDouble();
        System.out.print("Enter Your Final Exam Weighting: ");
        weighting = scanner.nextDouble();

        TargetGrade myTargetGrade = new TargetGrade(currentGrade, targetGrade, weighting);

        System.out.println("\nYou need to get "
                + percent.format(((double) myTargetGrade.calculateTarget() / 100))
                + " on your final exam in order to get "
                + percent.format((myTargetGrade.getTargetGrade() / 100))
                + " in this course!");
    }

    // EFFECTS: saves the current calculation to file
    private void saveCurrent() {
        try {
            gradeWriter.startWriting();
            gradeWriter.write(myGradeList);
            gradeWriter.stopWriting();
        } catch (FileNotFoundException e) {
            System.out.println("\nUnable to write to file: " + JSON_DATA);
        }

        if (myGradeList == null) {
            System.out.println("No Calculation Detected: Successfully Saved Null to File");
        } else {
            System.out.println("Successfully saved your "
                    + myGradeList.getCourseName()
                    + " grade calculation to File!");
        }
    }

    // MODIFIES: this
    // EFFECTS: load the previously saved calculation from file
    private void loadPreviouslySaved() {
        NumberFormat percent = NumberFormat.getPercentInstance();
        int componentNumber = 1;

        try {
            myGradeList = gradeReader.startReading();

            System.out.println("\n---Previous Saved Calculation---");
            System.out.println("Course Name: " + myGradeList.getCourseName());

            List<Grade> myComponents = myGradeList.getComponents();
            for (Grade grade : myComponents) {
                System.out.println("\nComponent" + componentNumber + " Name: " + grade.getComponentName());
                System.out.println("Component" + componentNumber + " Grade: " + grade.getComponentGrade());
                System.out.println("Component" + componentNumber + " Weighting: " + grade.getComponentWeighting());
                componentNumber++;
            }

            System.out.println("\nFinal Course Grade: " + percent.format(myGradeList.calculateGradeAverage()));

        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_DATA);
        } catch (JSONException e) {
            System.out.println("Failed to Load: Previous Saved Calculation was found null");
        }
    }

}
