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
    private static final Student STUDENT_KAMIL = new Student(KAMIL);
    private static final Subject SUBJECT_MATH = new Subject(MATH);
    private static final Subject SUBJECT_ART = new Subject(ART);


    @BeforeEach
    void setUp() {
        studentDatabase = new StudentDatabase();
    }

    @Test
    void testAddStudentAndSubjectWithInteger() {
        studentDatabase.addStudentAndSubjectWithInteger(STUDENT_RAM, SUBJECT_MATH, 1);
        Map<Student, Map<Subject, Integer>> studentSubjects = studentDatabase.getStudentSubjects();

        assertTrue(studentSubjects.containsKey(STUDENT_RAM));
        assertTrue(studentSubjects.get(STUDENT_RAM).containsKey(SUBJECT_MATH));
        assertEquals(1, studentSubjects.get(STUDENT_RAM).get(SUBJECT_MATH));
    }

    @Test
    void testAddNewSubjectWithInteger() {
        studentDatabase.addStudentAndSubjectWithInteger(STUDENT_RAM, SUBJECT_MATH, 5);
        studentDatabase.addNewSubjectWithInteger(STUDENT_RAM, SUBJECT_ART, 3);
        Map<Student, Map<Subject, Integer>> studentSubjects = studentDatabase.getStudentSubjects();

        assertTrue(studentSubjects.containsKey(STUDENT_RAM));
        assertEquals(2, studentSubjects.get(STUDENT_RAM).size());
        assertEquals(3, studentSubjects.get(STUDENT_RAM).get(SUBJECT_ART));

    }

    @Test
    void testDeleteStudent() {
        studentDatabase.addStudentAndSubjectWithInteger(STUDENT_RAM, SUBJECT_MATH, 5);

        studentDatabase.deleteStudent(STUDENT_RAM);
        assertFalse(studentDatabase.getStudentSubjects().containsKey(RAMIL));
    }

    @Test
    void testAddNewSubjectWithStudents() {
        studentDatabase.addStudentAndSubjectWithInteger(STUDENT_RAM, SUBJECT_ART, 1);
        studentDatabase.addStudentAndSubjectWithInteger(STUDENT_ALB, SUBJECT_ART, 1);
        studentDatabase.addNewSubjectWithStudents(List.of(STUDENT_RAM, STUDENT_ALB), SUBJECT_MATH);
        Map<Subject, List<Student>> subjectStudents = studentDatabase.getSubjectStudents();

        assertTrue(subjectStudents.containsKey(SUBJECT_MATH));
        assertTrue(subjectStudents.get(SUBJECT_MATH).contains(STUDENT_RAM));
        assertTrue(subjectStudents.get(SUBJECT_MATH).contains(STUDENT_ALB));
    }

    @Test
    void testAddNewStudentForSubject() {
        studentDatabase.addStudentAndSubjectWithInteger(STUDENT_RAM, SUBJECT_MATH, 1);
        studentDatabase.addStudentAndSubjectWithInteger(STUDENT_ALB, SUBJECT_ART, 1);

        studentDatabase.addNewStudentForSubject(STUDENT_RAM, SUBJECT_ART, 5);
        Map<Subject, List<Student>> subjectStudents = studentDatabase.getSubjectStudents();
        assertTrue(subjectStudents.containsKey(SUBJECT_MATH));

    }

    @Test
    void testDeleteStudentFromSubject() {
        studentDatabase.addStudentAndSubjectWithInteger(STUDENT_RAM, SUBJECT_MATH, 1);
        studentDatabase.addStudentAndSubjectWithInteger(STUDENT_ALB, SUBJECT_MATH, 1);
        studentDatabase.deleteStudentFromSubject(STUDENT_RAM, SUBJECT_MATH);
        Map<Subject, List<Student>> subjectStudents = studentDatabase.getSubjectStudents();
        assertFalse(subjectStudents.get(SUBJECT_MATH).contains(RAMIL));
    }
}


