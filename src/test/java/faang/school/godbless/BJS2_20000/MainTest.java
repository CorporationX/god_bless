package faang.school.godbless.BJS2_20000;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest extends faang.school.godbless.BJS2_20000.Main {
    private Main main;
    private Student student1;
    private Student student2;
    private Student student3;
    private Subject subject1;
    private Subject subject2;
    private Subject subject3;

    @BeforeEach
    void setUp() {
        main = new Main();

        student1 = new Student(1, "Маша");
        student2 = new Student(2, "Сережа");
        student3 = new Student(3, "Ваня");

        subject1 = new Subject(101, "Математика");
        subject2 = new Subject(102, "Физика");
        subject3 = new Subject(103, "Химия");

        Map<Subject, Integer> subjects1 = new HashMap<>();
        subjects1.put(subject1, 85);
        subjects1.put(subject2, 90);
        main.addStudent(student1, subjects1);

        Map<Subject, Integer> subjects2 = new HashMap<>();
        subjects2.put(subject1, 78);
        main.addStudent(student2, subjects2);

        Map<Subject, Integer> subjects3 = new HashMap<>();
        subjects3.put(subject3, 92);
        main.addStudent(student3, subjects3);
    }

    @Test
    void addStudent() {
        Student student4 = new Student(4, "Саша");
        Subject subject4 = new Subject(104, "Биология");
        Map<Subject, Integer> subjects4 = new HashMap<>();
        subjects4.put(subject4, 88);

        main.addStudent(student4, subjects4);

        assertTrue(main.getStudentWithSubjects().containsKey(student4));
        assertEquals(88, main.getStudentWithSubjects().get(student4).get(subject4).intValue());
        assertTrue(main.getAllSubjectStudents().get(subject4).contains(student4));
    }

    @Test
    void addSubjectToStudent() {
        main.addSubjectToStudent(student2, subject3, 88);

        assertTrue(main.getStudentWithSubjects().get(student2).containsKey(subject3));
        assertEquals(88, main.getStudentWithSubjects().get(student2).get(subject3).intValue());
        assertTrue(main.getAllSubjectStudents().get(subject3).contains(student2));
    }

    @Test
    void removeStudent() {
        main.removeStudent(student1);

        assertFalse(main.getStudentWithSubjects().containsKey(student1));
        assertFalse(main.getAllSubjectStudents().get(subject1).contains(student1));
    }

    @Test
    void addSubject() {
        Subject subject4 = new Subject(104, "Биология");
        List<Student> studentsForSubject4 = new ArrayList<>();
        studentsForSubject4.add(student1);
        studentsForSubject4.add(student3);

        main.addSubject(subject4, studentsForSubject4);

        assertTrue(main.getAllSubjectStudents().containsKey(subject4));
        assertTrue(main.getAllSubjectStudents().get(subject4).contains(student1));
        assertTrue(main.getAllSubjectStudents().get(subject4).contains(student3));
        assertTrue(main.getStudentWithSubjects().get(student1).containsKey(subject4));
        assertTrue(main.getStudentWithSubjects().get(student3).containsKey(subject4));
    }

    @Test
    void addStudentAtSubject() {
        Subject subject4 = new Subject(104, "Биология");

        main.addStudentAtSubject(student2, subject4);

        assertTrue(main.getAllSubjectStudents().get(subject4).contains(student2));
        assertTrue(main.getStudentWithSubjects().get(student2).containsKey(subject4));
    }

    @Test
    void removeStudentFromSubject() {
        main.addSubjectToStudent(student2, subject3, 88);
        main.removeStudentFromSubject(subject3, student2);

        assertFalse(main.getStudentWithSubjects().get(student2).containsKey(subject3));
        assertFalse(main.getAllSubjectStudents().get(subject3).contains(student2));
    }
}