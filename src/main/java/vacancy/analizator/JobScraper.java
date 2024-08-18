package vacancy.analizator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.Optional;

public class JobScraper {
    public static Optional<Job> parseJson(String jsonString) {
        ObjectMapper mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());
        Optional<Job> job = Optional.empty();
        try {
            job = Optional.of(mapper.readValue(jsonString, Job.class));
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }

        return job;
    }
}
