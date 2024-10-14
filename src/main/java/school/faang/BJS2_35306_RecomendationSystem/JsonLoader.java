package school.faang.BJS2_35306_RecomendationSystem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.AllArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

public class JsonLoader {
    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private ObjectMapper objectMapper;

    public JsonLoader() {
        this.objectMapper = getDefaultObjectMapper();
    }

    public JsonLoader(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addDeserializer(LocalDateTime.class,
                new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT))
        );
        objectMapper.registerModule(javaTimeModule);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return objectMapper;
    }

    public <T> List<T> loadJson(String filePath, Class<T> clazz) {
        try {
            return objectMapper.readValue(
                    new File(filePath),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, clazz)
            );
        } catch (IOException exception) {
            System.out.printf("Error loading JSON from file: %s. Returning empty list.\n", exception.getMessage());
            return Collections.emptyList();
        }
    }
}
