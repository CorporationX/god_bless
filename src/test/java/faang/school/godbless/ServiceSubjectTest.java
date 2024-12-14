package faang.school.godbless;

import faang.school.godbless.university.ServiceSubject;
import faang.school.godbless.university.Student;
import faang.school.godbless.university.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ServiceSubjectTest {
    private ServiceSubject service = new ServiceSubject();

    @BeforeEach
    void setUp() {
        service = new ServiceSubject();
    }

    @Test
    void testCreateStudentBySubject_Positive() {
        var subject = new Subject(1, "su1");
        List<Student> students = List.of(
                new Student(1, "st1"),
                new Student(2, "st2")
        );

        Map<Subject, List<Student>> expected = Map.of(subject, students);
        var result = service.createStudentBySubject(subject, students);

        assertEquals(expected, result);
    }

    @Test
    void testAddNewStudentToSubject_Positive() {
        var subject = new Subject(1, "su1");
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "st1"),
                new Student(2, "st2"))
        );
        Map<Subject, List<Student>> studentsBySubject = Map.of(subject, students);
        var addStudent = new Student(3, "st3");

        var expected = studentsBySubject;
        expected.get(subject).add(addStudent);
        service.addNewStudentToSubject(studentsBySubject, subject, addStudent);
        var result = studentsBySubject;

        assertEquals(expected.get(subject), result.get(subject));
    }

    @Test
    void testRemoveSubject_Positive() {
        var subject = new Subject(1, "su1");
        var removeStudent = new Student(2, "st2");
        List<Student> students = new ArrayList<>(List.of(
                new Student(1, "st1"),
                removeStudent
        ));
        Map<Subject, List<Student>> studentsBySubject = Map.of(subject, students);

        var expected = studentsBySubject;
        expected.get(subject).remove(removeStudent);
        service.removeSubject(studentsBySubject, subject, removeStudent);
        var result = studentsBySubject;

        assertEquals(expected.get(subject), result.get(subject));
    }

    @Test
    void testCreateStudentBySubject_SubjectNullNegative() {
        Subject nullSubject = null;
        List<Student> students = List.of(
                new Student(1, "st1"),
                new Student(2, "st2")
        );
        assertThrows(IllegalArgumentException.class,
                () -> service.createStudentBySubject(nullSubject, students));
    }

    @Test
    void testCreateStudentBySubject_StudentsNullNegative() {
        var subject = new Subject(1, "su1");
        List<Student> nullStudents = null;
        assertThrows(IllegalArgumentException.class,
                () -> service.createStudentBySubject(subject, nullStudents));
    }

    @Test
    void testCreateStudentBySubject_StudentsIsEmptyNegative() {
        var subject = new Subject(1, "su1");
        List<Student> studentsIsEmpty = new ArrayList<>();
        assertThrows(IllegalArgumentException.class,
                () -> service.createStudentBySubject(subject, studentsIsEmpty));
    }

    @Test
    void testAddNewStudentToSubject_SubjectNullNegative() {
        Subject nullSubject = null;
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "st1"),
                new Student(2, "st2"))
        );
        Map<Subject, List<Student>> studentsBySubject = Map.of(new Subject(1, "su1"), students);
        var addStudent = new Student(3, "st3");

        assertThrows(IllegalArgumentException.class,
                () -> service.addNewStudentToSubject(studentsBySubject, nullSubject, addStudent));
    }

    @Test
    void testAddNewStudentToSubject_StudentsNullNegative() {
        var subject = new Subject(1, "su1");
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "st1"),
                new Student(2, "st2"))
        );
        Map<Subject, List<Student>> studentsBySubject = Map.of(new Subject(1, "su1"), students);
        Student nullStudent = null;

        assertThrows(IllegalArgumentException.class,
                () -> service.addNewStudentToSubject(studentsBySubject, subject, nullStudent));
    }

    @Test
    void testAddNewStudentToSubject_MapIsEmptyNegative() {
        var subject = new Subject(1, "su1");
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "st1"),
                new Student(2, "st2"))
        );
        Map<Subject, List<Student>> studentsBySubject = new HashMap<>();
        var addStudent = new Student(3, "st3");

        assertThrows(IllegalArgumentException.class,
                () -> service.addNewStudentToSubject(studentsBySubject, subject, addStudent));
    }

    @Test
    void testRemoveSubject_SubjectNullNegative() {
        Subject nullSubject = null;
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "st1"),
                new Student(2, "st2"))
        );
        Map<Subject, List<Student>> studentsBySubject = Map.of(new Subject(1, "su1"), students);
        var addStudent = new Student(3, "st3");

        assertThrows(IllegalArgumentException.class,
                () -> service.removeSubject(studentsBySubject, nullSubject, addStudent));
    }

    @Test
    void testRemoveSubject_StudentsNullNegative() {
        var subject = new Subject(1, "su1");
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "st1"),
                new Student(2, "st2"))
        );
        Map<Subject, List<Student>> studentsBySubject = Map.of(new Subject(1, "su1"), students);
        Student nullStudent = null;

        assertThrows(IllegalArgumentException.class,
                () -> service.removeSubject(studentsBySubject, subject, nullStudent));
    }

    @Test
    void testRemoveSubject_MapIsEmptyNegative() {
        var subject = new Subject(1, "su1");
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "st1"),
                new Student(2, "st2"))
        );
        Map<Subject, List<Student>> studentsBySubject = new HashMap<>();
        var addStudent = new Student(3, "st3");

        assertThrows(IllegalArgumentException.class,
                () -> service.removeSubject(studentsBySubject, subject, addStudent));
    }
}