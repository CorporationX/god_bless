package school.faang.hashmap.doublekesh;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.hashmap.doublekesh.hashmap.doublekesh.Main;
import school.faang.hashmap.doublekesh.hashmap.doublekesh.Student;
import school.faang.hashmap.doublekesh.hashmap.doublekesh.Subject;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    Main main;
    Student student = new Student(1,"Student 1");
    Subject subject = new Subject(1,"Subject 1");
    int mark = 2;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void printSubjectListStudentsTest() {
        String expectedString = "Subject : Subject(id=1, name=Subject 1) \nStudents : [Student(id=1, name=Student 1)] \n";

        main.addMark(subject, student, mark);

        PrintStream defaultOut = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(byteArrayOutputStream);
        System.setOut(newOut);

        main.printSubjectListStudents();
        System.setOut(defaultOut);

        assertEquals(byteArrayOutputStream.toString(), expectedString, "Check 0.1");
    }

    @Test
    void addStudentTest() {
        main.addStudent(student);

        assertNotNull(main.getStudentSubjectsMarks(), "Check 1.1");
        assertEquals(1, main.getStudentSubjectsMarks().size(), "Check 1.2");
        assertTrue(main.getStudentSubjectsMarks().containsKey(student), "Check 1.3");
        assertNotNull(main.getStudentSubjectsMarks().get(student),"Check 1.4");
        assertTrue(main.getStudentSubjectsMarks().get(student).isEmpty(), "Check 1.5");

        assertNotNull(main.getSubjectListStudents(), "Check 1.6");
        assertTrue(main.getSubjectListStudents().isEmpty(), "Check 1.7");
    }

    @Test
    void addStudentToSubjectTest() {
        main.addStudentToSubject(subject, student);

        assertNotNull(main.getStudentSubjectsMarks(), "Check 2.1");
        assertEquals(1, main.getStudentSubjectsMarks().size(),  "Check 2.2");
        assertTrue(main.getStudentSubjectsMarks().containsKey(student), "Check 2.3");
        assertNotNull(main.getStudentSubjectsMarks().get(student),"Check 2.4");
        assertTrue(main.getStudentSubjectsMarks().get(student).isEmpty(), "Check 2.5");

        assertNotNull(main.getSubjectListStudents(), "Check 2.6");
        assertEquals(1, main.getSubjectListStudents().size(), "Check 2.7");
        assertTrue(main.getSubjectListStudents().containsKey(subject), "Check 2.8");
        assertEquals(1, main.getSubjectListStudents().get(subject).size(), "Check 2.9");
        assertEquals(main.getSubjectListStudents().get(subject).get(0), student, "Check 2.10");
    }

    @Test
    void addMarkTest() {

        main.addMark(subject, student, mark);

        assertNotNull(main.getStudentSubjectsMarks(), "Check 3.1");
        assertEquals(1,main.getStudentSubjectsMarks().size(), "Check 3.2");
        assertTrue(main.getStudentSubjectsMarks().containsKey(student), "Check 3.3");
        assertNotNull(main.getStudentSubjectsMarks().get(student),"Check 3.4");
        assertEquals(1, main.getStudentSubjectsMarks().get(student).size(), "Check 3.5");
        assertEquals(mark, main.getStudentSubjectsMarks().get(student).get(subject), "Check 3.6");

        assertNotNull(main.getSubjectListStudents(), "Check 3.7");
        assertEquals(main.getSubjectListStudents().size(), 1, "Check 3.8");
        assertTrue(main.getSubjectListStudents().containsKey(subject), "Check 3.9");
        assertEquals(1, main.getSubjectListStudents().get(subject).size(),  "Check 3.10");
        assertEquals(main.getSubjectListStudents().get(subject).get(0), student, "Check 3.11");
    }

    @Test
    void deleteSubjectForStudentTest() {

        main.addMark(subject, student, mark);
        main.deleteSubjectForStudent(subject, student);

        assertNotNull(main.getStudentSubjectsMarks(), "Check 4.1");
        assertEquals(1, main.getStudentSubjectsMarks().size(),  "Check 4.2");
        assertTrue(main.getStudentSubjectsMarks().containsKey(student), "Check 4.3");
        assertNotNull(main.getStudentSubjectsMarks().get(student),"Check 4.4");
        assertTrue(main.getStudentSubjectsMarks().get(student).isEmpty(),"Check 4.5");

        assertNotNull(main.getSubjectListStudents(), "Check 4.6");
        assertEquals(1, main.getSubjectListStudents().size(), "Check 4.7");
        assertTrue(main.getSubjectListStudents().containsKey(subject), "Check 4.8");
        assertTrue(main.getSubjectListStudents().get(subject).isEmpty(),  "Check 4.9");
    }

    @Test
    void deleteStudentTest() {
        main.addMark(subject, student, mark);
        main.deleteStudent(student);

        assertNotNull(main.getStudentSubjectsMarks(), "Check 5.1");
        assertTrue(main.getStudentSubjectsMarks().isEmpty(),  "Check 5.2");

        assertNotNull(main.getSubjectListStudents(), "Check 5.3");
        assertEquals(1, main.getSubjectListStudents().size(), "Check 5.4");
        assertTrue(main.getSubjectListStudents().containsKey(subject), "Check 5.5");
        assertTrue(main.getSubjectListStudents().get(subject).isEmpty(),  "Check 5.6");
    }
}