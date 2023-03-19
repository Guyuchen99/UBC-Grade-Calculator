package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Saved Calculation Popup Window
 */

public class WindowDisplaySaved {
    private JPanel myMainPanel;
    private JPanel myTopPanel;
    private JPanel myBodyPanel;
    private JPanel myLabelPanel;

    private JLabel courseNameLabel;
    private List<JLabel> myNameLabels;
    private List<JLabel> myGradeLabels;
    private List<JLabel> myWeightLabels;
    private JLabel finalGradeLabel;

    // EFFECTS: creates a new saved calculation window
    public WindowDisplaySaved() {
        myMainPanel = new JPanel();

        initializeFields();

        myMainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        myMainPanel.setLayout(new BoxLayout(myMainPanel, BoxLayout.Y_AXIS));
        myMainPanel.setBackground(Color.BLACK);
        myMainPanel.add(myTopPanel);
        myMainPanel.add(myBodyPanel);
    }

    // EFFECTS: initializes saved calculation fields
    private void initializeFields() {
        initializeCourseNameLabel();
        initializeFinalGradeLabel();
        initializeTopPanel();
        initializeLabelPanel();
        initializeBodyPanel();

        myNameLabels = new ArrayList<>();
        myGradeLabels = new ArrayList<>();
        myWeightLabels = new ArrayList<>();
    }

    // EFFECTS: initializes myTopPanel fields
    private void initializeTopPanel() {
        myTopPanel = new JPanel();
        myTopPanel.setBackground(Color.WHITE);
        myTopPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        myTopPanel.add(courseNameLabel);
    }

    // EFFECTS: initializes myBodyPanel fields
    private void initializeBodyPanel() {
        myBodyPanel = new JPanel();
        myBodyPanel.setBackground(Color.BLACK);
        myBodyPanel.add(myLabelPanel);
    }

    // EFFECTS: initializes myLabelPanel fields
    private void initializeLabelPanel() {
        myLabelPanel = new JPanel();
        myLabelPanel.setLayout(new BoxLayout(myLabelPanel, BoxLayout.Y_AXIS));
        myLabelPanel.setBackground(Color.WHITE);
    }

    // EFFECTS: initializes courseNameLabel fields
    private void initializeCourseNameLabel() {
        courseNameLabel = new JLabel();
        courseNameLabel.setHorizontalAlignment(JLabel.CENTER);
        courseNameLabel.setVerticalAlignment(JLabel.CENTER);
        courseNameLabel.setForeground(Color.BLACK);
        courseNameLabel.setFont(new Font("TimesRoman", Font.BOLD, 20));
        courseNameLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
    }

    // EFFECTS: initializes finalGradeLabel fields
    private void initializeFinalGradeLabel() {
        finalGradeLabel = new JLabel();
        finalGradeLabel.setHorizontalAlignment(JLabel.LEFT);
        finalGradeLabel.setVerticalAlignment(JLabel.CENTER);
        finalGradeLabel.setForeground(Color.BLACK);
        finalGradeLabel.setFont(new Font("TimesRoman", Font.BOLD, 20));
        finalGradeLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    // EFFECTS: initializes each JLabel inside myNameLabels, myGradeLabels, myWeightLabels,
    // and add them to myLabelPane
    private void addJLabelToPanel() {
        for (int i = 0; i < myNameLabels.size(); i++) {
            myNameLabels.get(i).setHorizontalAlignment(JLabel.LEFT);
            myNameLabels.get(i).setVerticalAlignment(JLabel.CENTER);
            myNameLabels.get(i).setForeground(Color.BLACK);
            myNameLabels.get(i).setFont(new Font("TimesRoman", Font.PLAIN, 15));
            myNameLabels.get(i).setBorder(new EmptyBorder(10, 10, 10, 10));
            myLabelPanel.add(myNameLabels.get(i));

            myGradeLabels.get(i).setHorizontalAlignment(JLabel.LEFT);
            myGradeLabels.get(i).setVerticalAlignment(JLabel.CENTER);
            myGradeLabels.get(i).setForeground(Color.BLACK);
            myGradeLabels.get(i).setFont(new Font("TimesRoman", Font.PLAIN, 15));
            myGradeLabels.get(i).setBorder(new EmptyBorder(10, 10, 10, 10));
            myLabelPanel.add(myGradeLabels.get(i));

            myWeightLabels.get(i).setHorizontalAlignment(JLabel.LEFT);
            myWeightLabels.get(i).setVerticalAlignment(JLabel.CENTER);
            myWeightLabels.get(i).setForeground(Color.BLACK);
            myWeightLabels.get(i).setFont(new Font("TimesRoman", Font.PLAIN, 15));
            myWeightLabels.get(i).setBorder(new EmptyBorder(10, 10, 20, 10));
            myLabelPanel.add(myWeightLabels.get(i));
        }
        myLabelPanel.add(finalGradeLabel);
    }

    // EFFECTS: add each label component to myLabelPanel before returning the myMainPanel Panel
    public JPanel getJPanel() {
        addJLabelToPanel();
        return myMainPanel;
    }

    // EFFECTS: set courseNameLabel with provided name
    public void setCourseNameLabel(String s) {
        courseNameLabel.setText("Your \"" + s + "\" Calculation");
    }

    // EFFECTS: set myNameLabel with provided name
    public void setNameLabel(int number, String string) {
        myNameLabels.add(new JLabel("Component" + number + " Name: " + string));
    }

    // EFFECTS: set myGradeLabel with provided name
    public void setGradeLabel(int number, double value) {
        myGradeLabels.add(new JLabel("Component" + number + " Grade: " + value));
    }

    // EFFECTS: set myWeightLabel with provided name
    public void setWeightLabel(int number, double value) {
        myWeightLabels.add(new JLabel("Component" + number + " Weight: " + value));
    }

    // EFFECTS: set finalGradeLabel with provided name
    public void setFinalGradeLabel(String string) {
        finalGradeLabel.setText("Your Final Course Grade is " + string + "!");
    }

}
