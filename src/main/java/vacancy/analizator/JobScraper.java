package vacancy.analizator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.Optional;

public class JobScraper {
    private static final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    public static Optional<Job> parseJson(String jsonString) {
        try {
            return Optional.of(mapper.readValue(jsonString, Job.class));
        } catch (JsonProcessingException e) {
            return Optional.empty();
        }
    }
}
