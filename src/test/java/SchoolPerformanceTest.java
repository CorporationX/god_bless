import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.SchoolPerformance;
import school.faang.Student;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SchoolPerformanceTest {

    private List<Student> students;

    @BeforeEach
    void setUp() {
        Map<String, List<Integer>> courses1 = new HashMap<>();
        courses1.put("Math", List.of(3, 4, 3));
        courses1.put("English", List.of(5, 4, 3));

        Map<String, List<Integer>> courses2 = new HashMap<>();
        courses2.put("Math", List.of(5, 4, 5));
        courses2.put("English", List.of(5, 5, 4));

        Map<String, List<Integer>> courses3 = new HashMap<>();
        courses3.put("Math", List.of(2, 3, 5));
        courses3.put("Science", List.of(4, 4, 4));

        students = List.of(
                new Student("Aleksey", "Tikhonov", courses1),
                new Student("Maria", "Kuznetsova", courses2),
                new Student("Anna", "Johnson", courses3)
        );
    }

    @Test
    void testGetAverageGradeForSubjects_basicCase() {
        Map<String, Double> averageGrades = SchoolPerformance.getAverageGradeForSubjects(students);
        assertEquals(3.77, averageGrades.get("Math"), 0.01);
        assertEquals(4.33, averageGrades.get("English"), 0.01);
        assertEquals(4.0, averageGrades.get("Science"), 0.01);
    }

    @Test
    void testGetAverageGradeForSubjects_noGradesForSubject() {
        Student student = new Student("John", "Doe", Map.of("Math", List.of(4, 5, 3)));
        Map<String, Double> averageGrades = SchoolPerformance.getAverageGradeForSubjects(List.of(student));
        assertNull(averageGrades.get("English"));
    }

    @Test
    void testGetAverageGradeForSubjects_emptyStudentList() {
        assertTrue(SchoolPerformance.getAverageGradeForSubjects(Collections.emptyList()).isEmpty());
    }

    @Test
    void testGetAverageGradeForSubjects_nullStudentList() {
        assertThrows(IllegalArgumentException.class, () -> SchoolPerformance.getAverageGradeForSubjects(null));
    }

    @Test
    void testGetAverageGradeForStudent_validStudent() {
        Map<String, Double> result = SchoolPerformance.getAverageGradeForStudent(
                students, "Aleksey", "Tikhonov");
        assertEquals(4.0, result.get("English"), 0.01);
        assertEquals(3.33, result.get("Math"), 0.01);
    }

    @Test
    void testGetAverageGradeForStudent_noStudentInList() {
        assertTrue(SchoolPerformance.getAverageGradeForStudent(students, "John", "Doe").isEmpty());
    }

    @Test
    void testGetAverageGradeForStudent_noCourses() {
        Student student = new Student("Aleksey", "Tikhonov", new HashMap<>());
        assertTrue(SchoolPerformance.getAverageGradeForStudent(List.of(student), "Aleksey", "Tikhonov").isEmpty());
    }

    @Test
    void testGetAverageGradeForStudent_multipleStudentsSameName() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Aleksey", "Tikhonov", Map.of("Math", List.of(4, 5))));
        students.add(new Student("Aleksey", "Tikhonov", Map.of("Science", List.of(3, 4))));
        Map<String, Double> result = SchoolPerformance.getAverageGradeForStudent(
                students, "Aleksey", "Tikhonov");
        assertEquals(4.5, result.get("Math"), 0.01);
        assertEquals(3.5, result.get("Science"), 0.01);
    }

    @Test
    void testGetAverageGradeForStudent_emptyStudentList() {
        assertTrue(SchoolPerformance.getAverageGradeForStudent(
                Collections.emptyList(), "John", "Doe").isEmpty());
    }

    @Test
    void testGetAverageGradeForStudent_NullStudentList() {
        assertThrows(IllegalArgumentException.class,
                () -> SchoolPerformance.getAverageGradeForStudent(null, "John", "Doe"));
    }

    @Test
    void testGetHardestSubject_basicCase() {
        String hardestSubject = SchoolPerformance.getHardestSubject(students);
        assertEquals("Math", hardestSubject);
    }

    @Test
    void testGetHardestSubject_noStudents() {
        assertThrows(NoSuchElementException.class,
                () -> SchoolPerformance.getHardestSubject(Collections.emptyList()));
    }

    @Test
    void testGetHardestSubject_nullStudents() {
        assertThrows(IllegalArgumentException.class,
                () -> SchoolPerformance.getHardestSubject(null));
    }
}
