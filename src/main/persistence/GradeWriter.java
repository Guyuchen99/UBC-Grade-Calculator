package persistence;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import model.GradeList;
import org.json.JSONObject;

/**
 * Represents a writer that writes JSON representation of gradeList data to file
 */

public class GradeWriter {
    private static final int TAB = 5;
    private PrintWriter myWriter;
    private String myFile;

    // EFFECTS: constructs a writer that will write data to file
    public GradeWriter(String myFile) {
        this.myFile = myFile;
    }

    // MODIFIES: this
    // EFFECTS: start the writer;
    // throws FileNotFoundException if destination file cannot be opened for writing
    public void startWriting() throws FileNotFoundException {
        myWriter = new PrintWriter((myFile));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of grade to file
    public void write(GradeList myGradeList) {
        JSONObject json = myGradeList.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        myWriter.print(json);
    }

    // MODIFIES: this
    // EFFECTS: closes the writer
    public void stopWriting() {
        myWriter.close();
    }

}
