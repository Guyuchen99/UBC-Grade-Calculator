package model;

import java.util.ArrayList;

/**
 * Represents a list of grade components for a course
 */

public class GradeList {
    private ArrayList<Grade> gradeList;

    // EFFECTS: creates a new ArrayList in the constructor
    public GradeList() {
        gradeList = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: add a Grade to the GradeList
    public void addGrade(Grade grade) {
        gradeList.add(grade);
    }

    // EFFECTS: calculate the grade average of every grade component in the ArrayList
    public double calculateGradeAverage() {
        double totalWeight = 0;
        double totalGrade = 0;
        double gradeAverage;

        for (int x = 0; x < gradeList.toArray().length; x++) {
            totalGrade += (gradeList.get(x).getAssignmentGrade()) * (gradeList.get(x).getAssignmentWeighting());
            totalWeight += gradeList.get(x).getAssignmentWeighting();
        }

        gradeAverage = (totalGrade / totalWeight) / 100;
        return gradeAverage;
    }

    // EFFECTS: convert the grade average to a letter grade
    public String convertToLetterGrade() {
        int gradeAverage = (int) Math.round((calculateGradeAverage() * 100));

        if (gradeAverage <= 49) {
            return "F";
        } else if (gradeAverage <= 54) {
            return "D";
        } else if (gradeAverage <= 59) {
            return "C-";
        } else if (gradeAverage <= 63) {
            return "C";
        } else if (gradeAverage <= 67) {
            return "C+";
        } else if (gradeAverage <= 71) {
            return "B-";
        } else if (gradeAverage <= 75) {
            return "B";
        } else if (gradeAverage <= 79) {
            return "B+";
        } else if (gradeAverage <= 84) {
            return  "A-";
        } else if (gradeAverage <= 89) {
            return  "A";
        } else {
            return  "A+";
        }
    }
}
