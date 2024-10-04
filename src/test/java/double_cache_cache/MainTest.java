package double_cache_cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private Student firstStudent;
    private Student secondStudent;
    private Subject firstSubject;
    private Subject secondSubject;

    @BeforeEach
    void setUp() {
        firstStudent = new Student(1, "John");
        secondStudent = new Student(2, "Jane");
        firstSubject = new Subject(1, "Math");
        secondSubject = new Subject(2, "Physics");

        Main.studentsOfEstimation.clear();
        Main.subjectsOfStudents.clear();
    }

    @Test
    void testAddStudentToSubject() {
        Main.addStudentToSubject(firstStudent, firstSubject, 5);

        Map<Subject, Integer> subjects = Main.studentsOfEstimation.get(firstStudent);
        assertNotNull(subjects);
        assertEquals(1, subjects.size());
        assertEquals(5, subjects.get(firstSubject));

        List<Student> students = Main.subjectsOfStudents.get(firstSubject);
        assertNotNull(students);
        assertTrue(students.contains(firstStudent));
    }

    @Test
    void testRemoveStudentFromSubject() {
        Main.addStudentToSubject(firstStudent, firstSubject, 5);
        Main.addStudentToSubject(secondStudent, firstSubject, 4);

        Main.removeStudentFromSubject(firstStudent);

        assertNull(Main.studentsOfEstimation.get(firstStudent));
        assertEquals(1, Main.studentsOfEstimation.size());

        List<Student> students = Main.subjectsOfStudents.get(firstSubject);
        assertTrue(students.contains(firstStudent));
    }

    @Test
    void testAddNewSubjectAndStudentsList() {
        List<Student> students = new ArrayList<>();
        students.add(firstStudent);
        students.add(secondStudent);

        Subject newSubject = new Subject(3, "Chemistry");

        Main.addNewSubjectAndStudentsList(newSubject, students);

        List<Student> studentsFromSubject = Main.subjectsOfStudents.get(newSubject);
        assertNotNull(studentsFromSubject);
        assertEquals(2, studentsFromSubject.size());
        assertTrue(studentsFromSubject.contains(firstStudent));
        assertTrue(studentsFromSubject.contains(secondStudent));

        Map<Subject, Integer> student1Subjects = Main.studentsOfEstimation.get(firstStudent);
        assertEquals(0, student1Subjects.get(newSubject));

        Map<Subject, Integer> student2Subjects = Main.studentsOfEstimation.get(secondStudent);
        assertEquals(0, student2Subjects.get(newSubject));
    }

    @Test
    void testAddStudentByExistingSubject() {
        Main.addStudentByExistingSubject(firstStudent, firstSubject);

        Map<Subject, Integer> subjects = Main.studentsOfEstimation.get(firstStudent);
        assertNotNull(subjects);
        assertEquals(0, subjects.get(firstSubject));
    }

    @Test
    void testRemoveStudentForSubject() {
        Main.addStudentToSubject(firstStudent, firstSubject, 5);
        Main.addStudentToSubject(secondStudent, firstSubject, 4);

        Main.removeStudentForSubject(firstStudent, firstSubject);

        List<Student> students = Main.subjectsOfStudents.get(firstSubject);
        assertFalse(students.contains(firstStudent));
    }

    @Test
    void testPrintAllStudent() {
        Main.addStudentToSubject(firstStudent, firstSubject, 5);
        Main.addStudentToSubject(firstStudent, secondSubject, 4);

        Main.addStudentToSubject(secondStudent, firstSubject, 3);

        assertEquals(2, Main.studentsOfEstimation.size());
        assertTrue(Main.studentsOfEstimation.containsKey(firstStudent));
        assertTrue(Main.studentsOfEstimation.containsKey(secondStudent));
    }

    @Test
    void testPrintAllSubjects() {
        Main.addStudentToSubject(firstStudent, firstSubject, 5);
        Main.addStudentToSubject(secondStudent, firstSubject, 3);
        Main.addStudentToSubject(secondStudent, secondSubject, 4);

        assertEquals(2, Main.subjectsOfStudents.size());
        assertTrue(Main.subjectsOfStudents.get(firstSubject).contains(firstStudent));
        assertTrue(Main.subjectsOfStudents.get(firstSubject).contains(secondStudent));
        assertTrue(Main.subjectsOfStudents.get(secondSubject).contains(secondStudent));
    }
}
