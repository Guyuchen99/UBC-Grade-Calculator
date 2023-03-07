package persistence;

import model.Grade;
import model.GradeList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// Unit tests for GradeReader class
public class GradeReaderTest extends JsonTest{
    private static final String JSON_DATA = "./data/gradeReaderTest.json";
    private GradeReader gradeReader;

    @BeforeEach
    public void setup() {
        this.gradeReader = new GradeReader(JSON_DATA);
    }

    @Test
    void readeNonExistentFileTest() {
        GradeReader gradeReader = new GradeReader("./data/nonExistentFile.json");
        try {
            GradeList myGradeList = gradeReader.startReading();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void readGeneralWorkRoomTest() {
        try {
            GradeList myGradeList = gradeReader.startReading();
            assertEquals("CPSC 210", myGradeList.getCourseName());
            List<Grade> components = myGradeList.getComponents();
            assertEquals(2, myGradeList.size());
            checkGrade("Labs", 100, 15, components.get(0));
            checkGrade("Exams", 80, 85, components.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
