package school.faang.bjs2_70830;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentServiceTest {
    private final StudentService studentService = new StudentService();

    @Test
    void testGetMostDifficultSubject_shouldReturnSubjectWithLowestAverage() {
        Subject math = new Subject("Math");
        Subject chemistry = new Subject("Chemistry");
        Subject history = new Subject("History");

        Student student1 = new Student("Alice", "Smith", Map.of(
                math, List.of(4, 5),
                chemistry, List.of(3, 3),
                history, List.of(4)
        ));

        Student student2 = new Student("Bob", "Johnson", Map.of(
                math, List.of(2, 3),
                chemistry, List.of(2, 2),
                history, List.of(5)
        ));

        List<Student> students = List.of(student1, student2);

        Subject hardest = studentService.getMostDifficultSubject(students);

        assertEquals(chemistry, hardest);
    }

    @Test
    void testGetMostDifficultSubject_whenStudentsIsNull_shouldThrowParamsInStudentServiceIsNullException() {
        assertThrows(ParamsInStudentServiceIsNullException.class, () -> {
            studentService.getMostDifficultSubject(null);
        });
    }

    @Test
    void testGetMostDifficultSubject_whenNoSubjectsFound_shouldThrowSubjectNotFoundException() {
        List<Student> students = List.of(
                new Student("John", "Doe", Map.of()),
                new Student("John", "Clark", Map.of())
        );

        assertThrows(SubjectNotFoundException.class, () -> {
            studentService.getMostDifficultSubject(students);
        });
    }

    @Test
    public void testGetFinalGradesForStudent_success() {
        Subject math = new Subject("Math");
        Subject history = new Subject("History");

        Map<Subject, List<Integer>> courses = new HashMap<>();
        courses.put(math, Arrays.asList(5, 4, 3));
        courses.put(history, Arrays.asList(4, 4, 5));

        Student student = new Student("Ivan", "Ivanov", courses);

        List<Student> students = List.of(student);

        Map<Subject, Integer> finalGrades = new StudentService().getFinalGradesForStudent(students,
                "Ivan", "Ivanov");

        assertEquals(2, finalGrades.size());
        assertEquals(4, finalGrades.get(math));
        assertEquals(4, finalGrades.get(history));
    }

    @Test
    public void testGetFinalGradesForStudent_studentNotFound() {
        List<Student> students = List.of(new Student("Anna", "Petrova", Map.of()));

        assertThrows(StudentNotFoundException.class, () -> {
            new StudentService().getFinalGradesForStudent(students, "Ivan", "Ivanov");
        });
    }

    @Test
    public void testGetFinalGradesForStudent_studentsListIsNull() {
        assertThrows(ParamsInStudentServiceIsNullException.class, () -> {
            new StudentService().getFinalGradesForStudent(null, "Ivan", "Ivanov");
        });
    }
}
