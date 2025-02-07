package school.faang.BJS2_56994.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

public class JsonLoader {

    public static List<BookData> loadBooks(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            InputStream inputStream = JsonLoader.class.getClassLoader().getResourceAsStream(filePath);
            if (inputStream == null) {
                throw new RuntimeException("Error loading books from JSON: File not found -> " + filePath);
            }

            return objectMapper.readValue(inputStream, new TypeReference<List<BookData>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Error loading books from JSON", e);
        }
    }
}
