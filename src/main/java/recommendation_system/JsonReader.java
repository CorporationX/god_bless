package recommendation_system;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class JsonReader {
    public <T> List<T> readFile(String fileName, Class<T> convertedClass) {
        ObjectMapper objectMapper = new ObjectMapper();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(formatter));

        objectMapper.registerModule(javaTimeModule);

        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        try (InputStream inputStream = JsonReader.class.getResourceAsStream(fileName)) {
            return objectMapper.readValue(inputStream, objectMapper.getTypeFactory().constructCollectionType(List.class, convertedClass));
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error reading json file");
        }
    }
}
