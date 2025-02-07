package school.faang.bjs2_56955;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class StudentDatabaseTest {
    private StudentDatabase studentDatabase;
    private Student student1;
    private Student student2;
    private Subject subject1;
    private Subject subject2;

    @BeforeEach
    void setUp() {
        studentDatabase = new StudentDatabase();
        student1 = new Student("Alice");
        student2 = new Student("Bob");
        subject1 = new Subject("Math");
        subject2 = new Subject("Physics");
    }

    @Test
    void testAddStudent() {
        studentDatabase.addStudent(student1, subject1, 90);
        assertTrue(studentDatabase.getStudentSubjects().containsKey(student1));
        assertTrue(studentDatabase.getStudentSubjects().get(student1).containsKey(subject1));
        assertEquals(90, studentDatabase.getStudentSubjects().get(student1).get(subject1));
    }

    @Test
    void testAddSubjectForStudent() {
        studentDatabase.addStudent(student1, subject1, 90);
        studentDatabase.addSubjectForStudent(student1, subject2, 85);
        assertTrue(studentDatabase.getStudentSubjects().get(student1).containsKey(subject2));
        assertEquals(85, studentDatabase.getStudentSubjects().get(student1).get(subject2));
    }

    @Test
    void testRemoveStudentAndSubjects() {
        studentDatabase.addStudent(student1, subject1, 90);
        studentDatabase.addStudent(student1, subject2, 85);
        studentDatabase.removeStudentAndSubjectForStudent(student1);
        assertFalse(studentDatabase.getStudentSubjects().containsKey(student1));
    }

    @Test
    void testAddSubjectWithStudents() {
        List<Student> students = Arrays.asList(student1, student2);
        studentDatabase.addSubjectWithStudents(subject1, students);
        assertTrue(studentDatabase.getSubjectStudents().containsKey(subject1));
        assertEquals(2, studentDatabase.getSubjectStudents().get(subject1).size());
    }

    @Test
    void testAddStudentToSubject() {
        studentDatabase.addStudentToSubject(student1, subject1);
        assertTrue(studentDatabase.getSubjectStudents().get(subject1).contains(student1));
    }

    @Test
    void testRemoveStudentFromSubject() {
        studentDatabase.addStudent(student1, subject1, 90);
        studentDatabase.removeStudentFromSubject(student1, subject1);
        assertFalse(studentDatabase.getStudentSubjects().get(student1).containsKey(subject1));
    }
}

