package school.faang.dual_cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentDatabaseTest {

    StudentDatabase studentDatabase;

    @BeforeEach
    void setUp() {
        studentDatabase = new StudentDatabase();
    }

    @Test
    void testAddNewStudentWithGrades() {
        final Student student = new Student("John Doe");
        final Student student1 = new Student("Igor");

        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(new Subject("Math"), 90);
        grades.put(new Subject("Science"), 85);
        studentDatabase.addNewStudentWithGrades(student, grades);
        studentDatabase.addNewStudentWithGrades(student1, grades);

        var actual = studentDatabase.getStudentSubjects().size();
        assertEquals(2, actual, "Student Database size needs to be 2");

        boolean contains = studentDatabase.getStudentSubjects().containsKey(new Student("John Doe"));
        contains &= studentDatabase.getStudentSubjects().containsKey(new Student("Igor"));
        assertTrue(contains, "Students' names must be John Doe and Igor");

        actual = studentDatabase.getStudentSubjects().get(new Student("John Doe")).get(new Subject("Math"));
        assertEquals(90, actual, "For Math mark must be equals 90");

        actual = studentDatabase.getStudentSubjects().get(new Student("Igor")).get(new Subject("Science"));
        assertEquals(85, actual, "For Math mark must be equals 85");

        var actual1 = studentDatabase.getSubjectStudents().containsKey(new Subject("Math"))
                & studentDatabase.getSubjectStudents().containsKey(new Subject("Science"));
        assertTrue(actual1, "mapSubjects need contains Math and Science");
    }

    @Test
    void testAddSubjectForStudent() {
        studentDatabase.addSubjectForStudent(new Student("Ivan"), new Subject("AI"), 25);
        assertTrue(studentDatabase.getStudentSubjects().containsKey(new Student("Ivan")));
        assertTrue(studentDatabase.getStudentSubjects().get(new Student("Ivan"))
                .containsKey(new Subject("AI")));
        assertEquals(0, studentDatabase.getStudentSubjects().get(new Student("Ivan"))
                .get(new Subject("AI")).compareTo(25));
        assertTrue(studentDatabase.getSubjectStudents().containsKey(new Subject("AI")));

        studentDatabase.addSubjectForStudent(new Student("Ivan"), new Subject("Math"), 26);
        assertTrue(studentDatabase.getStudentSubjects().containsKey(new Student("Ivan")));
        assertTrue(studentDatabase.getStudentSubjects().get(new Student("Ivan"))
                .containsKey(new Subject("Math")));
        assertEquals(0, studentDatabase.getStudentSubjects().get(new Student("Ivan"))
                .get(new Subject("Math")).compareTo(26));

        studentDatabase.addSubjectForStudent(new Student("Ivan"), new Subject("Math"), 27);
        assertTrue(studentDatabase.getStudentSubjects().containsKey(new Student("Ivan")));
        assertTrue(studentDatabase.getStudentSubjects().get(new Student("Ivan"))
                .containsKey(new Subject("Math")));
        assertEquals(0, studentDatabase.getStudentSubjects().get(new Student("Ivan"))
                .get(new Subject("Math")).compareTo(27));

        assertTrue(studentDatabase.getSubjectStudents().get(new Subject("AI"))
                .contains(new Student("Ivan")));
        assertEquals(1, studentDatabase.getStudentSubjects().size());
        studentDatabase.addSubjectForStudent(new Student("Marina"), new Subject("Politics"), 44);
        assertEquals(2, studentDatabase.getStudentSubjects().size());

        assertTrue(studentDatabase.getSubjectStudents().containsKey(new Subject("Math")));
        assertTrue(studentDatabase.getSubjectStudents().containsKey(new Subject("AI")));
        assertTrue(studentDatabase.getSubjectStudents().containsKey(new Subject("Politics")));
        assertTrue(studentDatabase.getSubjectStudents().get(new Subject("Math"))
                .contains(new Student("Ivan")));
        assertTrue(studentDatabase.getSubjectStudents().get(new Subject("AI"))
                .contains(new Student("Ivan")));
        assertTrue(studentDatabase.getSubjectStudents().get(new Subject("Politics"))
                .contains(new Student("Marina")));

        assertTrue(true);
    }

    @Test
    void testRemoveStudent() {
        studentDatabase.addSubjectForStudent(new Student("Abram"), new Subject("Chemistry"), 25);
        studentDatabase.addSubjectForStudent(new Student("Abram"), new Subject("AI"), 55);
        studentDatabase.addSubjectForStudent(new Student("Valera"), new Subject("AI"), 48);
        studentDatabase.addSubjectForStudent(new Student("Valera"), new Subject("Architecture"), 99);

        studentDatabase.removeStudent(new Student("Abram"));

        assertFalse(studentDatabase.getStudentSubjects().containsKey(new Student("Abram")));
        assertFalse(studentDatabase.getSubjectStudents().get(new Subject("AI"))
                .contains(new Student("Abram")));
        assertTrue(studentDatabase.getSubjectStudents().get(new Subject("AI"))
                .contains(new Student("Valera")));
        assertFalse(studentDatabase.getSubjectStudents().get(new Subject("Chemistry"))
                .contains(new Student("Abram")));
    }

    @Test
    void testAddSubjectWithStudents() {
        // Можно, что будет если students = null(проверь в обоих случаях)?
        // Что произойдет если в списке студентов будут повторы?
        studentDatabase.addSubjectForStudent(new Student("Abram"), new Subject("AI"), 25);
        studentDatabase.addSubjectForStudent(new Student("Abram"), new Subject("AI"), 55);
        studentDatabase.addSubjectForStudent(new Student("Abram"), new Subject("AI"), 99);

        studentDatabase.addSubjectWithStudents(new Subject("Chemistry"), new ArrayList<>(List.of(
                new Student("Igor"), new Student("Masha"))));

        var actual = studentDatabase.getStudentSubjects().get(new Student("Abram")).containsKey(new Subject("AI"))
                & studentDatabase.getStudentSubjects().get(new Student("Igor")).containsKey(new Subject("Chemistry"))
                & studentDatabase.getStudentSubjects().get(new Student("Masha")).containsKey(new Subject("Chemistry"))
                & studentDatabase.getStudentSubjects().size() == 3;

        assertTrue(actual);

        actual = studentDatabase.getSubjectStudents().get(new Subject("AI")).contains(new Student("Abram"))
                & studentDatabase.getSubjectStudents().get(new Subject("Chemistry")).contains(new Student("Igor"))
                & studentDatabase.getSubjectStudents().get(new Subject("Chemistry")).contains(new Student("Masha"))
                & studentDatabase.getSubjectStudents().size() == 2;

        assertTrue(actual);
    }

    @Test
    void testAddStudentToSubject() {
        studentDatabase.addSubjectForStudent(new Student("Abram"), new Subject("Chemistry"), 25);
        studentDatabase.addSubjectForStudent(new Student("Valera"), new Subject("AI"), 48);
        studentDatabase.addSubjectForStudent(new Student("Ira"), new Subject("Architecture"), 99);

        studentDatabase.addStudentToSubject(new Student("Misha"), new Subject("AI"));
        assertEquals(null, studentDatabase.getStudentSubjects().get(new Student("Misha")).get(new Subject("AI")));

        studentDatabase.addStudentToSubject(new Student("Misha"), new Subject("Chemistry"));
        assertEquals(null, studentDatabase.getStudentSubjects().get(new Student("Misha")).get(new Subject("AI")));

        studentDatabase.addStudentToSubject(new Student("Abram"), new Subject("Chemistry"));
        System.out.println(studentDatabase.getStudentSubjects().get(new Student("Abram"))
                .get(new Subject("Chemistry")));
        assertEquals(25, studentDatabase.getStudentSubjects().get(new Student("Abram")).get(new Subject("Chemistry")));

        var actual = studentDatabase.getSubjectStudents().get(new Subject("Chemistry")).contains(new Student("Abram"))
                & studentDatabase.getSubjectStudents().get(new Subject("Chemistry")).contains(new Student("Misha"))
                & studentDatabase.getSubjectStudents().get(new Subject("Chemistry")).contains(new Student("Misha"))
                & studentDatabase.getSubjectStudents().get(new Subject("Chemistry")).size() == 2;
        assertTrue(actual);

        actual = studentDatabase.getSubjectStudents().get(new Subject("AI")).contains(new Student("Valera"))
                & studentDatabase.getSubjectStudents().get(new Subject("AI")).contains(new Student("Misha"))
                & studentDatabase.getSubjectStudents().get(new Subject("AI")).size() == 2;
        assertTrue(actual);

        actual = studentDatabase.getSubjectStudents().get(new Subject("Architecture")).contains(new Student("Ira"))
                & studentDatabase.getSubjectStudents().get(new Subject("Architecture")).size() == 1;
        assertTrue(actual);
    }

    @Test
    void testRemoveStudentFromSubject() {
        studentDatabase.addSubjectForStudent(new Student("Abram"), new Subject("Chemistry"), 25);
        studentDatabase.addSubjectForStudent(new Student("Valera"), new Subject("AI"), 48);
        studentDatabase.addSubjectForStudent(new Student("Ira"), new Subject("Architecture"), 99);

        assertTrue(studentDatabase.getStudentSubjects().get(new Student("Abram"))
                .containsKey(new Subject("Chemistry")));
        assertEquals(1, studentDatabase.getSubjectStudents().get(new Subject("Chemistry")).size());

        studentDatabase.removeStudentFromSubject(new Student("Abram"), new Subject("Chemistry"));

        assertFalse(studentDatabase.getStudentSubjects().get(new Student("Abram"))
                .containsKey(new Subject("Chemistry")));
        assertEquals(0, studentDatabase.getSubjectStudents().get(new Subject("Chemistry")).size());
    }
}