package dble.cache.test;

import dble.cache.Main;
import dble.cache.Student;
import dble.cache.Subject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GradeMapTest {
    private static Main cache;
    private static Student student;
    private static Subject subject1;
    private static Subject subject2;
    private static Subject subject3;
    private static List<Student> students1;
    private static List<Student> students2;
    private Map<Subject, Integer> grades;

    @BeforeAll
    static void setParams() {
        student = new Student("Petya");
        subject1 = new Subject("English");
        students1 = new ArrayList<>(List.of(
                student,
                new Student("Vasya"),
                new Student("Katya")
        ));
        subject2 = new Subject("Math");
        students2 = new ArrayList<>(List.of(
                student,
                new Student("Vasya"),
                new Student("Katya")
        ));
        subject3 = new Subject("Chemistry");
    }

    @BeforeEach
    void setUp() {
        cache = new Main();
        cache.addSubjectStudents(subject1, students1);
        cache.addSubjectStudents(subject2, students2);
        cache.addSubjectStudents(subject3, new ArrayList<>());
        grades = new HashMap<>(
                Map.of(
                        subject1, 4));
    }

    @Test
    @DisplayName("Testing addStudentGrades method")
    void gradeTest_addStudentGrades() {
        cache.addStudentGrades(student, grades);

        assertTrue(cache.getStudentGrades().containsKey(student));
    }

    @Test
    @DisplayName("Testing addStudentGrades method with student not in subject list")
    void gradeTest_addStudentGradesNotInSubject() {
        Student student1 = new Student("Aboba");

        cache.addStudentGrades(student1, grades);

        assertFalse(cache.getStudentGrades().containsKey(student1));
    }

    @Test
    @DisplayName("Testing addStudentGrades method with subject grade for subject not in list")
    void gradTest_addStudentWithGradesOnSubjectNotInTheList() {
        grades = new HashMap<>();
        grades.put(new Subject("Biology"), 4);
        Student student1 = new Student("Aboba");

        cache.addStudentGrades(student1, grades);

        assertFalse(cache.getStudentGrades().containsKey(student1));
    }

    @Test
    @DisplayName("Testing addStudentGrades method with student not in subject list")
    void gradeTest_addStudentAddedGrades() {
        cache.addStudentGrades(student, grades);

        cache.addStudentGrades(student, new HashMap<>());

        assertEquals(cache.getStudentGrades().get(student), grades);
    }

    @Test
    @DisplayName("Testing addStudentGrades method with null arguments")
    void gradeTest_addStudentWithNullArguments() {
        assertAll(
                () -> assertThrows(
                        NullPointerException.class,
                        () -> cache.addStudentGrades(null, grades)),
                () -> assertThrows(NullPointerException.class,
                        () -> cache.addStudentGrades(student, null)));
    }

    @Test
    @DisplayName("Testing addGradeForStudent method")
    void gradeTest_addGrade() {
        cache.addStudentGrades(student, grades);

        cache.addGradeForStudent(student, subject2, 4);

        assertAll(
                () -> assertTrue(cache.getStudentGrades().get(student).containsKey(subject2)),
                () -> assertEquals(4, cache.getStudentGrades().get(student).get(subject2)));
    }

    @Test
    @DisplayName("Testing addGradeForStudent method with student without grades")
    void gradeTest_addGradeWithStudentNotWithoutGrades() {
        cache.addStudentGrades(student, grades);
        Student student = new Student("Aboba");

        cache.addGradeForStudent(student, subject3, 4);

        assertFalse(cache.getStudentGrades().containsKey(student));
    }

    @Test
    @DisplayName("Testing addGradeForStudent method with student not in subject list")
    void gradeTest_addGradeWithStudentNotInSubjectList() {
        cache.addStudentGrades(student, grades);

        cache.addGradeForStudent(student, subject3, 4);

        assertFalse(cache.getStudentGrades().get(student).containsKey(subject3));
    }

    @Test
    @DisplayName("Testing addGradeForStudent method with subject not in list")
    void gradeTest_addGradeForSubjectNotInList() {
        cache.addStudentGrades(student, grades);
        Subject subject = new Subject("Biology");

        cache.addGradeForStudent(student, subject, 5);

        assertFalse(cache.getStudentGrades().get(student).containsKey(subject));
    }

    @Test
    @DisplayName("Testing addGradeForStudent method for existing grade")
    void gradeTest_addAddedGrade() {
        cache.addStudentGrades(student, grades);

        cache.addGradeForStudent(student, subject1, 5);

        assertEquals(grades.get(subject1), cache.getStudentGrades().get(student).get(subject1));
    }

    @Test
    @DisplayName("Testing addGradeForStudent method with null arguments")
    void gradeTest_addGradeWithNullArguments() {
        assertAll(
                () -> assertThrows(
                        NullPointerException.class,
                        () -> cache.addGradeForStudent(null, subject1, 4)),
                () -> assertThrows(
                        NullPointerException.class,
                        () -> cache.addGradeForStudent(student, null, 4))
        );
    }

    @Test
    @DisplayName("Testing removeStudentGrades method")
    void gradeTest_removeGrades() {
        cache.addStudentGrades(student, grades);

        cache.removeStudentGrades(student);

        assertFalse(cache.getStudentGrades().containsKey(student));
    }

    @Test
    @DisplayName("Testing removeStudentGrades method with student without grades")
    void gradeTest_removeGradesForStudentWithoutGrades() {
        cache.addStudentGrades(student, grades);

        cache.removeStudentGrades(new Student("Aboba"));

        assertEquals(1, cache.getStudentGrades().size());
    }

    @Test
    @DisplayName("Testing removeStudentGrades method with null arguments")
    void gradeTest_removeGradesForStudentWithNullArguments() {
        assertThrows(NullPointerException.class, () -> cache.removeStudentGrades(null));
    }
}
