package school.faang.sprint_1.task_45310;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDatabaseTest {

    private StudentDatabase studentDatabase;
    private Student student1;
    private Student student2;
    private Subject math;
    private Subject english;

    @BeforeEach
    public void setUp() {
        studentDatabase = new StudentDatabase();

        student1 = new Student(1, "Erik");
        student2 = new Student(2, "Meri");

        math = new Subject(1, "Math");
        english = new Subject(2, "English");
    }

    @Test
    public void testAddStudent() {
        Map<Subject, Integer> grades1 = new HashMap<>();
        grades1.put(math, 30);
        grades1.put(english, 100);

        studentDatabase.addStudent(student1, grades1);

        assertTrue(studentDatabase.studentGrades.containsKey(student1),
                "Student should be added.");
        assertEquals(30, studentDatabase.studentGrades.get(student1).get(math),
                "Grade for Math should be 30.");
        assertEquals(100, studentDatabase.studentGrades.get(student1).get(english),
                "Grade for English should be 100.");
    }

    @Test
    public void testAddSubjectForStudent() {
        Map<Subject, Integer> grades1 = new HashMap<>();
        grades1.put(math, 30);
        studentDatabase.addStudent(student1, grades1);

        studentDatabase.addSubjectForStudent(student1, new Subject(3, "Geometry"), 90);

        assertTrue(studentDatabase.studentGrades.get(student1).containsKey(new Subject(
                3,
                "Geometry")),
                "Student should have Geometry subject.");
        assertEquals(90, studentDatabase.studentGrades.get(student1).get(new Subject(
                3,
                "Geometry")),
                "Grade for Geometry should be 90.");
    }

    @Test
    public void testRemoveStudent() {
        Map<Subject, Integer> grades1 = new HashMap<>();
        grades1.put(math, 30);
        studentDatabase.addStudent(student1, grades1);

        studentDatabase.removeStudent(student1);

        assertFalse(studentDatabase.studentGrades.containsKey(student1), "Student should be removed.");
    }

    @Test
    public void testAddStudentToSubject() {
        studentDatabase.addStudent(student1, Map.of(math, 90));
        studentDatabase.addStudent(student2, Map.of(math, 80));

        studentDatabase.addStudentToSubject(math, student1);
        studentDatabase.addStudentToSubject(math, student2);

        List<Student> mathStudents = studentDatabase.subjectStudents.get(math);
        assertNotNull(mathStudents, "Math students list should not be null.");
        assertTrue(mathStudents.contains(student1), "Math students should contain student1.");
        assertTrue(mathStudents.contains(student2), "Math students should contain student2.");
    }

    @Test
    public void testPrintAllStudents() {
        Map<Subject, Integer> grades1 = new HashMap<>();
        grades1.put(math, 30);
        grades1.put(english, 100);

        studentDatabase.addStudent(student1, grades1);

        studentDatabase.printAllStudents();
    }

    @Test
    public void testPrintAllSubjects() {
        Map<Subject, Integer> grades1 = new HashMap<>();
        grades1.put(math, 30);
        studentDatabase.addStudent(student1, grades1);

        studentDatabase.addStudentToSubject(math, student1);

        studentDatabase.printAllSubjects();
    }
}
