package electronic_diary;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SchoolTest {
    private static JsonReader jsonReader = new JsonReader();
    private static final List<Student> STUDENTS = jsonReader.readStudentsFromJson("/students_test_data.json");
    @Test
    void averageGrades() {
        Map<String, Double> averageGrades = School.averageGrades(STUDENTS);
        assertEquals(3.4676056338028167, averageGrades.get("Математика"));
        assertEquals(3.5628415300546448, averageGrades.get("Физика"));
        assertEquals(3.56797583081571, averageGrades.get("Химия"));
    }

    @Test
    void finalGrades() {
        Map<String, Integer> finalGrades = School.finalGrades(STUDENTS, "Олег", "Сидоров");
        assertEquals(4, finalGrades.get("Математика"));
        assertEquals(4, finalGrades.get("Физика"));
    }

    @Test
    void hardestSubject() {
        Optional<String> hardestSubject = School.hardestSubject(STUDENTS);
        assertNotNull(hardestSubject);
        assertEquals("История", hardestSubject.get());
    }

    @Test
    void printPerformanceTable() {
        assertNotNull(STUDENTS);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        School.printPerformanceTable(STUDENTS);

        assertTrue(outContent.toString().contains("ФИО                  | Математика"));

        System.setOut(originalOut);
    }
}