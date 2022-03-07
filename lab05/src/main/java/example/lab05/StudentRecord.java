package example.lab05;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

public class StudentRecord {
    public String studentID;
    public float midterm;
    public float assignments;
    public float finalExam;
    public float finalMark;
    public String letterGrade;

    public StudentRecord(String studentID, float midterm, float assignments, float finalExam) {
        this.studentID = studentID;
        this.midterm = midterm;
        this.assignments = assignments;
        this.finalExam = finalExam;
        this.finalMark = (midterm*0.3f + assignments*0.2f+finalExam*0.5f);
        this.letterGrade = (findGrade(midterm*0.3 + assignments*0.2+finalExam*0.5));
    }

    public String findGrade(double mark) {

        int numberGrade = (int) Math.round(mark);
        int quotient = numberGrade / 10;

        switch (quotient) {
            case 10:
            case 8:
            case 9:
                return "A";
            case 7:
                return "B";
            case 6:
                return "C";
            case 5:
                return "D";
            default:
                return "F";
        }
    }

    public String getStudentID() {
        return studentID;
    }

    public float getMidterm() {
        return midterm;
    }

    public float getAssignments() {
        return assignments;
    }

    public float getFinalExam() {
        return finalExam;
    }

    public float getFinalMark() {
        return finalMark;
    }

    public String getLetterGrade() {
        return letterGrade;
    }
}
