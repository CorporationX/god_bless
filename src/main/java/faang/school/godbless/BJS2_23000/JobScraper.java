package faang.school.godbless.BJS2_23000;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.Optional;

public class JobScraper {

    private static ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public static Optional<Job> parseJsonToJob(String json) {
        try {
            Job job = mapper.readValue(json, mapper.getTypeFactory().constructType(Job.class));
            return Optional.ofNullable(job);
        } catch (JsonProcessingException e) {
            System.out.println("JsonProcessingException: " + e.getMessage());
            return Optional.empty();
        }
    }
}
