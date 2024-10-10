package electronic_diary;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public class JsonReader {
    /**
     * Reads a list of students from a json file.
     *
     * @param fileName the path to the json file
     * @return a list of students read from the json file, or null if an error
     * occurs
     */
    public static List<Student> readStudentsFromJson(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = JsonReader.class.getResourceAsStream(fileName)) {
            return objectMapper.readValue(inputStream, objectMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
