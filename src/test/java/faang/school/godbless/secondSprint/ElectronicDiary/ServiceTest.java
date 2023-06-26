package faang.school.godbless.secondSprint.ElectronicDiary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    List<Student> students;

    @BeforeEach
    public void setUp() {
        students = List.of(
                new Student("a", "s", Map.of("Math", List.of(4, 5, 3, 5),
                        "English", List.of(3, 4, 3), "Biology", List.of(2, 2))),
                new Student("s", "s", Map.of("Math", List.of(5),
                        "English", List.of(5, 4, 5)))
        );
    }

    @Test
    public void testCalculateAvgGrade() {
        Map<String, Double> result = Service.calculateAvgGrade(students);

        assertEquals(3, result.size());
        assertEquals(4.4, result.get("Math"));
        assertEquals(4, result.get("English"));
        assertEquals(2, result.get("Biology"));
    }

    @Test
    public void testCalculateFinalGrade() {
        Map<String, Integer> result = Service.calculateFinalGrade(students, "a", "s");

        assertEquals(3, result.size());
        assertEquals(4, result.get("Math"));
        assertEquals(3, result.get("English"));
        assertEquals(2, result.get("Biology"));
    }

    @Test
    public void testFindHardestSubject() {
        String result = Service.findHardestSubject(students);

        assertEquals("Biology", result);
    }

    @Test
    public void testCalculateFinalGradeThrowExc() {
        assertThrows(IllegalArgumentException.class, () -> Service.calculateFinalGrade(students, "b", "s"));
    }

    @Test
    public void testFindHardestSubjectThrowExcWithEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> Service.findHardestSubject(List.of()));
    }
}