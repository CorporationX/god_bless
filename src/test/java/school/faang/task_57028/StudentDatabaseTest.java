package school.faang.task_57028;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class StudentDatabaseTest {
    private StudentDatabase studentDatabase;
    private Student student1;
    private Student student2;
    private Subject subject1;
    private Subject subject2;

    @BeforeEach
    public void setUp() {
        studentDatabase = new StudentDatabase(new HashMap<>(), new HashMap<>());
        student1 = new Student("Alice");
        student2 = new Student("Bob");
        subject1 = new Subject("Math");
        subject2 = new Subject("Science");
    }

    @Test
    public void testAddStudentWithGrades() {
        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(subject1, 90);
        studentDatabase.addStudentWithGrades(student1, grades);

        assertTrue(studentDatabase.studentSubjects.containsKey(student1));
        assertEquals(90, studentDatabase.studentSubjects.get(student1).get(subject1));
        assertTrue(studentDatabase.subjectStudents.get(subject1).contains(student1));
    }

    @Test
    public void testAddSubjectForStudent() {
        studentDatabase.addSubjectForStudent(student1, subject1, 85);
        assertEquals(85, studentDatabase.studentSubjects.get(student1).get(subject1));
        assertTrue(studentDatabase.subjectStudents.get(subject1).contains(student1));
    }

    @Test
    public void testRemoveStudent() {
        studentDatabase.addStudentWithGrades(student1, Map.of(subject1, 90));
        studentDatabase.removeStudent(student1);
        assertFalse(studentDatabase.studentSubjects.containsKey(student1));
        assertFalse(studentDatabase.subjectStudents.get(subject1).contains(student1));
    }

    @Test
    public void testPrintAllSubjectsWithStudents() {
        studentDatabase.addStudentWithGrades(student1, Map.of(subject1, 90));
        studentDatabase.addStudentWithGrades(student2, Map.of(subject1, 85, subject2, 80));

        // Здесь вы можете использовать System.setOut для перехвата вывода, если хотите проверить вывод
        studentDatabase.printAllSubjectsWithStudents();
    }

    @Test
    public void testAddStudentToSubject() {
        studentDatabase.addStudentToSubject(student1, subject1);
        assertTrue(studentDatabase.subjectStudents.get(subject1).contains(student1));
        assertTrue(studentDatabase.studentSubjects.get(student1).containsKey(subject1));
    }

    @Test
    public void testRemoveStudentFromSubject() {
        studentDatabase.addStudentToSubject(student1, subject1);
        studentDatabase.removeStudentFromSubject(student1, subject1);
        assertFalse(studentDatabase.subjectStudents.get(subject1).contains(student1));
        assertFalse(studentDatabase.studentSubjects.get(student1).containsKey(subject1));
    }
}
