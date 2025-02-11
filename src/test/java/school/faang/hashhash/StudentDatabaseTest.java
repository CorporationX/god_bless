package school.faang.hashhash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentDatabaseTest {
    private StudentDatabase studentDatabase;
    private Student student;
    private Student student2;
    private Subject subject;
    private Subject subject2;
    private Student nullStudent;
    private Subject nullSubject;
    private int testGrade;

    @BeforeEach
    void setUp() {
        studentDatabase = new StudentDatabase();
        student = new Student("Bob");
        student2 = new Student("Alice");
        subject = new Subject("Math");
        subject2 = new Subject("English");
        nullStudent = null;
        nullSubject = null;
    }

    @Test
    @DisplayName("Позитивный тест добавления нового студента и его предметов")
    void testAddStudentWithSubject() {
        testGrade = 5;
        Map<Subject, Integer> testSubject = Map.of(subject, testGrade);
        studentDatabase.addStudentWithSubject(student, testSubject);
        assertThrows(IllegalArgumentException.class, () ->
                studentDatabase.addStudentWithSubject(student, testSubject));
    }

    @Test
    @DisplayName("Тест с невалидными входными данными (null )")
    void negTestAddStudentWithSubject() {
        testGrade = 5;
        Map<Subject, Integer> testSubject = new HashMap<>();
        testSubject.put(nullSubject, testGrade);
        assertThrows(NullPointerException.class, () ->
                studentDatabase.addStudentWithSubject(student, testSubject));
    }

    @Test
    @DisplayName("Тест с невалидными входными данными (null )")
    void testAddStudentWithSubjectToNull() {

        assertThrows(NullPointerException.class, () ->
                studentDatabase.addStudentWithSubject(student, null));
    }

    @Test
    @DisplayName("Позитивный тест добавления предмета студенту")
    void testAddSubjectForStudent() {
        testGrade = 4;
        Map<Subject, Integer> testSubject = new HashMap<>();
        testSubject.put(subject, testGrade);
        studentDatabase.addStudentWithSubject(student, testSubject);
        studentDatabase.addSubjectForStudent(subject2, student, testGrade);

        assertThrows(IllegalArgumentException.class, () ->
                studentDatabase.addSubjectForStudent(subject2, student, testGrade));
    }

    @Test
    @DisplayName("Позитивный тест добавления предмета студенту")
    void negTestAddSubjectForStudent() {

        assertThrows(NullPointerException.class, () ->
                studentDatabase.addSubjectForStudent(subject2, nullStudent, testGrade));
    }

    @Test
    @DisplayName("Позитивный тест удаления предмета студента")
    void testRemoveStudent() {
        testGrade = 4;
        Map<Subject, Integer> testSubject = new HashMap<>();
        testSubject.put(subject, testGrade);
        studentDatabase.addStudentWithSubject(student, testSubject);
        studentDatabase.removeStudent(student);
        assertThrows(IllegalArgumentException.class, () ->
                studentDatabase.removeStudent(student));
    }

    @Test
    @DisplayName("Позитивный тест удаления предмета студента")
    void negTestRemoveStudent() {
        assertThrows(NullPointerException.class, () ->
                studentDatabase.removeStudent(nullStudent));
    }

    @Test
    @DisplayName("Позитивный тест добавления предмета студенту")
    void testAddSubject() {
        testGrade = 4;
        Map<Subject, Integer> testSubject = new HashMap<>();
        testSubject.put(subject, testGrade);
        studentDatabase.addStudentWithSubject(student, testSubject);
        List<Student> students = new ArrayList<>();
        students.add(student);
        studentDatabase.addSubject(students, subject2);
        assertThrows(IllegalArgumentException.class, () ->
                studentDatabase.addSubject(students, subject2));
    }

    @Test
    @DisplayName("Позитивный тест добавления предмета студенту")
    void negTestAddSubject() {
        assertThrows(NullPointerException.class, () ->
                studentDatabase.addSubject(null, subject2));
    }

    @Test
    @DisplayName("Позитивный тест добавления студента к предмету")
    void testAddStudentForSubject() {
        List<Student> students = new ArrayList<>();
        students.add(student);
        studentDatabase.addSubject(students, subject2);
        studentDatabase.addStudentForSubject(student2, subject2);
        assertThrows(IllegalArgumentException.class, () -> studentDatabase.addStudentForSubject(student2, subject));
    }

    @Test
    @DisplayName("Позитивный тест добавления студента к предмету")
    void negTestAddStudentForSubject() {
        assertThrows(NullPointerException.class, () ->
                studentDatabase.addStudentForSubject(nullStudent, subject));
    }

    @Test
    @DisplayName("Позитивный тест удаления студента из предмета")
    void testRemoveStudentForSubject() {
        List<Student> students = new ArrayList<>();
        students.add(student);
        studentDatabase.addSubject(students, subject2);
        studentDatabase.removeStudentForSubject(student, subject2);
        assertThrows(IllegalArgumentException.class, () ->
                studentDatabase.removeStudentForSubject(student, subject2));

    }

    @Test
    @DisplayName("Тест с невалидными вхожными данными (null )")
    void negTestRemoveStudentForSubject() {
        assertThrows(NullPointerException.class, () ->
                studentDatabase.removeStudentForSubject(nullStudent, subject2));
    }
}