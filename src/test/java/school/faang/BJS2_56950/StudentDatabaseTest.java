package school.faang.BJS2_56950;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;


class StudentDatabaseTest {
    private StudentDatabase studentDatabase;
    private static final String RAMIL = "Ramil";
    private static final String ALBERT = "Albert";
    private static final String KAMIL = "Kamil";
    private static final String MATH = "Math";
    private static final String ART = "Art";

    private static final Student STUDENT_RAM = new Student(RAMIL);
    private static final Student STUDENT_ALB = new Student(ALBERT);
    private static final Subject SUBJECT_MATH = new Subject(MATH);
    private static final Subject SUBJECT_ART = new Subject(ART);

    private String captureSystemOut(Runnable action) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        action.run();
        System.setOut(System.out);
        return outContent.toString().trim();
    }

    @BeforeEach
    void setUp() {
        studentDatabase = new StudentDatabase();
    }

    @Test
    void testAddStudentAndSubjectWithInteger() {
        studentDatabase.addStudentAndSubjectWithInteger(RAMIL, MATH, 1);
        Map<Student, Map<Subject, Integer>> studentSubjects = studentDatabase.getStudentSubjects();

        assertTrue(studentSubjects.containsKey(STUDENT_RAM));
        assertTrue(studentSubjects.get(STUDENT_RAM).containsKey(SUBJECT_MATH));
        assertEquals(1, studentSubjects.get(STUDENT_RAM).get(SUBJECT_MATH));
    }

    @Test
    void testFindStudent() {
        studentDatabase.addStudentAndSubjectWithInteger(RAMIL, MATH, 5);
        assertNotNull(studentDatabase.findStudent(RAMIL));
        assertEquals(RAMIL, studentDatabase.findStudent(RAMIL).getName());

        String actualMessage = captureSystemOut(() -> assertNull(studentDatabase.findStudent(ALBERT)));
        String expectedMessage = String.format("Студента с именем %s нету в списке студентов", ALBERT);
        assertTrue(actualMessage.contains(expectedMessage),
                String.format("Ожидалось: '%s', но получено: '%s'", expectedMessage, actualMessage));
    }

    @Test
    void testAddNewSubjectWithInteger() {
        studentDatabase.addStudentAndSubjectWithInteger(RAMIL, MATH, 5);
        studentDatabase.addNewSubjectWithInteger(RAMIL, ART, 3);
        Map<Student, Map<Subject, Integer>> studentSubjects = studentDatabase.getStudentSubjects();

        assertTrue(studentSubjects.containsKey(STUDENT_RAM));
        assertEquals(2, studentSubjects.get(STUDENT_RAM).size());
        assertEquals(3, studentSubjects.get(STUDENT_RAM).get(SUBJECT_ART));

        String actualMessage = captureSystemOut(() -> studentDatabase.addNewSubjectWithInteger(ALBERT, ART, 2));
        String expectedMessage = String.format("Студента с именем %s нету в списке студентов", ALBERT);
        assertTrue(actualMessage.contains(expectedMessage),
                String.format("Ожидалось: '%s', но получено: '%s'", expectedMessage, actualMessage));
    }

    @Test
    void testDeleteStudent() {
        studentDatabase.addStudentAndSubjectWithInteger(RAMIL, MATH, 5);
        assertNotNull(studentDatabase.findStudent(RAMIL));
        studentDatabase.deleteStudent(RAMIL);
        assertNull(studentDatabase.findStudent(RAMIL));

        String actualMessage = captureSystemOut(() -> studentDatabase.deleteStudent(RAMIL));
        String expectedMessage = String.format("Студента с именем %s нету в списке студентов", RAMIL);
        assertTrue(actualMessage.contains(expectedMessage),
                String.format("Ожидалось: '%s', но получено: '%s'", expectedMessage, actualMessage));
    }

    @Test
    void testAddNewSubjectWithStudents() {
        studentDatabase.addNewSubjectWithStudents(Set.of(RAMIL, ALBERT), MATH);
        Map<Subject, List<Student>> subjectStudents = studentDatabase.getSubjectStudents();

        assertTrue(subjectStudents.containsKey(SUBJECT_MATH));
        assertTrue(subjectStudents.get(SUBJECT_MATH).contains(STUDENT_RAM));
        assertTrue(subjectStudents.get(SUBJECT_MATH).contains(STUDENT_ALB));
    }

    @Test
    void testFindSubject() {
        studentDatabase.addNewSubjectWithStudents(Set.of(RAMIL, ALBERT), MATH);
        assertNotNull(studentDatabase.findSubject(MATH));

        String actualMessage = captureSystemOut(() -> studentDatabase.findSubject(ART));
        String expectedMessage = String.format("Предмета с названием %s нету в subjectStudents", ART);
        assertTrue(actualMessage.contains(expectedMessage),
                String.format("Ожидалось: '%s', но получено: '%s'", expectedMessage, actualMessage));
    }

    @Test
    void testAddNewStudentForSubject() {
        studentDatabase.addNewSubjectWithStudents(Set.of(RAMIL, ALBERT), MATH);
        studentDatabase.addNewStudentForSubject(KAMIL, MATH);
        Map<Subject, List<Student>> subjectStudents = studentDatabase.getSubjectStudents();
        assertTrue(subjectStudents.containsKey(SUBJECT_MATH));

        String actualMessage = captureSystemOut(() -> studentDatabase.addNewStudentForSubject(RAMIL, ART));
        String expectedMessage = String.format("Предмета с названием %s нету в subjectStudents", ART);
        assertTrue(actualMessage.contains(expectedMessage),
                String.format("Ожидалось: '%s', но получено: '%s'", expectedMessage, actualMessage)
        );
    }

    @Test
    void testDeleteStudentFromSubject() {
        studentDatabase.addNewSubjectWithStudents(Set.of(RAMIL, ALBERT), MATH);
        studentDatabase.deleteStudentFromSubject(RAMIL, MATH);
        Map<Subject, List<Student>> subjectStudents = studentDatabase.getSubjectStudents();
        assertFalse(subjectStudents.get(SUBJECT_MATH).contains(RAMIL));

        String actualMessage = captureSystemOut(() -> studentDatabase.deleteStudentFromSubject(RAMIL, ART));
        String expectedMessage = String.format("Предмета с названием %s нету в subjectStudents", ART);
        assertTrue(actualMessage.contains(expectedMessage),
                String.format("Ожидалось: '%s', но получено: '%s'", expectedMessage, actualMessage)
        );
    }
}


