package doublecashcash;

import school.faang.doublecashcash.Student;
import school.faang.doublecashcash.StudentDatabase;
import school.faang.doublecashcash.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentDatabaseTest {
    private StudentDatabase studentDatabase;
    private Map<Subject, Integer> subjects;
    private List<Student> students;

    @BeforeEach
    public void setUp() {
        studentDatabase = new StudentDatabase();
        subjects = new HashMap<>();
        students = new ArrayList<>();
    }

    @Test
    public void testAddStudent() {
        subjects.put(new Subject("Computer science"), 5);
        studentDatabase.addStudent("Max", subjects);

        assertTrue(studentDatabase.getStudentSubjects()
                .containsKey(new Student("Max")));
        assertTrue(studentDatabase.getStudentSubjects()
                .containsValue(new HashMap<>(Map.of(new Subject("Computer science"), 5))));
        assertTrue(studentDatabase.getSubjectStudents()
                .containsKey(new Subject("Computer science")));
        assertTrue(studentDatabase.getSubjectStudents()
                .containsValue(new ArrayList<>(List.of(new Student("Max")))));
    }

    @Test
    public void testAddStudentException() {
        assertThrows(NullPointerException.class, () ->
                studentDatabase.addStudent("Max", subjects));
    }

    @Test
    public void testAddSubjectForStudent() {
        studentDatabase.addSubjectForStudent("Max", "Computer science", 5);

        assertTrue(studentDatabase.getStudentSubjects()
                .containsKey(new Student("Max")));
        assertTrue(studentDatabase.getStudentSubjects()
                .containsValue(new HashMap<>(Map.of(new Subject("Computer science"), 5))));
        assertTrue(studentDatabase.getSubjectStudents()
                .containsKey(new Subject("Computer science")));
        assertTrue(studentDatabase.getSubjectStudents()
                .containsValue(new ArrayList<>(List.of(new Student("Max")))));
    }

    @Test
    public void testDeleteStudentAndHisSubjects() {
        studentDatabase.addSubjectForStudent("Max", "Computer science", 5);
        studentDatabase.addSubjectForStudent("Evgeniy", "Computer science", 3);
        studentDatabase.addSubjectForStudent("Evgeniy", "Math", 4);
        studentDatabase.deleteStudentAndHisSubjects("Evgeniy");

        assertTrue(studentDatabase.getStudentSubjects()
                .containsKey(new Student("Max")));
        assertTrue(studentDatabase.getStudentSubjects()
                .containsValue(new HashMap<>(Map.of(new Subject("Computer science"), 5))));
        assertTrue(studentDatabase.getSubjectStudents()
                .containsKey(new Subject("Computer science")));
        assertTrue(studentDatabase.getSubjectStudents()
                .containsValue(new ArrayList<>(List.of(new Student("Max")))));
        assertFalse(studentDatabase.getStudentSubjects()
                .containsKey(new Student("Evgeniy")));
    }

    @Test
    public void testAddSubject() {
        students.add(new Student("Max"));
        studentDatabase.addSubject("Computer science", students);

        assertTrue(studentDatabase.getStudentSubjects()
                .containsKey(new Student("Max")));
        assertTrue(studentDatabase.getStudentSubjects()
                .containsValue(new HashMap<>(Map.of(new Subject("Computer science"), 0))));
        assertTrue(studentDatabase.getSubjectStudents()
                .containsKey(new Subject("Computer science")));
        assertTrue(studentDatabase.getSubjectStudents()
                .containsValue(new ArrayList<>(List.of(new Student("Max")))));
    }

    @Test
    public void testAddSubjectException() {
        assertThrows(NullPointerException.class, () ->
                studentDatabase.addSubject("Computer science", students));
    }

    @Test
    public void testAddStudentForSubject() {
        studentDatabase.addStudentForSubject("Computer science", "Max");

        assertTrue(studentDatabase.getStudentSubjects()
                .containsKey(new Student("Max")));
        assertTrue(studentDatabase.getStudentSubjects()
                .containsValue(new HashMap<>(Map.of(new Subject("Computer science"), 0))));
        assertTrue(studentDatabase.getSubjectStudents()
                .containsKey(new Subject("Computer science")));
        assertTrue(studentDatabase.getSubjectStudents()
                .containsValue(new ArrayList<>(List.of(new Student("Max")))));
    }

    @Test
    public void testDeleteStudentsFromSubjects() {
        studentDatabase.addStudentForSubject("Computer science", "Evgeniy");
        studentDatabase.addStudentForSubject("Computer science", "Max");
        studentDatabase.deleteStudentFromSubjects("Computer science", "Evgeniy");

        assertTrue(studentDatabase.getStudentSubjects()
                .containsKey(new Student("Max")));
        assertTrue(studentDatabase.getStudentSubjects()
                .containsValue(new HashMap<>(Map.of(new Subject("Computer science"), 0))));
        assertTrue(studentDatabase.getSubjectStudents()
                .containsKey(new Subject("Computer science")));
        assertTrue(studentDatabase.getSubjectStudents()
                .containsValue(new ArrayList<>(List.of(new Student("Max")))));
        assertFalse(studentDatabase.getSubjectStudents()
                .containsKey(new Subject("Evgeniy")));
    }
}
