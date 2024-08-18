package vacancy.analizator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

public class JobScraper {
    public static Optional<Job> parseJson(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<Job> job = Optional.empty();
        try {
            job = Optional.of(mapper.readValue(jsonString, Job.class));
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }

        return job;
    }
}
