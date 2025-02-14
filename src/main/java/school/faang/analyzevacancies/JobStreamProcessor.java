package school.faang.analyzevacancies;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@Slf4j
public class JobStreamProcessor {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public void processingVacancies() {
        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("students_data.json")) {
            if (inputStream == null) {
                throw new FileNotFoundException("File not found!");
            }

            List<Job> students = MAPPER.readValue(inputStream, new TypeReference<>() {});

        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
        }
    }
}
