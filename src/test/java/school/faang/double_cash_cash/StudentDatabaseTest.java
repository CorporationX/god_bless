package school.faang.double_cash_cash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentDatabaseTest {
    private StudentDatabase database;
    private Student student1;
    private Student student2;
    private Subject math;
    private Subject physics;

    @BeforeEach
    void setUp() {
        database = new StudentDatabase();
        student1 = new Student("Alice");
        student2 = new Student("Bob");
        math = new Subject("Mathematics");
        physics = new Subject("Physics");
    }

    @Test
    void testAddStudentWithGrades() {
        Map<Subject, Integer> grades = Map.of(math, 90, physics, 85);
        database.addStudentWithGrades(student1, grades);

        assertTrue(database.getStudentSubjects().containsKey(student1));
        assertEquals(grades, database.getStudentSubjects().get(student1));
        assertTrue(database.getSubjectStudents().get(math).contains(student1));
        assertTrue(database.getSubjectStudents().get(physics).contains(student1));
    }

    @Test
    void testAddSubjectForStudent() {
        database.addSubjectForStudent(student1, math, 95);

        assertEquals(95, database.getStudentSubjects().get(student1).get(math));
        assertTrue(database.getSubjectStudents().get(math).contains(student1));
    }

    @Test
    void testRemoveStudent() {
        database.addSubjectForStudent(student1, math, 90);
        database.removeStudent(student1);

        assertFalse(database.getStudentSubjects().containsKey(student1));
        assertFalse(database.getSubjectStudents().get(math).contains(student1));
    }

    @Test
    void testAddSubjectWithStudents() {
        database.addSubjectWithStudent(math, List.of(student1, student2));

        assertTrue(database.getSubjectStudents().get(math).containsAll(List.of(student1, student2)));
        assertTrue(database.getStudentSubjects().get(student1).containsKey(math));
        assertNull(database.getStudentSubjects().get(student1).get(math));
    }

    @Test
    void testAddStudentToSubject() {
        database.addStudentToSubject(student1, math);

        assertTrue(database.getSubjectStudents().get(math).contains(student1));
        assertTrue(database.getStudentSubjects().get(student1).containsKey(math));
        assertNull(database.getStudentSubjects().get(student1).get(math));
    }

    @Test
    void testRemoveStudentFromSubject() {
        database.addSubjectForStudent(student1, math, 90);
        database.removeStudentFromSubject(student1, math);

        assertFalse(database.getSubjectStudents().get(math).contains(student1));
        assertFalse(database.getStudentSubjects().get(student1).containsKey(math));
    }
}
