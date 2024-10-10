package electronic_diary;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonReaderTest {
    @Test
    void readStudentsFromJson() {
        List<Student> students = JsonReader.readStudentsFromJson("/students_test_data.json");
        assert students != null;
        assertEquals(100, students.size());
    }
}