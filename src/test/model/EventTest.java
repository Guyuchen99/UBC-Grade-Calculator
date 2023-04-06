package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for Event class
public class EventTest {
    private Event event1;
    private Event event2;
    private Event event3;
    private Date date1;

    //NOTE: these tests might fail if time at which line (2) below is executed
    //is different from time that line (1) is executed.  Lines (1) and (2) must
    //run in same millisecond for this test to make sense and pass.

    @BeforeEach
    public void runBefore() {
        event1 = new Event("Grade Average Calculated!");   // (1)
        event2 = new Event("Grade Average Calculated!");
        event3 = new Event("Grade Calculation Saved!");
        date1 = Calendar.getInstance().getTime();   // (2)
    }

    @Test
    public void testEvent() {
        assertEquals("Grade Average Calculated!", event1.getDescription());
        assertTrue(date1.getTime() - event1.getDate().getTime() <= 10);
    }

    @Test
    public void testToString() {
        assertEquals(date1.toString() + "\n" + "Grade Average Calculated!", event1.toString());
    }

    @Test
    public void testEquals() {
        assertFalse(event1.equals(null));
        assertFalse(event1.equals("Grade Calculation Saved!"));
    }

    @Test
    void hashCodeTest() {
        assertTrue(event1.hashCode() - event2.hashCode() <= 10);
        assertFalse(event1.hashCode() - event3.hashCode() <= 10);
    }
}
