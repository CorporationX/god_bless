package ElectronicDiary;

import faang.school.godbless.ElectronicDiary.Student;
import faang.school.godbless.ElectronicDiary.StudentService;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static faang.school.godbless.ElectronicDiary.StudentService.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentServiceTest {
    Student student = new Student("Ivan", "Ivanov", Map.of("Mathematics", List.of(5, 5, 3, 4, 5), "Chemistry", List.of(3, 4, 5, 1, 2)));
    Student student1 = new Student("Petr", "Smirnov", Map.of("Mathematics", List.of(1, 2, 3, 4, 5), "Chemistry", List.of(3, 4, 5, 1, 2)));
    Student student2 = new Student("Fedor", "Fedorov", Map.of("Mathematics", List.of(1, 2, 3, 4, 5), "Chemistry", List.of(3, 4, 5, 1, 2)));
    Student student3 = new Student("Sergey", "Sergeev", Map.of("Mathematics", List.of(1, 2, 3, 4, 5), "Chemistry", List.of(3, 4, 5, 1, 2)));

    List<Student> students = List.of(student, student1, student2, student3);

    @Test
    void averageGradeTest() {
        Map<String, Double> result = averageGrade(students);

        assertEquals(3.35, result.get("Mathematics"));
        assertEquals(3.0, result.get("Chemistry"));
        assertEquals(2, result.size());
    }

    @Test
    void finalGradeTest() {
        Map<String, Integer> result = finalGrade(students, "Ivan", "Ivanov");

        assertEquals(4, result.get("Mathematics"));
        assertEquals(3, result.get("Chemistry"));
        assertEquals(2, result.size());
    }

    @Test
    void hardestMajorTest() {
        Map<String, Double> result = hardestMajor(students);

        assertEquals(3.0, result.get("Chemistry"));
        assertEquals(1, result.size());
    }
}
