package electronic_diary;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JsonReaderTest {
    @Test
    void readStudentsFromJson() {
        JsonReader jsonReader = new JsonReader();
        List<Student> students = jsonReader.readStudentsFromJson("/students_test_data.json");
        assertNotNull(students);
        assertEquals(100, students.size());
    }

    @Test
    void readStudentsFromJsonNull() {
        JsonReader jsonReader = new JsonReader();
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> jsonReader.readStudentsFromJson("/students_test_data_null.json")
        );
        assertEquals("Error reading json file", exception.getMessage());
    }
}