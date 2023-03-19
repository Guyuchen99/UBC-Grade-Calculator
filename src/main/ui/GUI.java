package ui;

import model.Grade;
import model.GradeList;
import model.TargetGrade;
import org.json.JSONException;
import persistence.GradeReader;
import persistence.GradeWriter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;

/**
 * Represents a Graphical User Interface of the Grade Calculator Application
 */
public class GUI extends JFrame implements ActionListener {
    private static final ImageIcon MY_ICON = new ImageIcon("image/GradeCalculator.png");
    private static final ImageIcon CALCULATE_GRADE_ICON = new ImageIcon("image/CalculateGrade.png");
    private static final ImageIcon GRADE_RESULT_ICON = new ImageIcon("image/GradeResult.png");
    private static final ImageIcon SET_TARGET_ICON = new ImageIcon("image/SettingTarget.png");
    private static final ImageIcon TARGET_RESULT_ICON = new ImageIcon("image/TargetResult.png");
    private static final String JSON_DATA = "./data/gradeCalculator.json";
    private static final int WIDTH = 750;
    private static final int HEIGHT = 750;

    private GradeList myGradeList;
    private TargetGrade myTargetGrade;
    private GradeWriter gradeWriter;
    private GradeReader gradeReader;

    private JPanel mainMenu;
    private JPanel myHeader;
    private JPanel myBody;
    private JPanel myFooter;
    private JLabel welcomeLabel;
    private JLabel copyRightLabel;
    private JButton calculateGradeButton;
    private JButton setTargetButton;
    private JButton loadPreviousButton;
    private JButton exitProgramButton;

    // Makes a new JFrame with different attributes
    public GUI() {
        super("Grade Calculator");
        initializeFields();
        initializeMainMenu();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.add(mainMenu);
        this.setVisible(true);
    }

    private void initializeFields() {
        myGradeList = new GradeList();
        gradeWriter = new GradeWriter(JSON_DATA);
        gradeReader = new GradeReader(JSON_DATA);
        mainMenu = new JPanel();
        myHeader = new JPanel();
        myBody = new JPanel();
        myFooter = new JPanel();
        welcomeLabel = new JLabel("Welcome to the UBC Grade Calculator!!!");
        copyRightLabel = new JLabel("Created by a Talented Student at UBC | © 2023 All rights Reserved.");
        calculateGradeButton = new JButton("Calculate Grade");
        setTargetButton = new JButton("Setting Target");
        loadPreviousButton = new JButton("Load Previous Saved Calculation");
        exitProgramButton = new JButton("Exit Program");
    }

    private void initializeMainMenu() {
        initializeWelcomeLabel();
        initializeCopyRightLabel();
        initializeButton(calculateGradeButton);
        initializeButton(setTargetButton);
        initializeButton(loadPreviousButton);
        initializeButton(exitProgramButton);

        initializeMyHeader();
        initializeMyBody();
        initializeMyFooter();

        mainMenu.setLayout(new BorderLayout(5, 5));
        mainMenu.add(myHeader, BorderLayout.NORTH);
        mainMenu.add(myBody, BorderLayout.CENTER);
        mainMenu.add(myFooter, BorderLayout.SOUTH);
        mainMenu.setVisible(true);
    }

    private void initializeButton(JButton b) {
        b.setForeground(Color.WHITE);
        b.setFont(new Font("TimesRoman", Font.BOLD, 20));
        b.addActionListener(this);
        b.setBorder(new EmptyBorder(20, 20, 20, 20));
        b.setBackground(Color.BLACK);
        b.setOpaque(true);
    }

    private void initializeMyHeader() {
        myHeader.setBackground(Color.BLACK);
        myHeader.setBorder(new EmptyBorder(10, 10, 10, 10));
        myHeader.add(welcomeLabel);
    }

    private void initializeMyBody() {
        myBody.setBackground(Color.WHITE);
        myBody.setBorder(new EmptyBorder(10, 10, 10, 10));
        myBody.setLayout(new GridLayout(2, 2, 15, 15));
        myBody.add(calculateGradeButton);
        myBody.add(setTargetButton);
        myBody.add(loadPreviousButton);
        myBody.add(exitProgramButton);
    }

    private void initializeMyFooter() {
        myFooter.setBackground(Color.BLACK);
        myFooter.add(copyRightLabel);
    }

