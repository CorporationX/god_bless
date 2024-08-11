package faang.school.godbless.BJS2_20000;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private Main main;
    private Student studentOne;
    private Student studentTwo;
    private Student studentThree;
    private Subject subjectOne;
    private Subject subjectTwo;
    private Subject subjectThree;

    @BeforeEach
    void setUp() {
        main = new Main();

        studentOne = new Student(1, "Маша");
        studentTwo = new Student(2, "Сережа");
        studentThree = new Student(3, "Ваня");

        subjectOne = new Subject(101, "Математика");
        subjectTwo = new Subject(102, "Физика");
        subjectThree = new Subject(103, "Химия");

        Map<Subject, Integer> subjectsOne = new HashMap<>();
        subjectsOne.put(subjectOne, 85);
        subjectsOne.put(subjectTwo, 90);
        main.addStudent(studentOne, subjectsOne);

        Map<Subject, Integer> subjectsTwo = new HashMap<>();
        subjectsTwo.put(subjectOne, 78);
        main.addStudent(studentTwo, subjectsTwo);

        Map<Subject, Integer> subjectsThree = new HashMap<>();
        subjectsThree.put(subjectThree, 92);
        main.addStudent(studentThree, subjectsThree);
    }

    @Test
    void addStudent() {
        Student studentFour = new Student(4, "Саша");
        Subject subjectFour = new Subject(104, "Биология");
        Map<Subject, Integer> subjectsFour = new HashMap<>();
        subjectsFour.put(subjectFour, 88);

        main.addStudent(studentFour, subjectsFour);

        assertTrue(main.getStudentWithSubjects().containsKey(studentFour));
        assertEquals(88, main.getStudentWithSubjects().get(studentFour).get(subjectFour).intValue());
        assertTrue(main.getAllSubjectStudents().get(subjectFour).contains(studentFour));
    }

    @Test
    void addSubjectToStudent() {
        main.addSubjectToStudent(studentTwo, subjectThree, 88);

        assertTrue(main.getStudentWithSubjects().get(studentTwo).containsKey(subjectThree));
        assertEquals(88, main.getStudentWithSubjects().get(studentTwo).get(subjectThree).intValue());
        assertTrue(main.getAllSubjectStudents().get(subjectThree).contains(studentTwo));
    }

    @Test
    void removeStudent() {
        main.removeStudent(studentOne);

        assertFalse(main.getStudentWithSubjects().containsKey(studentOne));
        assertFalse(main.getAllSubjectStudents().get(subjectOne).contains(studentOne));
    }

    @Test
    void addSubject() {
        Subject subjectFour = new Subject(104, "Биология");
        List<Student> studentsForSubjectFour = new ArrayList<>();
        studentsForSubjectFour.add(studentOne);
        studentsForSubjectFour.add(studentThree);

        main.addSubject(subjectFour, studentsForSubjectFour);

        assertTrue(main.getAllSubjectStudents().containsKey(subjectFour));
        assertTrue(main.getAllSubjectStudents().get(subjectFour).contains(studentOne));
        assertTrue(main.getAllSubjectStudents().get(subjectFour).contains(studentThree));
        assertTrue(main.getStudentWithSubjects().get(studentOne).containsKey(subjectFour));
        assertTrue(main.getStudentWithSubjects().get(studentThree).containsKey(subjectFour));
    }

    @Test
    void addStudentAtSubject() {
        Subject subjectFour = new Subject(104, "Биология");

        main.addStudentAtSubject(studentTwo, subjectFour);

        assertTrue(main.getAllSubjectStudents().get(subjectFour).contains(studentTwo));
        assertTrue(main.getStudentWithSubjects().get(studentTwo).containsKey(subjectFour));
    }

    @Test
    void removeStudentFromSubject() {
        main.addSubjectToStudent(studentTwo, subjectThree, 88);
        main.removeStudentFromSubject(subjectThree, studentTwo);

        assertFalse(main.getStudentWithSubjects().get(studentTwo).containsKey(subjectThree));
        assertFalse(main.getAllSubjectStudents().get(subjectThree).contains(studentTwo));
    }
}