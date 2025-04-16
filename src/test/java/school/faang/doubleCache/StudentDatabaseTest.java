package school.faang.doubleCache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.doublecashe.models.Student;
import school.faang.doublecashe.models.Subject;
import school.faang.doublecashe.services.StudentDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentDatabaseTest {
    private StudentDatabase database;
    private Student student1;
    private Student student2;
    private Subject math;
    private Subject physics;

    @BeforeEach
    public void setUp() {
        database = new StudentDatabase();
        student1 = new Student("Ivan");
        student2 = new Student("Petr");
        math = new Subject("Математика");
        physics = new Subject("Физика");
    }

    @Test
    void testAddStudentWithSubjects() {
        Map<Subject, Integer> subjects = new HashMap<>();
        subjects.put(math, 5);
        subjects.put(physics, 4);

        database.addStudentWithSubjects(student1, subjects);

        assertEquals(subjects, database.getStudentSubjects().get(student1));
        assertTrue(database.getSubjectStudents().get(math).contains(student1));
        assertTrue(database.getSubjectStudents().get(physics).contains(student1));
    }

    @Test
    void testAddStudentWithSubjects_NullArguments() {
        assertThrows(IllegalArgumentException.class, () -> database.addStudentWithSubjects(null, null));
        assertThrows(IllegalArgumentException.class, () -> database.addStudentWithSubjects(student1, null));
        assertThrows(IllegalArgumentException.class, () -> database.addStudentWithSubjects(null, new HashMap<>()));
    }

    @Test
    void testAddSubjectForStudent() {
        database.addStudentWithSubjects(student1, new HashMap<>());
        database.addSubjectForStudent(math, student1, 5);

        assertEquals(5, database.getStudentSubjects().get(student1).get(math));
        assertTrue(database.getSubjectStudents().get(math).contains(student1));
    }

    @Test
    void testAddSubjectForStudent_StudentNotExists() {
        assertThrows(IllegalArgumentException.class, () -> database.addSubjectForStudent(math, student1, 5));
    }

    @Test
    void testRemoveStudent() {
        Map<Subject, Integer> subjects = new HashMap<>();
        subjects.put(math, 5);
        subjects.put(physics, 4);
        database.addStudentWithSubjects(student1, subjects);

        database.removeStudent(student1);

        assertFalse(database.getStudentSubjects().containsKey(student1));
        assertFalse(database.getSubjectStudents().getOrDefault(math, List.of()).contains(student1));
        assertFalse(database.getSubjectStudents().getOrDefault(physics, List.of()).contains(student1));
    }

    @Test
    void testRemoveStudent_StudentNotExists() {
        assertThrows(IllegalArgumentException.class, () -> database.removeStudent(student1));
    }

    @Test
    void testAddSubjectWithStudents() {
        database.addSubjectWithStudents(math, List.of(student1, student2));

        assertTrue(database.getSubjectStudents().get(math).contains(student1));
        assertTrue(database.getSubjectStudents().get(math).contains(student2));
        assertEquals(0, database.getStudentSubjects().get(student1).get(math));
        assertEquals(0, database.getStudentSubjects().get(student2).get(math));
    }

    @Test
    void testAddSubjectWithStudents_NullArguments() {
        assertThrows(IllegalArgumentException.class, () -> database.addSubjectWithStudents(null, null));
        assertThrows(IllegalArgumentException.class, () -> database.addSubjectWithStudents(math, null));
        assertThrows(IllegalArgumentException.class, () -> database.addSubjectWithStudents(null, List.of(student1)));
    }

    @Test
    void testAddStudentToSubject() {
        database.addSubjectWithStudents(math, List.of(student1));
        database.addStudentToSubject(math, student2);

        assertTrue(database.getSubjectStudents().get(math).contains(student2));
        assertEquals(0, database.getStudentSubjects().get(student2).get(math));
    }

    @Test
    void testAddStudentToSubject_SubjectNotExists() {
        assertThrows(IllegalArgumentException.class, () -> database.addStudentToSubject(math, student1));
    }

    @Test
    void testRemoveStudentFromSubject() {
        database.addSubjectWithStudents(math, List.of(student1, student2));
        database.removeStudentFromSubject(math, student1);

        assertFalse(database.getSubjectStudents().get(math).contains(student1));
        assertFalse(database.getStudentSubjects().getOrDefault(student1, Map.of()).containsKey(math));
        assertTrue(database.getSubjectStudents().get(math).contains(student2));
    }

    @Test
    void testRemoveStudentFromSubject_SubjectNotExists() {
        assertThrows(IllegalArgumentException.class, () -> database.removeStudentFromSubject(math, student1));
    }

    @Test
    void testPrintStudentGrade() {
        Map<Subject, Integer> subjects = new HashMap<>();
        subjects.put(math, 5);
        database.addStudentWithSubjects(student1, subjects);

        String expected = "{" + student1.toString() + "={" + math.toString() + "=5}}";
        assertEquals(expected, database.printStudentGrade());
    }

    @Test
    void testPrintSubjectsForStudents() {
        database.addSubjectWithStudents(math, List.of(student1));

        String expected = "{" + math.toString() + "=[" + student1.toString() + "]}";
        assertEquals(expected, database.printSubjectsForStudents());
    }

    @Test
    void testRemoveSubjectWhenNoStudentsLeft() {
        database.addSubjectWithStudents(math, List.of(student1));
        database.removeStudentFromSubject(math, student1);

        assertFalse(database.getSubjectStudents().containsKey(math));
    }

    @Test
    void testRemoveStudentWhenNoSubjectsLeft() {
        Map<Subject, Integer> subjects = new HashMap<>();
        subjects.put(math, 5);
        database.addStudentWithSubjects(student1, subjects);
        database.removeStudentFromSubject(math, student1);

        assertFalse(database.getStudentSubjects().containsKey(student1));
    }
}