package model;

import java.util.ArrayList;

/**
 * Represents a list of grade components for a course
 */

public class GradeList {
    private ArrayList<Grade> gradeList;
    private double gradeAverage;

    // EFFECTS: creates a new ArrayList in the constructor
    public GradeList() {
        gradeList = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: add a Grade to the GradeList
    public void addGrade(Grade grade) {
        gradeList.add(grade);
    }

    // EFFECTS: calculate the percent grade average of every grade component in the ArrayList
    public double calculateGradeAverage() {
        double totalWeight = 0;
        double totalGrade = 0;

        for (int x = 0; x < gradeList.toArray().length; x++) {
            totalGrade += (gradeList.get(x).getAssignmentGrade()) * (gradeList.get(x).getAssignmentWeighting());
            totalWeight += gradeList.get(x).getAssignmentWeighting();
        }

        gradeAverage = (totalGrade / totalWeight) / 100;
        return gradeAverage;
    }

    // REQUIRES: gradeAverage as a percentage
    // EFFECTS: convert the percent grade average to a letter grade
    @SuppressWarnings("methodlength")
    public String convertToLetterGrade(double gradeAverage) {
        int roundedGradeAverage = (int)Math.round(gradeAverage * 100);

        if (roundedGradeAverage <= 49) {
            return "F";
        } else if (roundedGradeAverage <= 54) {
            return "D";
        } else if (roundedGradeAverage <= 59) {
            return "C-";
        } else if (roundedGradeAverage <= 63) {
            return "C";
        } else if (roundedGradeAverage <= 67) {
            return "C+";
        } else if (roundedGradeAverage <= 71) {
            return "B-";
        } else if (roundedGradeAverage <= 75) {
            return "B";
        } else if (roundedGradeAverage <= 79) {
            return "B+";
        } else if (roundedGradeAverage <= 84) {
            return  "A-";
        } else if (roundedGradeAverage <= 89) {
            return  "A";
        } else {
            return  "A+";
        }
    }

    // EFFECTS: return the amount of grades currently in the gradeList
    public int size() {
        return gradeList.size();
    }

}
