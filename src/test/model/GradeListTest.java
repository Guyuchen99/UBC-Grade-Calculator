package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for GradeList class
public class GradeListTest {
    private GradeList myGradeList;
    private Grade myLabGrade;
    private Grade myTestGrade;
    private Grade myExamGrade;

    @BeforeEach
    public void setup() {
        this.myGradeList = new GradeList();
        this.myLabGrade = new Grade("Labs", 100, 25);
        this.myTestGrade = new Grade("Test", 75, 25);
        this.myExamGrade = new Grade("Exams", 90, 50);
    }

    @Test
    public void constructorTest() {
        assertEquals(0, myGradeList.size());
    }

    @Test
    public void addGradeTest() {
        myGradeList.addGrade(myLabGrade);
        assertEquals(1, myGradeList.size());
        myGradeList.addGrade(myTestGrade);
        myGradeList.addGrade(myExamGrade);
        assertEquals(3, myGradeList.size());
    }

    @Test
    public void calculateGradeAverageTest() {
        myGradeList.addGrade(myLabGrade);
        assertEquals(1, myGradeList.calculateGradeAverage());
        myGradeList.addGrade(myTestGrade);
        myGradeList.addGrade(myExamGrade);
        assertEquals(0.8875, myGradeList.calculateGradeAverage());
    }

    @Test
    public void convertToLetterGradeTest() {
        assertEquals("F", myGradeList.convertToLetterGrade(-150));
        assertEquals("F", myGradeList.convertToLetterGrade(0));
        assertEquals("F", myGradeList.convertToLetterGrade(0.494));

        assertEquals("D", myGradeList.convertToLetterGrade(0.495));
        assertEquals("D", myGradeList.convertToLetterGrade(0.52));
        assertEquals("D", myGradeList.convertToLetterGrade(0.544));

        assertEquals("C-", myGradeList.convertToLetterGrade(0.545));
        assertEquals("C-", myGradeList.convertToLetterGrade(0.57));
        assertEquals("C-", myGradeList.convertToLetterGrade(0.594));

        assertEquals("C", myGradeList.convertToLetterGrade(0.595));
        assertEquals("C", myGradeList.convertToLetterGrade(0.62));
        assertEquals("C", myGradeList.convertToLetterGrade(0.634));

        assertEquals("C+", myGradeList.convertToLetterGrade(0.635));
        assertEquals("C+", myGradeList.convertToLetterGrade(0.65));
        assertEquals("C+", myGradeList.convertToLetterGrade(0.674));

        assertEquals("B-", myGradeList.convertToLetterGrade(0.675));
        assertEquals("B-", myGradeList.convertToLetterGrade(0.69));
        assertEquals("B-", myGradeList.convertToLetterGrade(0.714));

        assertEquals("B", myGradeList.convertToLetterGrade(0.715));
        assertEquals("B", myGradeList.convertToLetterGrade(0.73));
        assertEquals("B", myGradeList.convertToLetterGrade(0.754));

        assertEquals("B+", myGradeList.convertToLetterGrade(0.755));
        assertEquals("B+", myGradeList.convertToLetterGrade(0.77));
        assertEquals("B+", myGradeList.convertToLetterGrade(0.794));

        assertEquals("A-", myGradeList.convertToLetterGrade(0.795));
        assertEquals("A-", myGradeList.convertToLetterGrade(0.82));
        assertEquals("A-", myGradeList.convertToLetterGrade(0.844));

        assertEquals("A", myGradeList.convertToLetterGrade(0.845));
        assertEquals("A", myGradeList.convertToLetterGrade(0.87));
        assertEquals("A", myGradeList.convertToLetterGrade(0.894));

        assertEquals("A+", myGradeList.convertToLetterGrade(0.895));
        assertEquals("A+", myGradeList.convertToLetterGrade(0.99));
        assertEquals("A+", myGradeList.convertToLetterGrade(150));
    }

}
