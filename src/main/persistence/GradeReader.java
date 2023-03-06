package persistence;

import model.Grade;
import model.GradeList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Represents a reader that reads gradeList from JSON data stored in file
 */

public class GradeReader {

    private String dataSource;
    private String courseName;

    // EFFECTS: constructs a reader to read from the given source file
    public GradeReader (String dataSource) {
        this.dataSource = dataSource;
    }

    // EFFECTS: reads GradeList from file and returns it;
    // throws IOException if an error occurs reading data from file
    public GradeList startReading() throws IOException {
        String jsonData = readFile(dataSource);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseGradeList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String dataSource) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(dataSource), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private GradeList parseGradeList(JSONObject jsonObject) {
        courseName = jsonObject.getString("courseName");
        GradeList myGradeList = new GradeList();
        addComponents(myGradeList, jsonObject);
        return myGradeList;
    }

    // MODIFIES: myGradeList
    // EFFECTS: parses components from JSON object and adds them to GradeList
    private void addComponents(GradeList myGradeList, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("components");
        for (Object jsonComponent : jsonArray) {
            JSONObject nextComponent = (JSONObject) jsonComponent;
            addComponent(myGradeList, nextComponent);
        }
    }

    // MODIFIES: myGradeList
    // EFFECTS: parses each component inside components from JSON object and adds it to GradeList
    private void addComponent(GradeList myGradeList, JSONObject jsonObject) {
        String name = jsonObject.getString("componentName");
        Double grade = jsonObject.getDouble("componentGrade");
        Double weighting = jsonObject.getDouble("componentWeighting");

        Grade myGrade = new Grade(name, grade, weighting);
        myGradeList.addGrade(courseName,myGrade);
    }

    public String getCourseName() {
        return courseName;
    }

}