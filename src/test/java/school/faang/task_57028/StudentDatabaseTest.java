package school.faang.task_57028;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class StudentDatabaseTest {
    private final StudentDatabase studentDatabase = new StudentDatabase(new HashMap<>(), new HashMap<>());;
    private final Student studentAlice = new Student("Alice");;
    private final Student studentBob = new Student("Bob");;
    private final Subject subjectMath = new Subject("Math");
    private final Subject subjectScience = new Subject("Science");

    @Test
    public void testAddStudentWithGrades() {
        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(subjectMath, 90);
        studentDatabase.addStudentWithGrades(studentAlice, grades);

        assertTrue(studentDatabase.studentSubjects.containsKey(studentAlice));
        assertEquals(90, studentDatabase.studentSubjects.get(studentAlice).get(subjectMath));
        assertTrue(studentDatabase.subjectStudents.get(subjectMath).contains(studentAlice));
    }

    @Test
    public void testAddSubjectForStudent() {
        studentDatabase.addSubjectForStudent(studentAlice, subjectMath, 85);
        assertEquals(85, studentDatabase.studentSubjects.get(studentAlice).get(subjectMath));
        assertTrue(studentDatabase.subjectStudents.get(subjectMath).contains(studentAlice));
    }

    @Test
    public void testRemoveStudent() {
        studentDatabase.addStudentWithGrades(studentAlice, Map.of(subjectMath, 90));
        studentDatabase.removeStudent(studentAlice);
        assertFalse(studentDatabase.studentSubjects.containsKey(studentAlice));
        assertFalse(studentDatabase.subjectStudents.get(subjectMath).contains(studentAlice));
    }

    @Test
    public void testPrintAllSubjectsWithStudents() {
        studentDatabase.addStudentWithGrades(studentAlice, Map.of(subjectMath, 90));
        studentDatabase.addStudentWithGrades(studentBob, Map.of(subjectMath, 85, subjectScience, 80));

        // Здесь вы можете использовать System.setOut для перехвата вывода, если хотите проверить вывод
        studentDatabase.printAllSubjectsWithStudents();
    }

    @Test
    public void testAddStudentToSubject() {
        studentDatabase.addStudentToSubject(studentAlice, subjectMath);
        assertTrue(studentDatabase.subjectStudents.get(subjectMath).contains(studentAlice));
        assertTrue(studentDatabase.studentSubjects.get(studentAlice).containsKey(subjectMath));
    }

    @Test
    public void testRemoveStudentFromSubject() {
        studentDatabase.addStudentToSubject(studentAlice, subjectMath);
        studentDatabase.removeStudentFromSubject(studentAlice, subjectMath);
        assertFalse(studentDatabase.subjectStudents.get(subjectMath).contains(studentAlice));
        assertFalse(studentDatabase.studentSubjects.get(studentAlice).containsKey(subjectMath));
    }
}
