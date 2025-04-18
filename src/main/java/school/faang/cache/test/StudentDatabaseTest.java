package school.faang.cache.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.cache.Student;
import school.faang.cache.StudentDatabase;
import school.faang.cache.Subject;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class StudentDatabaseTest {
    private StudentDatabase db;
    private Student student1;
    private Student student2;
    private Subject subject1;
    private Subject subject2;

    @BeforeEach
    void setUp() {
        db = new StudentDatabase();
        student1 = new Student("Иван Иванов");
        student2 = new Student("Петр Петров");
        subject1 = new Subject("Математика");
        subject2 = new Subject("Физика");
    }

    @Test
    void testAddStudentWithSubjects() {
        db.addStudentWithSubjects(student1, Map.of(subject1, 5, subject2, 4));

        assertEquals(2, db.getAllStudentsWithSubjects().get(student1).size());
        assertTrue(db.getAllSubjectsWithStudents().get(subject1).contains(student1));
        assertEquals(5, db.getGrade(student1, subject1));
    }

    @Test
    void testAddSubjectForStudent() {
        db.addStudentWithSubjects(student1, new HashMap<>());
        db.addSubjectForStudent(student1, subject1, 5);

        assertEquals(1, db.getAllStudentsWithSubjects().get(student1).size());
        assertTrue(db.getAllSubjectsWithStudents().get(subject1).contains(student1));
    }

    @Test
    void testRemoveStudent() {
        db.addStudentWithSubjects(student1, Map.of(subject1, 5));
        db.removeStudent(student1);

        assertFalse(db.getAllStudentsWithSubjects().containsKey(student1));
        assertFalse(db.getAllSubjectsWithStudents().getOrDefault(subject1, List.of()).contains(student1));
    }

    @Test
    void testAddSubjectWithStudents() {
        db.addSubjectWithStudents(subject1, List.of(student1, student2));

        assertEquals(2, db.getAllSubjectsWithStudents().get(subject1).size());
        assertTrue(db.getAllStudentsWithSubjects().get(student1).containsKey(subject1));
    }
}
