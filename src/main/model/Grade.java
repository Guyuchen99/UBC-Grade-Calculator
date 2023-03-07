package model;

import org.json.JSONObject;
import persistence.Writable;

/**
 * Represents a grade component for a course
 */

public class Grade implements Writable {
    private String componentName;
    private double componentGrade;
    private double componentWeighting;

    // REQUIRES: grade <= 100
    // EFFECTS: creates a new grade component with its given name, grade, and weighting
    public Grade(String name, double grade, double weighting) {
        this.componentName = name;
        this.componentGrade = grade;
        this.componentWeighting = weighting;
    }

    // EFFECTS: return the assignment name of this grade component
    public String getComponentName() {
        return componentName;
    }

    // EFFECTS: return the assignment grade of this grade component
    public double getComponentGrade() {
        return componentGrade;
    }

    // EFFECTS: return the assignment weighting of this grade component
    public double getComponentWeighting() {
        return componentWeighting;
    }

    // EFFECTS: prints all the grade components to a json file
    @Override
    public JSONObject toJson() {
        JSONObject gradeJson = new JSONObject();
        gradeJson.put("componentName", componentName);
        gradeJson.put("componentGrade", componentGrade);
        gradeJson.put("componentWeighting", componentWeighting);
        return gradeJson;
    }

}
