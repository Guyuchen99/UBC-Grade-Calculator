package ui;

import javax.swing.*;
import java.awt.*;

/**
 * Represents a Set Target Popup Window
 */

public class WindowSetTarget {
    private JPanel myPanel;
    private JTextField currentGradeTextField;
    private JTextField targetGradeTextField;
    private JTextField examWeightTextField;
    private JLabel currentGradeLabel;
    private JLabel targetGradeLabel;
    private JLabel examWeightLabel;

    // EFFECTS: creates a new set target window
    public WindowSetTarget() {
        initializeFields();

        myPanel.add(currentGradeLabel);
        myPanel.add(currentGradeTextField);
        myPanel.add(targetGradeLabel);
        myPanel.add(targetGradeTextField);
        myPanel.add(examWeightLabel);
        myPanel.add(examWeightTextField);

        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
        myPanel.setMinimumSize(new Dimension(250,125));
        myPanel.setPreferredSize(new Dimension(250,125));
    }

    // EFFECTS: initializes set target window fields
    private void initializeFields() {
        myPanel = new JPanel();

        currentGradeLabel = new JLabel("Enter Your Current Grade: ");
        targetGradeLabel = new JLabel("Enter Your Target Grade: ");
        examWeightLabel = new JLabel("Enter Your Final Exam Weighting: ");

        currentGradeTextField = new JTextField();
        currentGradeTextField.setMaximumSize(new Dimension(500, 25));
        targetGradeTextField = new JTextField();
        targetGradeTextField.setMaximumSize(new Dimension(500, 25));
        examWeightTextField = new JTextField();
        examWeightTextField.setMaximumSize(new Dimension(500, 25));
    }

    // EFFECTS: return the myPanel JPanel
    public JPanel getJPanel() {
        return myPanel;
    }

    // EFFECTS: parses currentGradeTextField into a double and return it
    public double getCurrentGradeTextField() {
        return Double.parseDouble(currentGradeTextField.getText());
    }

    // EFFECTS: parses targetGradeTextField into a double and return it
    public double getTargetGradeTextField() {
        return Double.parseDouble(targetGradeTextField.getText());
    }

    // EFFECTS: parses examWeightTextField into a double and return it
    public double getExamWeightTextField() {
        return Double.parseDouble(examWeightTextField.getText());
    }

}
