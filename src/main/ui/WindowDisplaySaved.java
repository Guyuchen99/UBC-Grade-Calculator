package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class WindowDisplaySaved {
    JPanel myMainPanel;
    JPanel myTopPanel;
    JPanel myBodyPanel;
    JPanel labelPanel;

    JLabel courseNameLabel;
    JLabel finalGradeLabel;

    List<JLabel> myNameLabels;
    List<JLabel> myGradeLabels;
    List<JLabel> myWeightLabels;

    public WindowDisplaySaved() {
        initializeFields();
        initializeMainPanel();

        myMainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        myMainPanel.setLayout(new BoxLayout(myMainPanel, BoxLayout.Y_AXIS));
        myMainPanel.setBackground(Color.BLACK);
        myMainPanel.add(myTopPanel);
        myMainPanel.add(myBodyPanel);
    }

    private void initializeFields() {
        myMainPanel = new JPanel();
        myBodyPanel = new JPanel();
        myTopPanel = new JPanel();
        labelPanel = new JPanel();
        courseNameLabel = new JLabel();
        finalGradeLabel = new JLabel();
        myNameLabels = new ArrayList<>();
        myGradeLabels = new ArrayList<>();
        myWeightLabels = new ArrayList<>();
    }

    private void initializeMainPanel() {
        initializeCourseNameLabel();
        initializeFinalGradeLabel();
        initializeTopPanel();
        initializeBodyPanel();
    }

    private void initializeTopPanel() {
        myTopPanel.setBackground(Color.WHITE);
        myTopPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        myTopPanel.add(courseNameLabel);
    }

    private void initializeBodyPanel() {
        myBodyPanel.setBackground(Color.BLACK);
        myBodyPanel.add(labelPanel);
    }

    private void initializeCourseNameLabel() {
        courseNameLabel.setHorizontalAlignment(JLabel.CENTER);
        courseNameLabel.setVerticalAlignment(JLabel.CENTER);
        courseNameLabel.setForeground(Color.BLACK);
        courseNameLabel.setFont(new Font("TimesRoman", Font.BOLD, 20));
        courseNameLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
    }

    private void initializeFinalGradeLabel() {
        finalGradeLabel.setHorizontalAlignment(JLabel.LEFT);
        finalGradeLabel.setVerticalAlignment(JLabel.CENTER);
        finalGradeLabel.setForeground(Color.BLACK);
        finalGradeLabel.setFont(new Font("TimesRoman", Font.BOLD, 20));
        finalGradeLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    private void addJLabelToPanel() {
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
        labelPanel.setBackground(Color.WHITE);

        for (int i = 0; i < myNameLabels.size(); i++) {
            myNameLabels.get(i).setHorizontalAlignment(JLabel.LEFT);
            myNameLabels.get(i).setVerticalAlignment(JLabel.CENTER);
            myNameLabels.get(i).setForeground(Color.BLACK);
            myNameLabels.get(i).setFont(new Font("TimesRoman", Font.PLAIN, 15));
            myNameLabels.get(i).setBorder(new EmptyBorder(10, 10, 10, 10));
            labelPanel.add(myNameLabels.get(i));

            myGradeLabels.get(i).setHorizontalAlignment(JLabel.LEFT);
            myGradeLabels.get(i).setVerticalAlignment(JLabel.CENTER);
            myGradeLabels.get(i).setForeground(Color.BLACK);
            myGradeLabels.get(i).setFont(new Font("TimesRoman", Font.PLAIN, 15));
            myGradeLabels.get(i).setBorder(new EmptyBorder(10, 10, 10, 10));
            labelPanel.add(myGradeLabels.get(i));

            myWeightLabels.get(i).setHorizontalAlignment(JLabel.LEFT);
            myWeightLabels.get(i).setVerticalAlignment(JLabel.CENTER);
            myWeightLabels.get(i).setForeground(Color.BLACK);
            myWeightLabels.get(i).setFont(new Font("TimesRoman", Font.PLAIN, 15));
            myWeightLabels.get(i).setBorder(new EmptyBorder(10, 10, 20, 10));
            labelPanel.add(myWeightLabels.get(i));
        }
        labelPanel.add(finalGradeLabel);
    }

    public JPanel getJPanel() {
        addJLabelToPanel();
        return myMainPanel;
    }

    public void setCourseNameLabel(String s) {
        courseNameLabel.setText("Your \"" + s + "\" Calculation");
    }

    public void setNameLabel(int number, String string) {
        myNameLabels.add(new JLabel("Component" + number + " Name: " + string));
    }

    public void setGradeLabel(int number, double value) {
        myGradeLabels.add(new JLabel("Component" + number + " Grade: " + value));
    }

    public void setWeightLabel(int number, double value) {
        myWeightLabels.add(new JLabel("Component" + number + " Weight: " + value));
    }

    public void setFinalGradeLabel(String string) {
        finalGradeLabel.setText("Your Final Course Grade is " + string + "!");
    }

}
