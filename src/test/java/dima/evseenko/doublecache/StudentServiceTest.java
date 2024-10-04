package dima.evseenko.doublecache;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentServiceTest {

    @Test
    void addStudentMark(){
        StudentService studentService = new StudentService();
        studentService.addStudentMark(new Student(1L, "Dima"), new Subject(1L, "Math"), 4);

        assertTrue(studentService.getStudentMarks(new Student(1L, "Dima")).containsKey(new Subject(1L, "Math")));
    }

    @Test
    void addStudentMarks(){
        StudentService studentService = new StudentService();
        studentService.addStudentMarks(new Student(1L, "Dima"), Map.of(
                new Subject(1L, "Math"), 4,
                new Subject(2L, "Physics"), 3
        ));

        assertTrue(studentService.getStudentMarks(new Student(1L, "Dima")).containsKey(new Subject(1L, "Math")));
        assertTrue(studentService.getStudentMarks(new Student(1L, "Dima")).containsKey(new Subject(2L, "Physics")));
    }

    @Test
    void deleteSubjectFromMarks(){
        StudentService studentService = new StudentService();
        studentService.addStudentMark(new Student(1L, "Dima"), new Subject(1L, "Math"), 4);
        studentService.deleteSubjectFromMarks(new Student(1L, "Dima"), new Subject(1L, "Math"));

        assertFalse(studentService.getStudentMarks(new Student(1L, "Dima")).containsKey(new Subject(1L, "Math")));
    }

    @Test
    void deleteStudentFromMarks(){
        StudentService studentService = new StudentService();
        studentService.addStudentMark(new Student(1L, "Dima"), new Subject(1L, "Math"), 4);
        studentService.deleteStudentFromMarks(new Student(1L, "Dima"));

        assertNull(studentService.getStudentMarks(new Student(1L, "Dima")));
    }

    @Test
    void addSubjectStudent(){
        StudentService studentService = new StudentService();
        studentService.addSubjectStudent(new Subject(1L, "Math"), new Student(1L, "Dima"));

        assertTrue(studentService.getSubjectStudents(new Subject(1L, "Math")).contains(new Student(1L, "Dima")));
    }

    @Test
    void addSubjectStudents(){
        StudentService studentService = new StudentService();
        studentService.addSubjectStudents(new Subject(1L, "Math"), List.of(
                new Student(1L, "Dima"),
                new Student(2L, "Vasya")
        ));

        assertTrue(studentService.getSubjectStudents(new Subject(1L, "Math")).contains(new Student(1L, "Dima")));
        assertTrue(studentService.getSubjectStudents(new Subject(1L, "Math")).contains(new Student(2L, "Vasya")));
    }

    @Test
    void deleteStudentFromSubject(){
        StudentService studentService = new StudentService();
        studentService.addSubjectStudents(new Subject(1L, "Math"), List.of(
                new Student(1L, "Dima"),
                new Student(2L, "Vasya")
        ));

        studentService.deleteStudentFromSubject(new Subject(1L, "Math"), new Student(2L, "Vasya"));

        assertFalse(studentService.getSubjectStudents(new Subject(1L, "Math")).contains(new Student(2L, "Vasya")));
    }

    @Test
    void getStudentMarks(){
        StudentService studentService = new StudentService();
        studentService.addStudentMarks(new Student(1L, "Dima"), Map.of(
                new Subject(1L, "Math"), 4,
                new Subject(2L, "Physics"), 3
        ));

        assertEquals(Map.of(
                new Subject(1L, "Math"), 4,
                new Subject(2L, "Physics"), 3
        ), studentService.getStudentMarks(new Student(1L, "Dima")));
    }

    @Test
    void getSubjectStudents(){
        StudentService studentService = new StudentService();
        studentService.addSubjectStudents(new Subject(1L, "Math"), List.of(
                new Student(1L, "Dima"),
                new Student(2L, "Vasya")
        ));

        assertEquals(List.of(
                new Student(1L, "Dima"),
                new Student(2L, "Vasya")
        ), studentService.getSubjectStudents(new Subject(1L, "Math")));
    }
}