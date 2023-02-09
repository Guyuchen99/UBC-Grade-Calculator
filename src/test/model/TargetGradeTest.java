package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TargetGradeTest {
    private TargetGrade myTargetGrade;

    @BeforeEach
    public void setup() {
        this.myTargetGrade = new TargetGrade(80, 75, 25);
    }

    @Test
    public void constructorTest() {
        assertEquals(80, myTargetGrade.getCurrentGrade());
        assertEquals(75, myTargetGrade.getTargetGrade());
        assertEquals(25, myTargetGrade.getExamWeighting());
    }

    @Test
    public void calculateTargetTest() {
        assertEquals(60, myTargetGrade.calculateTarget());
    }
}
