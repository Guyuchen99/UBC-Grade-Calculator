package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a list of grade components for a course
 */

public class GradeList implements Writable {
    private String courseName;
    private ArrayList<Grade> gradeList;
    private double gradeAverage;

    // EFFECTS: creates a new ArrayList in the constructor
    public GradeList() {
        gradeList = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: add a Grade to the GradeList
    public void addGrade(String courseName, Grade grade) {
        this.courseName = courseName;
        gradeList.add(grade);
    }

    // EFFECTS: calculate the percent grade average of every grade component in the ArrayList
    public double calculateGradeAverage() {
        double totalWeight = 0;
        double totalGrade = 0;

        for (int x = 0; x < gradeList.toArray().length; x++) {
            totalGrade += (gradeList.get(x).getComponentGrade()) * (gradeList.get(x).getComponentWeighting());
            totalWeight += gradeList.get(x).getComponentWeighting();
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

    // EFFECTS: prints the gradeList to a json file
    @Override
    public JSONObject toJson() {
        JSONObject gradeJson = new JSONObject();

        if (courseName == null) {
            return gradeJson;
        }

        gradeJson.put("courseName", courseName);
        gradeJson.put("components", componentsToJson());
        gradeJson.put("courseGrade", gradeAverage);

        return gradeJson;
    }

    // EFFECTS: prints the grade components to a json file
    private JSONArray componentsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Grade myGrade : gradeList) {
            jsonArray.put(myGrade.toJson());
        }

        return jsonArray;
    }

    // EFFECTS: returns an unmodifiable list of thingies in this workroom
    public List<Grade> getComponents() {
        return Collections.unmodifiableList(gradeList);
    }

    // EFFECTS: returns the value of course name
    public String getCourseName() {
        return courseName;
    }

    // EFFECTS: return the amount of grades currently inside the gradeList
    public int size() {
        return gradeList.size();
    }

}
