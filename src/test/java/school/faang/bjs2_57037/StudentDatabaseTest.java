package school.faang.bjs2_57037;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentDatabaseTest {

    private StudentDatabase studentDatabase;

    Student student = new Student("Иван Иванов");
    Subject math = new Subject("Математика");
    Subject physics = new Subject("Физика");
    Map<Subject, Integer> grades = new HashMap<>();

    @BeforeEach
    public void setUp() {
        studentDatabase = new StudentDatabase();
        grades.put(math, 90);
        grades.put(physics, 85);
    }

    @Test
    public void testAddStudentWithGrades() {
        studentDatabase.addStudentWithGrades(student, grades);

        assertTrue(studentDatabase.getStudentSubjects().containsKey(student));
        assertEquals(grades, studentDatabase.getStudentSubjects().get(student));

        assertTrue(studentDatabase.getSubjectStudents().containsKey(math));
        assertTrue(studentDatabase.getSubjectStudents().containsKey(physics));
        assertTrue(studentDatabase.getSubjectStudents().get(math).contains(student));
        assertTrue(studentDatabase.getSubjectStudents().get(physics).contains(student));
    }

    @Test
    public void testAddSubjectForStudent() {
        studentDatabase.addSubjectForStudent(student, math, 77);

        assertTrue(studentDatabase.getStudentSubjects().get(student).containsKey(math));
        assertEquals(77, studentDatabase.getStudentSubjects().get(student).get(math));

        assertTrue(studentDatabase.getSubjectStudents().containsKey(math));
        assertTrue(studentDatabase.getSubjectStudents().get(math).contains(student));
    }

    @Test
    public void testRemoveStudent() {
        studentDatabase.addStudentWithGrades(student, grades);

        assertTrue(studentDatabase.getStudentSubjects().containsKey(student));
        assertTrue(studentDatabase.getSubjectStudents().get(math).contains(student));
        assertTrue(studentDatabase.getSubjectStudents().get(physics).contains(student));

        studentDatabase.removeStudent(student);

        assertFalse(studentDatabase.getStudentSubjects().containsKey(student));

        assertFalse(studentDatabase.getSubjectStudents().get(math).contains(student));
        assertFalse(studentDatabase.getSubjectStudents().get(physics).contains(student));
    }

    @Test
    public void testAddSubjectWithStudents() {
        studentDatabase.addSubjectWithStudents(math,  List.of(student));

        assertTrue(studentDatabase.getSubjectStudents().containsKey(math));
        assertTrue(studentDatabase.getSubjectStudents().get(math).contains(student));

        assertTrue(studentDatabase.getStudentSubjects().get(student).containsKey(math));
    }

    @Test
    public void testAddStudentToSubject() {
        studentDatabase.addStudentToSubject(student, physics);

        assertTrue(studentDatabase.getStudentSubjects().containsKey(student));
        assertTrue(studentDatabase.getStudentSubjects().get(student).containsKey(physics));

        assertTrue(studentDatabase.getSubjectStudents().containsKey(physics));
        assertTrue(studentDatabase.getSubjectStudents().get(physics).contains(student));
    }

    @Test
    public void testRemoveStudentFromSubject() {
        studentDatabase.addStudentToSubject(student, physics);

        studentDatabase.removeStudentFromSubject(student, physics);

        assertFalse(studentDatabase.getStudentSubjects().get(student).containsKey(physics));
        assertFalse(studentDatabase.getSubjectStudents().get(physics).contains(student));
    }

}
