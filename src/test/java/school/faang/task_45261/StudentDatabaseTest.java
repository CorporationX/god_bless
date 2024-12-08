package school.faang.task_45261;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentDatabaseTest {

    StudentDatabase studentDatabase;
    Student femaleStudent;
    Student maleStudent;
    Subject biology;
    Subject math;

    @BeforeEach
    void setUp() {
        studentDatabase = new StudentDatabase();
        femaleStudent = new Student(1, "Jane");
        maleStudent = new Student(2, "Bob");
        biology = new Subject(1, "Biology");
        math = new Subject(2, "Math");
    }

    @Test
    void testSuccessAddStudentWithGrades() {
        var grades = Map.of(biology, 4, math, 5);

        studentDatabase.addStudentWithGrades(femaleStudent, grades);

        assertTrue(studentDatabase.getStudentWithGrades().containsKey(femaleStudent));
        assertEquals(grades, studentDatabase.getStudentWithGrades().get(femaleStudent));
        assertTrue(studentDatabase.getSubjectWithStudents().containsKey(biology));
        assertTrue(studentDatabase.getSubjectWithStudents().containsKey(math));
        assertEquals(List.of(femaleStudent), studentDatabase.getSubjectWithStudents().get(biology));
    }

    @Test
    void testFailAddStudentWithGrades() {
        var grades = Map.of(biology, 4, math, 5);

        assertThrows(
            IllegalArgumentException.class,
            () -> studentDatabase.addStudentWithGrades(null, grades)
        );
        assertThrows(
            IllegalArgumentException.class,
            () -> studentDatabase.addStudentWithGrades(femaleStudent, null)
        );
        assertThrows(
            IllegalArgumentException.class,
            () -> studentDatabase.addStudentWithGrades(femaleStudent, new HashMap<>())
        );
    }

    @Test
    void testSuccessAddSubjectWithStudents() {
        var students = List.of(femaleStudent, maleStudent);

        studentDatabase.addSubjectWithStudents(biology, students);

        assertTrue(studentDatabase.getSubjectWithStudents().containsKey(biology));
        assertEquals(students, studentDatabase.getSubjectWithStudents().get(biology));
        assertTrue(studentDatabase.getStudentWithGrades().get(femaleStudent).containsKey(biology));
        assertTrue(studentDatabase.getStudentWithGrades().get(maleStudent).containsKey(biology));
        assertEquals(2, studentDatabase.getStudentWithGrades().keySet().size());
    }

    @Test
    void testFailAddSubjectWithStudents() {
        var students = List.of(femaleStudent, maleStudent);

        studentDatabase.addSubjectWithStudents(biology, students);

        assertThrows(
            IllegalArgumentException.class,
            () -> studentDatabase.addSubjectWithStudents(null, students)
        );
        assertThrows(
            IllegalArgumentException.class,
            () -> studentDatabase.addSubjectWithStudents(biology, null)
        );
        assertThrows(
            IllegalArgumentException.class,
            () -> studentDatabase.addSubjectWithStudents(biology, new ArrayList<>())
        );
    }

    @Test
    void testSuccessAddSubjectForStudent() {
        var grades = Map.of(biology, 4);
        studentDatabase.addStudentWithGrades(femaleStudent, new HashMap<>(grades));

        studentDatabase.addSubjectForStudent(math, femaleStudent, 4);

        assertTrue(studentDatabase.getStudentWithGrades().containsKey(femaleStudent));
        assertTrue(studentDatabase.getSubjectWithStudents().containsKey(biology));
        assertTrue(studentDatabase.getSubjectWithStudents().containsKey(math));
        assertTrue(studentDatabase.getStudentWithGrades().get(femaleStudent).containsKey(biology));
        assertTrue(studentDatabase.getStudentWithGrades().get(femaleStudent).containsKey(math));
    }

    @Test
    void testFailAddSubjectForStudent() {
        assertThrows(
            IllegalArgumentException.class,
            () -> studentDatabase.addSubjectForStudent(null, femaleStudent, 4)
        );
        assertThrows(
            IllegalArgumentException.class,
            () -> studentDatabase.addSubjectForStudent(math, null, 4)
        );
        assertThrows(
            IllegalArgumentException.class,
            () -> studentDatabase.addSubjectForStudent(math, femaleStudent, 4)
        );
    }

    @Test
    void testSuccessAddStudentForSubject() {
        var students = List.of(femaleStudent);
        studentDatabase.addSubjectWithStudents(biology, new ArrayList<>(students));

        studentDatabase.addStudentForSubject(biology, femaleStudent);
        studentDatabase.addStudentForSubject(biology, maleStudent);

        assertTrue(studentDatabase.getSubjectWithStudents().containsKey(biology));
        assertTrue(studentDatabase.getSubjectWithStudents().get(biology).contains(femaleStudent));
        assertTrue(studentDatabase.getSubjectWithStudents().get(biology).contains(maleStudent));
        assertTrue(studentDatabase.getStudentWithGrades().containsKey(femaleStudent));
        assertTrue(studentDatabase.getStudentWithGrades().containsKey(maleStudent));
        assertTrue(studentDatabase.getStudentWithGrades().get(femaleStudent).containsKey(biology));
        assertTrue(studentDatabase.getStudentWithGrades().get(maleStudent).containsKey(biology));
    }

    @Test
    void testFailAddStudentForSubject() {
        assertThrows(
            IllegalArgumentException.class,
            () -> studentDatabase.addStudentForSubject(null, femaleStudent)
        );
        assertThrows(
            IllegalArgumentException.class,
            () -> studentDatabase.addStudentForSubject(math, null)
        );
        assertThrows(
            IllegalArgumentException.class,
            () -> studentDatabase.addStudentForSubject(math, femaleStudent)
        );
    }

    @Test
    void testSuccessDeleteStudentWithSubjects() {
        var grades = Map.of(biology, 4, math, 5);
        studentDatabase.addStudentWithGrades(femaleStudent, grades);

        studentDatabase.deleteStudentWithSubjects(femaleStudent);

        assertFalse(studentDatabase.getStudentWithGrades().containsKey(femaleStudent));
        assertFalse(studentDatabase.getSubjectWithStudents().containsKey(biology));
        assertFalse(studentDatabase.getSubjectWithStudents().containsKey(math));
    }

    @Test
    void testFailDeleteStudentWithSubjects() {
        assertThrows(
            IllegalArgumentException.class,
            () -> studentDatabase.deleteStudentWithSubjects(null)
        );
        assertThrows(
            IllegalArgumentException.class,
            () -> studentDatabase.deleteStudentWithSubjects(femaleStudent)
        );
    }

    @Test
    void testSuccessDeleteStudentFromSubject() {
        var students = List.of(femaleStudent, maleStudent);
        studentDatabase.addSubjectWithStudents(biology, students);

        studentDatabase.deleteStudentFromSubject(maleStudent, biology);

        assertTrue(studentDatabase.getStudentWithGrades().containsKey(femaleStudent));
        assertFalse(studentDatabase.getStudentWithGrades().containsKey(maleStudent));
        assertTrue(studentDatabase.getSubjectWithStudents().containsKey(biology));
        assertTrue(studentDatabase.getSubjectWithStudents().get(biology).contains(femaleStudent));
        assertFalse(studentDatabase.getSubjectWithStudents().get(biology).contains(maleStudent));
    }

    @Test
    void testFailDeleteStudentFromSubject() {
        assertThrows(
            IllegalArgumentException.class,
            () -> studentDatabase.deleteStudentFromSubject(femaleStudent, null)
        );
        assertThrows(
            IllegalArgumentException.class,
            () -> studentDatabase.deleteStudentFromSubject(null, math)
        );
    }
}