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
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final JavaTimeModule JAVA_TIME_MODULE = new JavaTimeModule();

    public JsonReader() {
        JAVA_TIME_MODULE.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(FORMATTER));
        OBJECT_MAPPER.registerModule(JAVA_TIME_MODULE);
        OBJECT_MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public <T> List<T> readFile(String fileName, Class<T> convertedClass) {
        try (InputStream inputStream = JsonReader.class.getResourceAsStream(fileName)) {
            return OBJECT_MAPPER.readValue(inputStream, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, convertedClass));
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error reading json file: " + e);
        }
    }
}
