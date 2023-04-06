package model;

/**
 * Represents a realistic target that the user desires
 */

public class TargetGrade {
    private double currentGrade;
    private double targetGrade;
    private double examWeighting;

    // EFFECTS: gathering essential information to calculate a target grade
    public TargetGrade(double current, double grade, double weighting) {
        this.currentGrade = current;
        this.targetGrade = grade;
        this.examWeighting = weighting;
    }

    // EFFECTS: calculate the target grade
    public int calculateTarget() {
        double currentPercentage = currentGrade / 100;
        double targetPercentage = targetGrade / 100;
        double examPercentage = examWeighting / 100;

        EventLog.getInstance().logEvent(new Event("Added Current Grade of " + currentGrade
                + "% with Target Grade of " + targetGrade
                + "% with Exam Weighting of " + examWeighting + "%"));
        EventLog.getInstance().logEvent(new Event("Grade Target Calculated!"));
        return (int)Math.round(((targetPercentage - (1 - examPercentage) * currentPercentage) / examPercentage) * 100);
    }

    // EFFECTS: return the value of current grade
    public double getCurrentGrade() {
        return currentGrade;
    }

    // EFFECTS: return the value of target grade
    public double getTargetGrade() {
        return targetGrade;
    }

    // EFFECTS: return the value of exam weighting
    public double getExamWeighting() {
        return examWeighting;
    }

}
