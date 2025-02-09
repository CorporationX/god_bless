package school.faang.bjs2_56955;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class StudentDatabaseTest {
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
    void addStudentShouldStoreStudentAndGrade() {
        studentDatabase.addStudent(student1, subject1, 90);
        assertTrue(studentDatabase.getSubjectsAndGradesByStudent().containsKey(student1));
        assertEquals(90, studentDatabase.getSubjectsAndGradesByStudent().get(student1).get(subject1));
    }

    @Test
    void addSubjectForStudentShouldAddSubjectIfStudentExists() {
        studentDatabase.addStudent(student1, subject1, 90);
        studentDatabase.addSubjectForStudent(student1, subject2, 85);
        assertTrue(studentDatabase.getSubjectsAndGradesByStudent().get(student1).containsKey(subject2));
        assertEquals(85, studentDatabase.getSubjectsAndGradesByStudent().get(student1).get(subject2));
    }

    @Test
    void removeStudentAndSubjectsShouldDeleteStudent() {
        studentDatabase.addStudent(student1, subject1, 90);
        studentDatabase.removeStudentAndSubjectForStudent(student1);
        assertFalse(studentDatabase.getSubjectsAndGradesByStudent().containsKey(student1));
    }

    @Test
    void addSubjectWithStudentsShouldStoreStudentsInSubject() {
        List<Student> students = Arrays.asList(student1, student2);
        studentDatabase.addSubjectWithStudents(subject1, students);
        assertTrue(studentDatabase.getStudentsBySubject().containsKey(subject1));
        assertEquals(2, studentDatabase.getStudentsBySubject().get(subject1).size());
    }

    @Test
    void addStudentToSubjectShouldAddStudentToExistingSubject() {
        studentDatabase.addStudentToSubject(student1, subject1);
        assertTrue(studentDatabase.getStudentsBySubject().get(subject1).contains(student1));
    }

    @Test
    void removeStudentFromSubjectShouldRemoveStudent() {
        studentDatabase.addStudent(student1, subject1, 90);
        studentDatabase.removeStudentFromSubject(student1, subject1);
        assertFalse(studentDatabase.getSubjectsAndGradesByStudent().get(student1).containsKey(subject1));
    }

    @Test
    void addStudentShouldThrowExceptionWhenNullValuesProvided() {
        assertThrows(NullPointerException.class, () -> studentDatabase.addStudent(null, subject1, 90));
        assertThrows(NullPointerException.class, () -> studentDatabase.addStudent(student1, null, 90));
    }

    @Test
    void addStudentToSubjectShouldIgnoreNullValues() {
        assertDoesNotThrow(() -> studentDatabase.addStudentToSubject(null, subject1));
        assertDoesNotThrow(() -> studentDatabase.addStudentToSubject(student1, null));
    }

    @Test
    void removeStudentAndSubjectForStudentShouldThrowExceptionWhenNullProvided() {
        assertThrows(NullPointerException.class, () -> studentDatabase.removeStudentAndSubjectForStudent(null));
    }
}

