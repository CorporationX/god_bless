package bjs2_68775;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import school.faang.bjs2_68775.Student;
import school.faang.bjs2_68775.StudentDatabase;
import school.faang.bjs2_68775.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StudentDatabaseTest {
    private static StudentDatabase studentDatabase;
    private static Student student;
    private static Student student2;
    private static Subject subject;
    private static Subject subject2;
    private static int score;
    private static List<Student> students;

    @BeforeAll
    public static void init() {
        studentDatabase = new StudentDatabase();
        student = new Student("Alena");
        student2 = new Student("Alex");
        subject = new Subject("Algebra");
        subject2 = new Subject("English");
        score = 5;
        students = new ArrayList<>();
        students.add(student);
        students.add(student2);
    }

    @Test
    public void addStudentInfoTest() {
        Map<Subject, Integer> subjects = Map.of(subject, score);
        studentDatabase.addStudentInfo(student, subjects);
        assertEquals(studentDatabase.getStudentSubjects().get(student), subjects);
        assertEquals(studentDatabase.getSubjectStudents().get(subject), List.of(student));
    }

    @Test
    public void addSubjectByStudentTest() {
        Map<Subject, Integer> subjects = new HashMap<>();
        subjects.put(subject, score);
        studentDatabase.addStudentInfo(student, subjects);
        studentDatabase.addSubjectByStudent(student, subject2, score);
        subjects.put(subject2, score);
        assertEquals(studentDatabase.getStudentSubjects().get(student), subjects);
    }

    @Test
    public void removeStudentAndPrintAllStudentsInfoTest() {
        Map<Subject, Integer> subjects = new HashMap<>();
        subjects.put(subject2, score);
        studentDatabase.addStudentInfo(student, subjects);
        studentDatabase.addStudentInfo(student2, subjects);
        studentDatabase.printAllStudentsInfo();
        studentDatabase.removeStudent(student2);
        studentDatabase.printAllStudentsInfo();
        assertNull(studentDatabase.getStudentSubjects().get(student2));
        assertEquals(studentDatabase.getSubjectStudents().get(subject), List.of(student));
    }

    @Test
    public void addSubjectInfoInfoTest() {
        studentDatabase.addSubjectInfo(subject2, students);
        assertEquals(studentDatabase.getSubjectStudents().get(subject2), students);
    }

    @Test
    public void addStudentBySubjectAndPrintAllSubjectsAndStudentTest() {
        List<Student> students = new ArrayList<>();
        students.add(student);
        studentDatabase.addSubjectInfo(subject2, students);
        studentDatabase.addStudentBySubject(student2, subject2);
        studentDatabase.printAllSubjectsAndStudent();
        assertEquals(studentDatabase.getSubjectStudents().get(subject2), students);
    }

    @Test
    public void removeStudentBySubjectTest() {
        studentDatabase.addSubjectInfo(subject2, students);
        studentDatabase.printAllSubjectsAndStudent();
        studentDatabase.removeStudentBySubject(student, subject2);
        assertEquals(studentDatabase.getSubjectStudents().get(subject2), List.of(student2));
    }
}
