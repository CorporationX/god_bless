package school.faang.bjs2_72049;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentServiceTest {
    private List<Student> students;

    @BeforeEach
    void setUp() throws Exception {
        URL resource = getClass().getClassLoader().getResource("students_test_data.json");
        assertNotNull(resource, "Файл students_test_data.json не найден в test/resources");

        String filePath = new File(resource.toURI()).getAbsolutePath();
        StudentDataLoader loader = new JsonStudentDataLoader(filePath);
        students = loader.loadStudents();
    }

    @Test
    void testCalculateSchoolAverage() {
        Map<String, Double> result = StudentService.calculateSchoolAverage(students);
        assertFalse(result.isEmpty());
    }

    @Test
    void testGetStudentFinalGrades() {
        Map<String, Integer> grades = StudentService.getStudentFinalGrades(students, "Олег", "Сидоров");
        assertNotNull(grades);
        assertFalse(grades.isEmpty());
    }

    @Test
    void testGetStudentFinalGrades_notFound() {
        Map<String, Integer> grades = StudentService.getStudentFinalGrades(students, "Не", "Существует");
        assertTrue(grades.isEmpty());
    }

    @Test
    void testFindHardestSubject() {
        String hardest = StudentService.findHardestSubject(students);
        assertNotNull(hardest);
        assertFalse(hardest.isBlank());
    }

    @Test
    void testFindHardestSubject_empty() {
        String result = StudentService.findHardestSubject(List.of());
        assertEquals("Предметы отсутствуют", result);
    }
}
