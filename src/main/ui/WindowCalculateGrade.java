package ui;

import javax.swing.*;
import java.awt.*;

/**
 * Represents a Calculate Grade Popup Window
 */

public class WindowCalculateGrade {
    private JPanel myPanel;
    private JTextField componentNameTextField;
    private JTextField componentGradeTextField;
    private JTextField componentWeightTextField;
    private JLabel componentNameLabel;
    private JLabel componentGradeLabel;
    private JLabel componentWeightLabel;

    // EFFECTS: creates a new calculate grade window
    public WindowCalculateGrade() {
        initializeFields();

        myPanel.add(componentNameLabel);
        myPanel.add(componentNameTextField);
        myPanel.add(componentGradeLabel);
        myPanel.add(componentGradeTextField);
        myPanel.add(componentWeightLabel);
        myPanel.add(componentWeightTextField);

        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
        myPanel.setMinimumSize(new Dimension(250,125));
        myPanel.setPreferredSize(new Dimension(250,125));
    }

    // EFFECTS: initializes calculate grade window fields
    private void initializeFields() {
        myPanel = new JPanel();

        componentNameLabel = new JLabel("Enter Your Component Name: ");
        componentGradeLabel = new JLabel("Enter Your Component Grade: ");
        componentWeightLabel = new JLabel("Enter Your Component Weighting: ");

        componentNameTextField = new JTextField();
        componentNameTextField.setMaximumSize(new Dimension(500, 25));
        componentGradeTextField = new JTextField();
        componentGradeTextField.setMaximumSize(new Dimension(500, 25));
        componentWeightTextField = new JTextField();
        componentWeightTextField.setMaximumSize(new Dimension(500, 25));
    }

    // EFFECTS: return the myPanel JPanel
    public JPanel getJPanel() {
        return myPanel;
    }

    // EFFECTS: returns the componentNameTextField TextField
    public String getComponentNameTextField() {
        return componentNameTextField.getText();
    }

    // EFFECTS: parses componentNameTextField into a double and return it
    public double getComponentGradeTextField() {
        return Double.parseDouble(componentGradeTextField.getText());
    }

    // EFFECTS: parses componentWeightTextField into a double and return it
    public double getComponentWeightTextField() {
        return Double.parseDouble(componentWeightTextField.getText());
    }

}
