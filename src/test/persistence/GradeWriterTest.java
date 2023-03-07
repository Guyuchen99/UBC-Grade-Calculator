package persistence;

import model.Grade;
import model.GradeList;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GradeWriterTest extends JsonTest {

    private static final String JSON_DATA = "./data/gradeWriterTest.json";
    private GradeWriter gradeWriter;
    private GradeReader gradeReader;
    private String courseName;
    private GradeList myGradeList;
    private Grade labGrade;
    private Grade testGrade;
    private Grade examGrade;

    @BeforeEach
    public void setup() {
        this.gradeWriter = new GradeWriter(JSON_DATA);
        this.gradeReader = new GradeReader(JSON_DATA);
        this.courseName = "CPSC 210";
        this.myGradeList = new GradeList();
        this.labGrade = new Grade("Labs", 100, 25);
        this.testGrade = new Grade("Test", 75, 25);
        this.examGrade = new Grade("Exams", 90, 50);
    }


    @Test
    public void startWritingInvalidFileTest() {
        try {
            GradeWriter gradeWriter = new GradeWriter("./data/illegal\0FileName.json");
            gradeWriter.startWriting();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void writeEmptyGradeListTest() {
        try {
            gradeWriter.startWriting();
            gradeWriter.write(myGradeList);
            gradeWriter.stopWriting();

            myGradeList = gradeReader.startReading();
            fail("JSONException was expected");
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        } catch (JSONException e) {
            // pass
        }
    }

    @Test
    void writeGeneralGradeListTest() throws IOException {
        myGradeList.addGrade(courseName, labGrade);
        myGradeList.addGrade(courseName, testGrade);
        myGradeList.addGrade(courseName, examGrade);

        gradeWriter.startWriting();
        gradeWriter.write(myGradeList);
        gradeWriter.stopWriting();

        myGradeList = gradeReader.startReading();
        assertEquals(courseName, myGradeList.getCourseName());
        List<Grade> components = myGradeList.getComponents();
        assertEquals(3, components.size());
        checkGrade(labGrade.getComponentName(), labGrade.getComponentGrade(),
                labGrade.getComponentWeighting(), components.get(0));
        checkGrade(testGrade.getComponentName(), testGrade.getComponentGrade(),
                testGrade.getComponentWeighting(), components.get(1));
        checkGrade(examGrade.getComponentName(), examGrade.getComponentGrade(),
                examGrade.getComponentWeighting(), components.get(2));
    }
}
