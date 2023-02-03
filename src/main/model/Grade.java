package model;

/**
 * Represents a grade component for a course
 */

public class Grade {

    private String assignmentName;
    private double assignmentGrade;
    private double assignmentWeighting;

    // REQUIRES: grade <= 100
    // EFFECTS: creates a new grade component with its given name, grade, and weighting
    public Grade(String name, double grade, double weighting) {
        this.assignmentName = name;
        this.assignmentGrade = grade;
        this.assignmentWeighting = weighting;
    }

    // Getters
    public String getAssignmentName() {
        return assignmentName;
    }

    public double getAssignmentGrade() {
        return assignmentGrade;
    }

    public double getAssignmentWeighting() {
        return assignmentWeighting;
    }

}
