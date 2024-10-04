package dima.evseenko.doublecache;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UniversityTest {

    @Test
    void addStudentMark(){
        University university = new University();
        university.addStudentMark(new Student(1L, "Dima"), new Subject(1L, "Math"), 4);

        assertTrue(university.getStudentMarks(new Student(1L, "Dima")).containsKey(new Subject(1L, "Math")));
    }

    @Test
    void addStudentMarks(){
        University university = new University();
        university.addStudentMarks(new Student(1L, "Dima"), Map.of(
                new Subject(1L, "Math"), 4,
                new Subject(2L, "Physics"), 3
        ));

        assertTrue(university.getStudentMarks(new Student(1L, "Dima")).containsKey(new Subject(1L, "Math")));
        assertTrue(university.getStudentMarks(new Student(1L, "Dima")).containsKey(new Subject(2L, "Physics")));
    }

    @Test
    void deleteSubjectFromMarks(){
        University university = new University();
        university.addStudentMark(new Student(1L, "Dima"), new Subject(1L, "Math"), 4);
        university.deleteSubjectFromMarks(new Student(1L, "Dima"), new Subject(1L, "Math"));

        assertFalse(university.getStudentMarks(new Student(1L, "Dima")).containsKey(new Subject(1L, "Math")));
    }

    @Test
    void deleteStudentFromMarks(){
        University university = new University();
        university.addStudentMark(new Student(1L, "Dima"), new Subject(1L, "Math"), 4);
        university.deleteStudentFromMarks(new Student(1L, "Dima"));

        assertNull(university.getStudentMarks(new Student(1L, "Dima")));
    }

    @Test
    void addSubjectStudent(){
        University university = new University();
        university.addSubjectStudent(new Subject(1L, "Math"), new Student(1L, "Dima"));

        assertTrue(university.getSubjectStudents(new Subject(1L, "Math")).contains(new Student(1L, "Dima")));
    }

    @Test
    void addSubjectStudents(){
        University university = new University();
        university.addSubjectStudents(new Subject(1L, "Math"), List.of(
                new Student(1L, "Dima"),
                new Student(2L, "Vasya")
        ));

        assertTrue(university.getSubjectStudents(new Subject(1L, "Math")).contains(new Student(1L, "Dima")));
        assertTrue(university.getSubjectStudents(new Subject(1L, "Math")).contains(new Student(2L, "Vasya")));
    }

    @Test
    void deleteStudentFromSubject(){
        University university = new University();
        university.addSubjectStudents(new Subject(1L, "Math"), List.of(
                new Student(1L, "Dima"),
                new Student(2L, "Vasya")
        ));

        university.deleteStudentFromSubject(new Subject(1L, "Math"), new Student(2L, "Vasya"));

        assertFalse(university.getSubjectStudents(new Subject(1L, "Math")).contains(new Student(2L, "Vasya")));
    }

    @Test
    void getStudentMarks(){
        University university = new University();
        university.addStudentMarks(new Student(1L, "Dima"), Map.of(
                new Subject(1L, "Math"), 4,
                new Subject(2L, "Physics"), 3
        ));

        assertEquals(Map.of(
                new Subject(1L, "Math"), 4,
                new Subject(2L, "Physics"), 3
        ), university.getStudentMarks(new Student(1L, "Dima")));
    }

    @Test
    void getSubjectStudents(){
        University university = new University();
        university.addSubjectStudents(new Subject(1L, "Math"), List.of(
                new Student(1L, "Dima"),
                new Student(2L, "Vasya")
        ));

        assertEquals(List.of(
                new Student(1L, "Dima"),
                new Student(2L, "Vasya")
        ), university.getSubjectStudents(new Subject(1L, "Math")));
    }
}