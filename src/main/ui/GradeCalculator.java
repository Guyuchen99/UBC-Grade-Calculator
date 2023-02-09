package ui;

import model.Grade;
import model.GradeList;
import model.TargetGrade;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Represents a Grade Calculator Console Application
 */

public class GradeCalculator {

    private Scanner scanner;
    private GradeList myGradeList;

    // EFFECTS: runs the grade calculator console application
    public GradeCalculator() {
        scanner = new Scanner(System.in);
        myGradeList = new GradeList();

        runGradeCalculator();
    }

    // EFFECTS: processes user command and run specific methods
    @SuppressWarnings("methodlength")
    private void runGradeCalculator() {
        int operation;

        System.out.println("\nWelcome to the UBC Grade Calculator!!!");

        do  {
            System.out.println("\nPlease Select an Option"
                    + "\n 1. Calculate Grade"
                    + "\n 2. Setting Target"
                    + "\n 3. Quit");
            System.out.print("\nYour Option: ");
            operation = scanner.nextInt();

            if (operation == 3) {
                System.out.println("\nThank you for using the UBC Grade Calculator! \nGoodbye!");

            } else if (operation == 2) {
                runSetTarget();
                if (endProgram()) {
                    System.out.println("\nThank you for using the UBC Grade Calculator! \nGoodbye!");
                    break;
                }

            } else if (operation == 1) {
                runCalculateGrade();
                if (endProgram()) {
                    System.out.println("\nThank you for using the UBC Grade Calculator! \nGoodbye!");
                    break;
                }

            } else {
                System.out.print("\nUnknown Input Detected! Try Again!");
            }

        } while (operation != 3);

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
                System.out.print("\nUnknown Input Detected! Try Again!");
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: processes user input and gathering essential information to calculate grade average
    private void runCalculateGrade() {
        NumberFormat percent = NumberFormat.getPercentInstance();
        String name;
        int operation;
        double grade;
        double weighting;

        System.out.println("\n---Calculating Grade---");

        do {
            System.out.print("Enter Your Component Name: ");
            scanner.nextLine();
            name = scanner.nextLine();
            System.out.print("Enter Your Component Grade: ");
            grade = scanner.nextDouble();
            System.out.print("Enter Your Component Weighting: ");
            weighting = scanner.nextDouble();

            myGradeList.addGrade(new Grade(name, grade, weighting));

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
                + percent.format(((double)myTargetGrade.calculateTarget() / 100))
                + " on your final exam in order to get "
                + percent.format((myTargetGrade.getTargetGrade() / 100))
                + " in this course!");
    }

}
