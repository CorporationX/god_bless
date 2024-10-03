package double_cache_cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private Student student1;
    private Student student2;
    private Subject subject1;
    private Subject subject2;

    @BeforeEach
    void setUp() {
        student1 = new Student(1, "John");
        student2 = new Student(2, "Jane");
        subject1 = new Subject(1, "Math");
        subject2 = new Subject(2, "Physics");

        Main.getStudentsOfEstimation().clear();
        Main.getSubjectsOfStudents().clear();
    }

    @Test
    void testAddStudentToSubject() {
        Main.addStudentToSubject(student1, subject1, 5);

        Map<Subject, Integer> subjects = Main.getStudentsOfEstimation().get(student1);
        assertNotNull(subjects);
        assertEquals(1, subjects.size());
        assertEquals(5, subjects.get(subject1));

        List<Student> students = Main.getSubjectsOfStudents().get(subject1);
        assertNotNull(students);
        assertTrue(students.contains(student1));
    }

    @Test
    void testRemoveStudentFromSubject() {
        Main.addStudentToSubject(student1, subject1, 5);
        Main.addStudentToSubject(student2, subject1, 4);

        Main.removeStudentFromSubject(student1);

        assertNull(Main.getStudentsOfEstimation().get(student1));
        assertEquals(1, Main.getStudentsOfEstimation().size());

        List<Student> students = Main.getSubjectsOfStudents().get(subject1);
        assertTrue(students.contains(student1));
    }

    @Test
    void testAddNewSubjectAndStudentsList() {
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        Subject newSubject = new Subject(3, "Chemistry");

        Main.addNewSubjectAndStudentsList(newSubject, students);

        List<Student> studentsFromSubject = Main.getSubjectsOfStudents().get(newSubject);
        assertNotNull(studentsFromSubject);
        assertEquals(2, studentsFromSubject.size());
        assertTrue(studentsFromSubject.contains(student1));
        assertTrue(studentsFromSubject.contains(student2));

        Map<Subject, Integer> student1Subjects = Main.getStudentsOfEstimation().get(student1);
        assertEquals(0, student1Subjects.get(newSubject));

        Map<Subject, Integer> student2Subjects = Main.getStudentsOfEstimation().get(student2);
        assertEquals(0, student2Subjects.get(newSubject));
    }

    @Test
    void testAddStudentByExistingSubject() {
        Main.addStudentByExistingSubject(student1, subject1);

        Map<Subject, Integer> subjects = Main.getStudentsOfEstimation().get(student1);
        assertNotNull(subjects);
        assertEquals(0, subjects.get(subject1));
    }

    @Test
    void testRemoveStudentForSubject() {
        Main.addStudentToSubject(student1, subject1, 5);
        Main.addStudentToSubject(student2, subject1, 4);

        Main.removeStudentForSubject(student1, subject1);

        List<Student> students = Main.getSubjectsOfStudents().get(subject1);
        assertFalse(students.contains(student1));
    }

    @Test
    void testPrintAllStudent() {
        Main.addStudentToSubject(student1, subject1, 5);
        Main.addStudentToSubject(student1, subject2, 4);

        Main.addStudentToSubject(student2, subject1, 3);

        assertEquals(2, Main.getStudentsOfEstimation().size());
        assertTrue(Main.getStudentsOfEstimation().containsKey(student1));
        assertTrue(Main.getStudentsOfEstimation().containsKey(student2));
    }

    @Test
    void testPrintAllSubjects() {
        Main.addStudentToSubject(student1, subject1, 5);
        Main.addStudentToSubject(student2, subject1, 3);
        Main.addStudentToSubject(student2, subject2, 4);

        assertEquals(2, Main.getSubjectsOfStudents().size());
        assertTrue(Main.getSubjectsOfStudents().get(subject1).contains(student1));
        assertTrue(Main.getSubjectsOfStudents().get(subject1).contains(student2));
        assertTrue(Main.getSubjectsOfStudents().get(subject2).contains(student2));
    }
}
