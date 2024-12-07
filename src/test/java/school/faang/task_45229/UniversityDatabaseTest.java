package school.faang.task_45229;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UniversityDatabaseTest {
    private UniversityDatabase universityDatabase;
    private Student student1;
    private Student student2;
    private Subject mathematics;
    private Subject physics;

    @BeforeEach
    void setUp() {
        universityDatabase = new UniversityDatabase();
        student1 = new Student("Bob");
        student2 = new Student("Rik");
        mathematics = new Subject("Mathematics");
        physics = new Subject("Physics");
    }

    @Test
    void testAddStudentAndGrades() {
        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(mathematics, 9);
        grades.put(physics, 8);

        universityDatabase.addStudentAndGrades(student1, grades);

        assertTrue(universityDatabase.getStudentsWithGrades()
                .containsKey(student1));
        assertEquals(2, universityDatabase.getStudentsWithGrades()
                .get(student1)
                .size());

        assertEquals(9, universityDatabase.getStudentsWithGrades()
                .get(student1)
                .get(mathematics));
        assertEquals(8, universityDatabase.getStudentsWithGrades()
                .get(student1)
                .get(physics));
    }

    @Test
    void testAddStudentAndGrades_nullStudentThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                universityDatabase.addStudentAndGrades(null, new HashMap<>()));
    }

    @Test
    void testAddStudentAndGrades_nullGradesThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                universityDatabase.addStudentAndGrades(student1, null));
    }

    @Test
    void testAddSubjectWithGradeToStudent() {
        universityDatabase.addSubjectWithGradeToStudent(mathematics, student1, 9);

        assertTrue(universityDatabase.getStudentsWithGrades().containsKey(student1));
        assertEquals(9, universityDatabase.getStudentsWithGrades().get(student1).get(mathematics));
    }

    @Test
    void testAddSubjectWithGradeToStudent_nullSubjectThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                universityDatabase.addSubjectWithGradeToStudent(null, student1, 8));
    }

    @Test
    void testAddSubjectWithGradeToStudent_nullStudentThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                universityDatabase.addSubjectWithGradeToStudent(mathematics, null, 8));
    }

    @Test
    void testRemoveStudent() {
        universityDatabase.addSubjectWithGradeToStudent(mathematics, student1, 9);
        universityDatabase.addSubjectWithGradeToStudent(physics, student1, 8);
        universityDatabase.removeStudent(student1);

        assertFalse(universityDatabase.getStudentsWithGrades().containsKey(student1));
        assertFalse(universityDatabase.getSubjectsWithStudents().get(mathematics).contains(student1));
        assertFalse(universityDatabase.getSubjectsWithStudents().get(physics).contains(student1));
    }

    @Test
    void testRemoveStudent_nullThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                universityDatabase.removeStudent(null));
    }

    @Test
    void testAddNewSubject() {
        Set<Student> students = new HashSet<>();
        students.add(student1);
        students.add(student2);

        universityDatabase.addNewSubject(mathematics, students);

        assertTrue(universityDatabase.getSubjectsWithStudents().containsKey(mathematics));
        assertEquals(2, universityDatabase.getSubjectsWithStudents().get(mathematics).size());
        assertTrue(universityDatabase.getSubjectsWithStudents().get(mathematics).contains(student1));
    }

    @Test
    void testAddNewSubject_nullSubjectThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                universityDatabase.addNewSubject(null, new HashSet<>()));
    }

    @Test
    void testAddNewSubject_nullStudentsThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                universityDatabase.addNewSubject(mathematics, null));
    }

    @Test
    void testRemoveSubject() {
        universityDatabase.addSubjectWithGradeToStudent(mathematics, student1, 9);
        universityDatabase.addSubjectWithGradeToStudent(mathematics, student2, 8);

        universityDatabase.removeSubject(mathematics);

        assertFalse(universityDatabase.getSubjectsWithStudents().containsKey(mathematics));
        assertFalse(universityDatabase.getStudentsWithGrades().get(student1).containsKey(mathematics));
    }

    @Test
    void testRemoveSubject_nullThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                universityDatabase.removeSubject(null));
    }
}