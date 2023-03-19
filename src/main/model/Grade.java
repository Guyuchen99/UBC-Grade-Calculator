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

    // EFFECTS: prints all the grade components to a json file
    @Override
    public JSONObject toJson() {
        JSONObject gradeJson = new JSONObject();
        gradeJson.put("componentName", componentName);
        gradeJson.put("componentGrade", componentGrade);
        gradeJson.put("componentWeighting", componentWeighting);
        return gradeJson;
    }

    // EFFECTS: return the value of assignment name
    public String getComponentName() {
        return componentName;
    }

    // EFFECTS: return the value of assignment grade
    public double getComponentGrade() {
        return componentGrade;
    }

    // EFFECTS: return the value of assignment weighting
    public double getComponentWeighting() {
        return componentWeighting;
    }

}
