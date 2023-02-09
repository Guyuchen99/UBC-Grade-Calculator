package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for Grade class
public class GradeTest {
    private Grade myGrade;

    @BeforeEach
    public void setup() {
        this.myGrade = new Grade("Exams", 95, 100);
    }

    @Test
    public void constructorTest() {
        assertEquals("Exams", myGrade.getAssignmentName());
        assertEquals(95, myGrade.getAssignmentGrade());
        assertEquals(100, myGrade.getAssignmentWeighting());
    }
}
