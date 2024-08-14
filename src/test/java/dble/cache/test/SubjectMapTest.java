package dble.cache.test;

import dble.cache.Main;
import dble.cache.Student;
import dble.cache.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubjectMapTest {
    private Main cache;

    @BeforeEach
    void setUp() {
        cache = new Main();
    }

    @Test
    @DisplayName("Testing addSubjectStudents method")
    void subjectMapTest_addSubjectStudents() {
        Subject subject1 = new Subject("English");
        var students1 = List.of(
                new Student("Petya"),
                new Student("Vasya"),
                new Student("Katya"));

        cache.addSubjectStudents(subject1, students1);

        assertAll(
                () -> assertTrue(cache.getSubjectStudents().containsKey(subject1)),
                () -> assertEquals(students1, cache.getSubjectStudents().get(subject1)));
    }

    @Test
    @DisplayName("Testing addSubjectStudents method with subject in map")
    void subjectMapTest_addAddedSubjectStudents() {
        Subject subject1 = new Subject("English");
        var students1 = List.of(
                new Student("Petya"),
                new Student("Vasya"),
                new Student("Katya"));
        cache.addSubjectStudents(subject1, students1);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> cache.addSubjectStudents(subject1, students1));

        assertEquals(Main.ALREADY_ADDED_SUBJECT, e.getMessage());
    }

    @Test
    @DisplayName("Testing addSubjectStudents method with null arguemnts")
    void subjectMapTest_addSubjectStudentsWithNullArguments() {
        Subject subject1 = new Subject("English");
        var students1 = List.of(
                new Student("Petya"),
                new Student("Vasya"),
                new Student("Katya"));

        assertAll(
                () -> assertThrows(
                        NullPointerException.class,
                        () -> cache.addSubjectStudents(null, students1)),
                () -> assertThrows(
                        NullPointerException.class,
                        () -> cache.addSubjectStudents(subject1, null)));
    }

    @Test
    @DisplayName("Testing addStudentToSubject method")
    void subjectMapTest_addStudent() {
        Subject subject1 = new Subject("English");
        var students1 = new ArrayList<>(List.of(
                new Student("Petya"),
                new Student("Vasya"),
                new Student("Katya")));
        Student student = new Student("Vasya");
        cache.addSubjectStudents(subject1, students1);

        cache.addStudentToSubject(subject1, student);

        assertTrue(cache.getSubjectStudents().get(subject1).contains(student));
    }

    @Test
    @DisplayName("Testing addStudentToSubject method with added student")
    void subjectMapTest_addAddedStudent() {
        Subject subject1 = new Subject("English");
        var students1 = new ArrayList<>(List.of(
                new Student("Petya"),
                new Student("Vasya"),
                new Student("Katya")));
        Student student = new Student("Kolya");
        cache.addSubjectStudents(subject1, students1);
        cache.addStudentToSubject(subject1, student);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> cache.addStudentToSubject(subject1, student));

        assertEquals(Main.ALREADY_ADDED_STUDENT, e.getMessage());
    }

    @Test
    @DisplayName("Testing addStudentToSubject method with null arguments")
    void subjectMapTest_addStudentWithNullArguments() {
        Subject subject1 = new Subject("English");
        Student student = new Student("Kolya");

        assertAll(
                () -> assertThrows(
                        NullPointerException.class,
                        () -> cache.addStudentToSubject(null, student)),
                () -> assertThrows(
                        NullPointerException.class,
                        () -> cache.addStudentToSubject(subject1, null)));
    }

    @Test
    @DisplayName("Testing removeStudentFromSubject method")
    void subjectMapTest_removeStudent() {
        Subject subject1 = new Subject("English");
        Student student = new Student("Petya");
        var students1 = new ArrayList<>(List.of(
                student,
                new Student("Vasya"),
                new Student("Katya")));
        cache.addSubjectStudents(subject1, students1);

        cache.removeStudentFromSubject(subject1, student);

        assertFalse(cache.getSubjectStudents().get(subject1).contains(student));
    }

    @Test
    @DisplayName("Testing removeStudentFromSubject method from subject not in list")
    void subjectMapTest_removeStudentFromSubjectNotInList() {
        Subject subject1 = new Subject("English");
        var students1 = new ArrayList<>(List.of(
                new Student("Petya"),
                new Student("Vasya"),
                new Student("Katya")));
        Student student = new Student("Kolya");
        cache.addSubjectStudents(subject1, students1);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> cache.removeStudentFromSubject(new Subject("Biology"), student));

        assertEquals(Main.NO_SUBJECT, e.getMessage());
    }

    @Test
    @DisplayName("Testing removeStudentFromSubject method with student not in list")
    void subjectMapTest_removeStudentNotFromSubjectList() {
        Subject subject1 = new Subject("English");
        var students1 = new ArrayList<>(List.of(
                new Student("Petya"),
                new Student("Vasya"),
                new Student("Katya")));
        Student student = new Student("Kolya");
        cache.addSubjectStudents(subject1, students1);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> cache.removeStudentFromSubject(subject1, student));

        assertEquals(Main.NOT_IN_SUBJECT_LIST, e.getMessage());
    }

    @Test
    @DisplayName("Testing removeStudentFromSubject method with null arguments")
    void subjectMapTest_removeStudentWithNullArguments() {
        Subject subject1 = new Subject("English");
        Student student = new Student("Kolya");

        assertAll(
                () -> assertThrows(
                        NullPointerException.class,
                        () -> cache.removeStudentFromSubject(null, student)),
                () -> assertThrows(
                        NullPointerException.class,
                        () -> cache.removeStudentFromSubject(subject1, null)));
    }
}
