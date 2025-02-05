package school.faang.doublecache;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStudentDatabase {

    @Test
    public void testAddStudent() {
        Student student = new Student("Kolya");
        Subject math = new Subject("Math");
        Subject physics = new Subject("Physics");
        Map<Subject, Integer> subjects = Map.of(math, 5, physics, 4);

        StudentDatabase.addStudent(student, subjects);

        assertEquals(1, StudentDatabase.STUDENT_SUBJECTS.size(), "Should add student to map");
        assertEquals(2, StudentDatabase.STUDENT_SUBJECTS.get(student).size(), "Should add subjects");
    }

    @Test
    public void testAddSubject() {
        Subject subject = new Subject("Math");
        int grade = 5;
        Student student = new Student("Alex");

        StudentDatabase.addSubject(subject, grade, student);

        assertEquals(1, StudentDatabase.STUDENT_SUBJECTS.size(), "Should add student to STUDENT_SUBJECTS");
        assertEquals(1, StudentDatabase.SUBJECT_STUDENTS.size(), "Should add subject to SUBJECT_STUDENTS");
    }

    @Test
    public void testDeleteStudent() {
        Student student = new Student("Kolya");
        Subject math = new Subject("Math");
        Subject physics = new Subject("Physics");
        Map<Subject, Integer> subjects = Map.of(math, 5, physics, 4);

        StudentDatabase.addStudent(student, subjects);
        StudentDatabase.deleteStudent(student);

        assertEquals(0, StudentDatabase.STUDENT_SUBJECTS.size(), "Should delete student from STUDENT_SUBJECTS");
        assertEquals(0, StudentDatabase.SUBJECT_STUDENTS.size(), "Should delete subject from SUBJECT_STUDENTS");
    }

    @Test
    public void testAddSubjectStudents() {
        Subject subject = new Subject("Math");
        List<Student> students = List.of(new Student("Kolya"), new Student("Vasya"));

        StudentDatabase.addSubjectStudents(subject, students);

        assertEquals(1, StudentDatabase.SUBJECT_STUDENTS.size(), "Should add subject to SUBJECT_STUDENTS");
        assertEquals(2, StudentDatabase.SUBJECT_STUDENTS.get(subject).size(),
                "Should add list of students to SUBJECT_STUDENTS");
        assertEquals(2, StudentDatabase.STUDENT_SUBJECTS.size(), "Should add subject to STUDENT_SUBJECTS");
    }

    @Test
    public void testAddStudentToSubject() {
        Student student = new Student("Kolya");
        Subject subject = new Subject("Math");

        StudentDatabase.addStudentToSubject(student, subject);

        assertEquals(1, StudentDatabase.STUDENT_SUBJECTS.size(), "Should add subject to STUDENT_SUBJECTS");
        assertEquals(1, StudentDatabase.SUBJECT_STUDENTS.size(), "Should add subject to SUBJECT_STUDENTS");
    }

    @Test
    public void testDeleteStudentFromSubject() {
        Student student = new Student("Kolya");
        Subject subject = new Subject("Math");

        StudentDatabase.addStudentToSubject(student, subject);
        StudentDatabase.deleteStudentFromSubject(student, subject);

        assertEquals(0, StudentDatabase.STUDENT_SUBJECTS.size(), "Should delete student from STUDENT_SUBJECTS");
        assertEquals(0, StudentDatabase.SUBJECT_STUDENTS.size(), "Should delete subject from SUBJECT_STUDENTS");
    }
}
