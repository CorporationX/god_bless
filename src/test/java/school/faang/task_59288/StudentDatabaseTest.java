package school.faang.task_59288;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class StudentDatabaseTest {

    private StudentDatabase studentDatabase;
    private Map<Student, Map<Subject, Integer>> studentSubjects;
    private Map<Subject, List<Student>> subjectStudents;

    @BeforeEach
    void setUp() {
        studentSubjects = new HashMap<>();
        subjectStudents = new HashMap<>();
        studentDatabase = new StudentDatabase(studentSubjects, subjectStudents);
    }

    @Test
    void testAddStudentAndGrades() {
        Student student = new Student("Alice");
        Subject math = new Subject("Mathematics");
        Map<Subject, Integer> subjects = Map.of(math, 90);

        studentDatabase.addStudentAndGrades(student.getName(), subjects);

        assertTrue(studentSubjects.containsKey(student));
        assertEquals(90, studentSubjects.get(student).get(math));
        assertTrue(subjectStudents.get(math).contains(student));
    }

    @Test
    void testAddStudentWithSubjects() {
        Student student = new Student("Bob");
        Subject physics = new Subject("Physics");

        studentDatabase.studentSubjects.put(student, new HashMap<>());
        studentDatabase.addSubjectForStudent(student, physics.getName(), 85);

        assertTrue(studentSubjects.get(student).containsKey(physics));
        assertEquals(85, studentSubjects.get(student).get(physics));
        assertTrue(subjectStudents.get(physics).contains(student));
    }

    @Test
    void testDeleteStudentWithSubjects() {
        Student student = new Student("Charlie");
        Subject chemistry = new Subject("Chemistry");
        studentSubjects.put(student, new HashMap<>(Map.of(chemistry, 75)));
        subjectStudents.put(chemistry, new ArrayList<>(List.of(student)));

        studentDatabase.deleteStudentWithSubjects(student);
        assertFalse(studentSubjects.containsKey(student));

        if (subjectStudents.containsKey(chemistry)) {
            List<Student> studentList = subjectStudents.get(chemistry);
            assertFalse(studentList.contains(student));
        } else {
            assertFalse(subjectStudents.containsKey(chemistry));
        }
    }

    @Test
    void testPrintAllStudentsWithGrades() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Student student = new Student("Bob");
        Subject physics = new Subject("Physics");
        studentSubjects.put(student, new HashMap<>(Map.of(physics, 85)));

        studentDatabase.printAllStudentsWithGrades();

        String expectedOutput =
                """
                        Student: Bob
                        \tPhysics: 85
                        """;
        String actual = outputStream.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput, actual);
    }

    @Test
    void testCreateSubjectWithStudents() {
        Student student = new Student("Eve");
        Subject history = new Subject("History");
        studentSubjects.put(student, new HashMap<>());

        studentDatabase.createSubjectWithStudents(history.getName(), List.of(student));

        assertTrue(subjectStudents.containsKey(history));
        assertTrue(studentSubjects.get(student).containsKey(history));
    }

    @Test
    void testEnrollStudentInSubject() {
        Student student = new Student("Frank");
        Subject geography = new Subject("Geography");
        subjectStudents.put(geography, new ArrayList<>());

        studentDatabase.enrollStudentInSubject(student, geography);

        assertTrue(subjectStudents.get(geography).contains(student));
        assertTrue(studentSubjects.get(student).containsKey(geography));
    }

    @Test
    void testRemoveStudentFromSubject() {
        Student student = new Student("Grace");
        Subject art = new Subject("Art");
        studentSubjects.put(student, new HashMap<>(Map.of(art, 88)));
        subjectStudents.put(art, new ArrayList<>(List.of(student)));

        studentDatabase.removeStudentFromSubject(student, art);

        assertFalse(studentSubjects.get(student).containsKey(art));
        assertFalse(subjectStudents.get(art).contains(student));
    }

    @Test
    void testPrintAllSubjectsWithEnrolledStudents() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Subject math = new Subject("Math");
        Student student = new Student("Charlie");
        subjectStudents.put(math, new ArrayList<>(List.of(student)));

        studentDatabase.printAllSubjectsWithEnrolledStudents();

        String expectedOutput =
                """
                        Subject: Math
                        \tCharlie
                        """;
        String actual = outputStream.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput, actual);
    }
}