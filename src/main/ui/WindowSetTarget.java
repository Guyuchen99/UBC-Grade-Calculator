package ui;

import javax.swing.*;
import java.awt.*;

public class WindowSetTarget {
    JPanel myPanel;
    JTextField currentGradeTextField;
    JTextField targetGradeTextField;
    JTextField examWeightTextField;
    JLabel currentGradeLabel;
    JLabel targetGradeLabel;
    JLabel examWeightLabel;

    // EFFECTS: creates a new set-target window
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

    // EFFECTS: initializes set-target fields
    private void initializeFields() {
        //myFrame = new JFrame("New Meal");
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

    public JPanel getJPanel() {
        return myPanel;
    }

    // EFFECTS: return parsed currentGradeTextField as a double
    public double getCurrentGradeTextField() {
        return Double.parseDouble(currentGradeTextField.getText());
    }

    // EFFECTS: return parsed targetGradeTextField as a double
    public double getTargetGradeTextField() {
        return Double.parseDouble(targetGradeTextField.getText());
    }

    // EFFECTS: return parsed examWeightTextField as a double
    public double getExamWeightTextField() {
        return Double.parseDouble(examWeightTextField.getText());
    }
}
