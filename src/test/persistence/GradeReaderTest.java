package persistence;

import model.GradeList;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.fail;

public class GradeReaderTest extends JsonTest{

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

    /*
    @Test
    void readEmptyWorkRoomTest() {
        GradeReader gradeReader = new GradeReader("./data/readEmptyWorkRoomTest.json");
        try {
            GradeList myGradeList = gradeReader.startReading();
            assertEquals(null, myGradeList.getCourseName());
            assertEquals(0, myGradeList.getComponents());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
     */


    /*
    @Test
    void readGeneralWorkRoomTest() {
        GradeReader gradeReader = new GradeReader("./data/readGeneralyWorkRoomTest.json");
        try {
            GradeList myGradeList = gradeReader.startReading();
            assertEquals(courseName, myGradeList.getCourseName());
            List<Grade> components = myGradeList.getComponents();
            assertEquals(3, myGradeList.size());
            checkGrade(labGrade.getComponentName(), labGrade.getComponentGrade(),
                    labGrade.getComponentWeighting(), components.get(0));
            checkGrade(testGrade.getComponentName(), testGrade.getComponentGrade(),
                    testGrade.getComponentWeighting(), components.get(1));
            checkGrade(examGrade.getComponentName(), examGrade.getComponentGrade(),
                    examGrade.getComponentWeighting(), components.get(2));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
    */
}
