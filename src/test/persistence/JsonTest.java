package persistence;

import model.Grade;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkGrade(String name, double grade, double weighting, Grade myGrade) {
        assertEquals(name, myGrade.getComponentName());
        assertEquals(grade, myGrade.getComponentGrade());
        assertEquals(weighting, myGrade.getComponentWeighting());
    }
}
