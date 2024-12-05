package school.faang.task_45225;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentDatabaseTest {
    private StudentDatabase studentDatabase;

    @BeforeEach
    void init() {
        Map<Student, Map<Subject, Integer>> subjectsByStudent = Utils.initSubjectsByStudent();
        Map<Subject, List<Student>> studentsBySubject = Utils.initStudentsBySubject();
        studentDatabase = new StudentDatabase(subjectsByStudent, studentsBySubject);
    }

    @AfterEach
    void destroy() {
        studentDatabase = null;
    }

    @Test
    void shouldAddStudentWithSubjectAndGrade() {
        Student newStudent = new Student(8, "Fedor");
        Subject newSubject = new Subject(8, "Chemistry");

        studentDatabase.addStudentWithSubjectsAndGrades(newStudent, Map.of(newSubject, 5));

        int expectedGrade = 5;
        int actualGrade = studentDatabase.getSubjectsAndGradesByStudents().get(newStudent).get(newSubject);
        assertEquals(expectedGrade, actualGrade);
    }

    @Test
    void shouldBeThrowsWhenAddExistStudent() {
        Student student = new Student(1, "Vasya");
        assertThrows(IllegalArgumentException.class,
                () -> studentDatabase.addStudentWithSubjectsAndGrades(student, Map.of()));
    }

    @Test
    void shouldAddNewSubjectAndGradeForExistingStudent() {
        Subject newSubject = new Subject(10, "Psychology");
        Student student = new Student(1, "Vasya");

        studentDatabase.addSubjectAndGradeForExistingStudent(student, newSubject, 4);

        assertTrue(studentDatabase.getSubjectsAndGradesByStudents().get(student).containsKey(newSubject));
    }

    @Test
    void shouldDeleteStudentsWithSubjectsAndGrades() {
        Student student = new Student(1, "Vasya");

        studentDatabase.deleteStudentWithSubjectsAndGrades(student);

        int expectedSize = 2;
        assertEquals(expectedSize, studentDatabase.getSubjectsAndGradesByStudents().size());
    }

    @Test
    void shouldAddSubjectWithStudent() {
        Subject newSubject = new Subject(8, "Chemistry");
        List<Student> newStudents = List.of(new Student(11, "Kate"), new Student(12, "Liza"));

        studentDatabase.addSubjectWithStudents(newSubject, newStudents);

        int expectedCountStudents = 2;
        int actualCountStudents = studentDatabase.getStudentsBySubject().get(newSubject).size();
        assertEquals(expectedCountStudents, actualCountStudents);
    }

    @Test
    void shouldBeThrowWhenAddExistSubjectWithStudents() {
        Subject subject = new Subject(1, "Math");

        assertThrows(IllegalArgumentException.class, () -> studentDatabase.addSubjectWithStudents(subject, List.of()));
    }

    @Test
    void shouldAddStudentAtExistingSubject() {
        Student newStudent = new Student(9, "Alena");
        Subject subject = new Subject(1, "Math");

        studentDatabase.addStudentAtExistingSubject(newStudent, subject);

        int expectedCountStudents = 4;
        int actualCountStudents = studentDatabase.getStudentsBySubject().get(subject).size();
        assertEquals(expectedCountStudents, actualCountStudents);
    }

    @Test
    void shouldBeThrowWhenAddExistSubject() {
        Subject subject = new Subject(1, "Math");

        assertThrows(IllegalArgumentException.class, () -> studentDatabase.addSubjectWithStudents(subject, List.of()));
    }

    @Test
    void shouldDeleteStudentsAtSubject() {
        Student student = new Student(1, "Vasya");
        Subject subject = new Subject(1, "Math");
        studentDatabase.deleteStudentAtSubject(student, subject);

        int expectedCountStudents = 2;
        int actualCountStudents = studentDatabase.getStudentsBySubject().get(subject).size();
        assertEquals(expectedCountStudents, actualCountStudents);
    }

}