    private void initializeWelcomeLabel() {
        welcomeLabel.setIcon(MY_ICON);
        welcomeLabel.setHorizontalTextPosition(JLabel.CENTER);
        welcomeLabel.setVerticalTextPosition(JLabel.TOP);
        welcomeLabel.setForeground(Color.BLACK);
        welcomeLabel.setBackground(Color.WHITE);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setVerticalAlignment(JLabel.BOTTOM);
        welcomeLabel.setFont(new Font("TimesRoman", Font.BOLD, 40));
        welcomeLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    private void initializeCopyRightLabel() {
        copyRightLabel.setHorizontalAlignment(JLabel.CENTER);
        copyRightLabel.setVerticalAlignment(JLabel.TOP);
        copyRightLabel.setForeground(Color.WHITE);
        copyRightLabel.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        copyRightLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    @SuppressWarnings("methodlength")
    private void calculateGrade() {
        NumberFormat percent = NumberFormat.getPercentInstance();
        int firstOption;
        int secondOption;
        String componentName;
        double componentGrade;
        double componentWeight;
        String[] nextResponse = {"Calculate!!!", "More Components"};
        String[] doneResponse = {"Got It!!!", "Save Current Calculation"};
        myGradeList = new GradeList();

        String courseName = JOptionPane.showInputDialog(null,
                "Enter Your Course Name:  ", "Calculating Grade...", JOptionPane.WARNING_MESSAGE);

        do {
            WindowCalculateGrade myCalculateGradeWindow = new WindowCalculateGrade();
            JPanel myCalculateGradePanel = myCalculateGradeWindow.getJPanel();
            firstOption = JOptionPane.showOptionDialog(null,
                    myCalculateGradePanel, "Calculating Grade...",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,
                    CALCULATE_GRADE_ICON, nextResponse, nextResponse[0]);
            componentName = myCalculateGradeWindow.getComponentNameTextField();
            componentGrade = myCalculateGradeWindow.getComponentGradeTextField();
            componentWeight = myCalculateGradeWindow.getComponentWeightTextField();
            myGradeList.addGrade(courseName, new Grade(componentName, componentGrade, componentWeight));
        } while (firstOption == 1);

        secondOption = JOptionPane.showOptionDialog(null,
                "Your Final Grade Would Be: " + percent.format(myGradeList.calculateGradeAverage())
                        + " or " + myGradeList.convertToLetterGrade(myGradeList.calculateGradeAverage()),
                "Your Result...",
                JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,
                GRADE_RESULT_ICON, doneResponse, doneResponse[0]);

        if (secondOption == 1) {
            saveCalculation();
        }
    }

    private void setTarget() {
        NumberFormat percent = NumberFormat.getPercentInstance();
        String[] nextResponse = {"Calculate!!!"};
        String[] doneResponse = {"Got It!!!"};
        double currentGrade;
        double targetGrade;
        double examWeight;

        WindowSetTarget mySetTargetWindow = new WindowSetTarget();
        JPanel mySetTargetPanel = mySetTargetWindow.getJPanel();
        JOptionPane.showOptionDialog(null,
                mySetTargetPanel, "Setting Target...",
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
                SET_TARGET_ICON, nextResponse, nextResponse[0]);
        currentGrade = mySetTargetWindow.getCurrentGradeTextField();
        targetGrade = mySetTargetWindow.getTargetGradeTextField();
        examWeight = mySetTargetWindow.getExamWeightTextField();

        myTargetGrade = new TargetGrade(currentGrade, targetGrade, examWeight);

        JOptionPane.showOptionDialog(null,
                "You need to get " + percent.format(((double) myTargetGrade.calculateTarget() / 100))
                        + " on your final exam \n    in order to get "
                        + percent.format((myTargetGrade.getTargetGrade() / 100)) + " in this course!",
                "Your Result...",
                JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,
                TARGET_RESULT_ICON, doneResponse, doneResponse[0]);
    }

    private void saveCalculation() {
        try {
            gradeWriter.startWriting();
            gradeWriter.write(myGradeList);
            gradeWriter.stopWriting();
        } catch (FileNotFoundException e) {
            System.out.println("\nUnable to write to file: " + JSON_DATA);
        }
    }

    // EFFECTS: load the previously saved grade calculation from file
    private void loadCalculation() {
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateGradeButton) {
            calculateGrade();
        } else if (e.getSource() == setTargetButton) {
            setTarget();
        } else if (e.getSource() == loadPreviousButton) {
            loadCalculation();
        } else if (e.getSource() == exitProgramButton) {
            System.exit(0);
        }
    }

}
