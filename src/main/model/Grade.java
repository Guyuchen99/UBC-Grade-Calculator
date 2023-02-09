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

    // EFFECTS: return the assignment name of this grade component
    public String getAssignmentName() {
        return assignmentName;
    }

    // EFFECTS: return the assignment grade of this grade component
    public double getAssignmentGrade() {
        return assignmentGrade;
    }

    // EFFECTS: return the assignment weighting of this grade component
    public double getAssignmentWeighting() {
        return assignmentWeighting;
    }

}
