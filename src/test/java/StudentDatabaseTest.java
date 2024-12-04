import org.junit.jupiter.api.BeforeEach;
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

public class StudentDatabaseTest {
    private StudentDatabase studentDatabase;

    @BeforeEach
    void setUp() {
        studentDatabase = new StudentDatabase();
    }

    static Stream<Arguments> studentWithGradesProviderPositive() {
        Student student = new Student(1, "Student1");
        Map<Subject, Integer> subjectsGrades = new HashMap<>();
        Map<Student, Map<Subject, Integer>> expected = new HashMap<>();

        subjectsGrades.put(new Subject(1, "Subject1"), 5);
        subjectsGrades.put(new Subject(2, "Subject2"), 5);

        expected.put(student, subjectsGrades);

        return Stream.of(
                Arguments.of(student, subjectsGrades, expected)
        );
    }

    @ParameterizedTest
    @MethodSource("studentWithGradesProviderPositive")
    void testStudentDatabase_addStudentWithGradesPositive(
            Student student,
            Map<Subject, Integer> subjectsGrades,
            Map<Student, Map<Subject, Integer>> expected
    ) {
        studentDatabase.addStudentWithGrades(student, subjectsGrades);
        assertEquals(expected, studentDatabase.studentGrades);
    }
}