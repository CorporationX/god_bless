package school.faang.bjs2_56955;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    void addStudentShouldStoreStudentWithGradeWhenNewStudentIsAdded() {
        studentDatabase.addStudent(student1, subject1, 90);
        assertTrue(studentDatabase.getStudentSubjects().containsKey(student1));
        assertTrue(studentDatabase.getStudentSubjects().get(student1).containsKey(subject1));
        assertEquals(90, studentDatabase.getStudentSubjects().get(student1).get(subject1));
    }

    @Test
    void addSubjectForStudentShouldAddNewSubjectToExistingStudent() {
        studentDatabase.addStudent(student1, subject1, 90);
        studentDatabase.addSubjectForStudent(student1, subject2, 85);
        assertTrue(studentDatabase.getStudentSubjects().get(student1).containsKey(subject2));
        assertEquals(85, studentDatabase.getStudentSubjects().get(student1).get(subject2));
    }

    @Test
    void removeStudentAndSubjectsShouldRemoveStudentAndAllSubjects() {
        studentDatabase.addStudent(student1, subject1, 90);
        studentDatabase.addStudent(student1, subject2, 85);
        studentDatabase.removeStudentAndSubjectForStudent(student1);
        assertFalse(studentDatabase.getStudentSubjects().containsKey(student1));
    }

    @Test
    void addSubjectWithStudentsShouldAssociateStudentsWithSubject() {
        List<Student> students = Arrays.asList(student1, student2);
        studentDatabase.addSubjectWithStudents(subject1, students);
        assertTrue(studentDatabase.getSubjectStudents().containsKey(subject1));
        assertEquals(2, studentDatabase.getSubjectStudents().get(subject1).size());
    }

    @Test
    void addStudentToSubjectShouldAddStudentToExistingSubject() {
        studentDatabase.addStudentToSubject(student1, subject1);
        assertTrue(studentDatabase.getSubjectStudents().get(subject1).contains(student1));
    }

    @Test
    void removeStudentFromSubjectShouldRemoveSubjectFromStudent() {
        studentDatabase.addStudent(student1, subject1, 90);
        studentDatabase.removeStudentFromSubject(student1, subject1);
        assertFalse(studentDatabase.getStudentSubjects().get(student1).containsKey(subject1));
    }

    @Test
    void addStudentShouldThrowExceptionWhenStudentOrSubjectIsNull() {
        assertThrows(NullPointerException.class, () -> studentDatabase.addStudent(null, subject1, 90));
        assertThrows(NullPointerException.class, () -> studentDatabase.addStudent(student1, null, 90));
    }

    @Test
    void addSubjectForStudentShouldNotAddSubjectWhenStudentDoesNotExist() {
        studentDatabase.addSubjectForStudent(student1, subject1, 85);
        assertFalse(studentDatabase.getStudentSubjects().containsKey(student1));
    }

    @Test
    void removeStudentAndSubjectsShouldDoNothingWhenStudentDoesNotExist() {
        studentDatabase.removeStudentAndSubjectForStudent(student1);
        assertFalse(studentDatabase.getStudentSubjects().containsKey(student1));
    }

    @Test
    void removeStudentFromSubjectShouldNotFailWhenStudentOrSubjectDoesNotExist() {
        studentDatabase.removeStudentFromSubject(student1, subject1);
        assertFalse(studentDatabase.getStudentSubjects().containsKey(student1));
    }
}

