package faang.school.godbless;

import faang.school.godbless.university.ServiceStudent;
import faang.school.godbless.university.Student;
import faang.school.godbless.university.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ServiceStudentTest {
    private ServiceStudent service = new ServiceStudent();

    @BeforeEach
    void setUp() {
        service = new ServiceStudent();
    }

    @Test
    void testCreateStudent_Positive() {
        Map<Subject, Integer> subjectWithGrade = new HashMap<>();
        var student = new Student(1, "s1");
        subjectWithGrade.put(new Subject(1, "su1"), 3);

        Map<Student, Map<Subject, Integer>> expected = new HashMap<>();
        expected.put(student, subjectWithGrade);
        var result = service.createSubjectByStudent(student, subjectWithGrade);

        assertEquals(expected, result);
    }

    @Test
    void testAddNewStudent_Positive() {
        Map<Student, Map<Subject, Integer>> subjectByStudent = new HashMap<>();
        Map<Subject, Integer> subjectWithGrade = new HashMap<>();
        var student = new Student(1, "s1");
        var subject = new Subject(1, "su1");
        subjectWithGrade.put(subject, 3);
        subjectByStudent.put(student, subjectWithGrade);
        var newStudent = new Student(2, "s2");

        var expected = subjectByStudent;
        expected.put(newStudent, subjectWithGrade);
        var result = service.addNewSubjectsToStudent(subjectByStudent, newStudent, subject, 3);

        assertEquals(expected, result);
    }

    @Test
    void testRemoveStudent_Positive() {
        var student = new Student(1, "s1");
        var removeStudent = new Student(2, "s2");
        Map<Subject, Integer> subjectWithGrade = Map.of(new Subject(1, "su1"), 3);
        Map<Student, Map<Subject, Integer>> subjectByStudent = new HashMap<>();
        subjectByStudent.put(student, subjectWithGrade);
        subjectByStudent.put(removeStudent, subjectWithGrade);

        var expected = subjectByStudent;
        expected.remove(removeStudent);
        var result = service.removeStudent(subjectByStudent, removeStudent);

        assertEquals(expected, result);
    }

    @Test
    void testCreateStudent_NullStudent() {
        Map<Subject, Integer> subjectWithGrade = new HashMap<>();
        Student nullStudent = null;
        subjectWithGrade.put(new Subject(1, "su1"), 3);

        assertThrows(IllegalArgumentException.class, () -> service.createSubjectByStudent(nullStudent, subjectWithGrade));
    }

    @Test
    void testCreateStudent_EmptyMap() {
        Map<Subject, Integer> subjectWithGrade = new HashMap<>();
        var notNullStudent = new Student(1, "s1");

        assertThrows(IllegalArgumentException.class, () -> service.createSubjectByStudent(notNullStudent, subjectWithGrade));
    }

    @Test
    void testAddNewStudent_NullStudent() {
        Map<Student, Map<Subject, Integer>> subjectByStudent = new HashMap<>();
        Map<Subject, Integer> subjectWithGrade = new HashMap<>();
        var student = new Student(1, "s1");
        var subject = new Subject(1, "su1");
        subjectWithGrade.put(subject, 3);
        subjectByStudent.put(student, subjectWithGrade);
        Student nullStudent = null;

        assertThrows(IllegalArgumentException.class,
                () -> service.addNewSubjectsToStudent(subjectByStudent, nullStudent, subject, 3));
    }

    @Test
    void testAddNewStudent_EmptyMap() {
        Map<Student, Map<Subject, Integer>> subjectByStudent = new HashMap<>();
        var student = new Student(1, "s1");
        var subject = new Subject(1, "su1");
        var newStudent = new Student(2, "s2");

        assertThrows(IllegalArgumentException.class,
                () -> service.addNewSubjectsToStudent(subjectByStudent, newStudent, subject, 3));
    }
}