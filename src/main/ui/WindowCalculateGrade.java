package ui;

import javax.swing.*;
import java.awt.*;

public class WindowCalculateGrade {
    JPanel myPanel;
    JTextField componentNameTextField;
    JTextField componentGradeTextField;
    JTextField componentWeightTextField;
    JLabel componentNameLabel;
    JLabel componentGradeLabel;
    JLabel componentWeightLabel;

    // EFFECTS: creates a new calculate-grade window
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

    // EFFECTS: initializes calculate-grade fields
    private void initializeFields() {
        //myFrame = new JFrame("New Meal");
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

    public JPanel getJPanel() {
        return myPanel;
    }

    // EFFECTS: returns componentNameTextField
    public String getComponentNameTextField() {
        return componentNameTextField.getText();
    }

    // EFFECTS: parses componentName text String and returns double
    public double getComponentGradeTextField() {
        return Double.parseDouble(componentGradeTextField.getText());
    }

    // EFFECTS: parses componentWeight text String and returns double
    public double getComponentWeightTextField() {
        return Double.parseDouble(componentWeightTextField.getText());
    }

}

