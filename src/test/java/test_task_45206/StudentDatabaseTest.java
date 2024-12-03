package test_task_45206;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import school.faang.task_45206.Student;
import school.faang.task_45206.StudentDatabase;
import school.faang.task_45206.Subject;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentDatabaseTest {
    private StudentDatabase studentDatabase;

    @BeforeEach
    void setUp() {
        studentDatabase = new StudentDatabase();
    }

    static Stream<Arguments> studentWithGradesProviderPositive() {
        Student student1 = new Student(1, "Student1");
        Map<Subject, Integer> grades1 = new HashMap<>();
        grades1.put(new Subject(1, "Математика"), 5);
        grades1.put(new Subject(2, "Информатика"), 5);
        HashMap<Student, Map<Subject, Integer>> expected1 = new HashMap<>();
        expected1.put(student1, grades1);

        Student student2 = new Student(2, "Student2");
        Map<Subject, Integer> grades2 = new HashMap<>();
        grades2.put(new Subject(3, "Английский"), 5);
        grades2.put(new Subject(4, "Литература"), 5);
        HashMap<Student, Map<Subject, Integer>> expected2 = new HashMap<>();
        expected2.put(student2, grades2);

        return Stream.of(
                Arguments.of(student1, grades1, expected1),
                Arguments.of(student2, grades2, expected2)
        );
    }

    @ParameterizedTest
    @MethodSource("studentWithGradesProviderPositive")
    void testStudentDatabase_addStudentWithGradesPositive(Student student, Map<Subject, Integer> grades, HashMap<Student, Map<Subject, Integer>> expected) {
        studentDatabase.addStudentWithGrades(student, grades);
        assertEquals(expected, studentDatabase.studentGrades);
    }

    static Stream<Arguments> subjectForStudentProviderPositive() {
        Student student1 = new Student(5, "Student5");
        Subject subject1 = new Subject(1, "Математика");
        Subject subject2 = new Subject(2, "Информатика");

        Map<Subject, Integer> subjectGrade1 = new HashMap<>();
        subjectGrade1.put(subject1, 5);
        HashMap<Student, Map<Subject, Integer>> expected1 = new HashMap<>();
        expected1.put(student1, subjectGrade1);

        Map<Subject, Integer> subjectGrade2 = new HashMap<>();
        subjectGrade2.put(subject2, 5);
        HashMap<Student, Map<Subject, Integer>> expected2 = new HashMap<>();
        expected2.put(student1, subjectGrade2);

        return Stream.of(
                Arguments.of(student1, subject1, 5, expected1),
                Arguments.of(student1, subject2, 5, expected2)
        );
    }

    @ParameterizedTest
    @MethodSource("subjectForStudentProviderPositive")
    void testStudentDatabase_addSubjectForStudentPositive(Student student, Subject subject, Integer grade, HashMap<Student, Map<Subject, Integer>> expected) {
        studentDatabase.studentGrades.put(new Student(5, "Student5"), new HashMap<>());
        studentDatabase.addSubjectForStudent(student, subject, grade);
        assertEquals(expected, studentDatabase.studentGrades);
    }

    @Test
    void testStudentDatabase_addSubjectForStudentNegative() {
        Student student = new Student(1, "Student1");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> studentDatabase.addSubjectForStudent(student, new Subject(1, ""), 5));
        assertEquals("Такого студента не существует", ex.getMessage());
    }

    @Test
    void testStudentDatabase_deleteStudentPositive() {
        Student student1 = new Student(5, "Student5");
        studentDatabase.studentGrades.put(student1, new HashMap<>());
        studentDatabase.deleteStudent(student1);
        assertEquals(new HashMap<>(), studentDatabase.studentGrades);
    }

    @Test
    void testStudentDatabase_deleteStudentNegative() {
        Student student = new Student(1, "Student1");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> studentDatabase.addSubjectForStudent(student, new Subject(1, ""), 5));
        assertEquals("Такого студента не существует", ex.getMessage());
    }
}
