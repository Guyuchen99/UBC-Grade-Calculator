package ui;

import java.io.FileNotFoundException;

/**
 * Used to run the Grade Calculator
 */

public class Main {
    public static void main(String[] args) {
        try {
            new GradeCalculator();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to Run Application: File Not Found");
        }
    }
}
