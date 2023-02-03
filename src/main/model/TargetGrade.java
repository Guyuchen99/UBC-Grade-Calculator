package model;

/**
 * Represents a realistic target that the user desires
 */

public class TargetGrade {

    private double currentGrade;
    private double targetGrade;
    private double examWeighting;

    // EFFECTS: gathering essential information to calculate a target grade
    public TargetGrade(double current, double grade, double weighting){
        this.currentGrade = current;
        this.targetGrade = grade;
        this.examWeighting = weighting;
    }

    // Getters
    public double getCurrentGrade() {
        return currentGrade;
    }
    public double getTargetGrade() {
        return targetGrade;
    }
    public double getExamWeighting() {
        return examWeighting;
    }

    // EFFECTS: calculate the target grade
    public double calculateTarget() {
        return ((targetGrade - (1 - examWeighting) * currentGrade) / examWeighting);
    }

}
