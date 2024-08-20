package faang.school.godbless.task.stream.api.job.analizer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.Optional;

public class JobScraper {
    private final ObjectMapper objectMapper;

    {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    public Optional<Job> parse(String json) {
        try {
            return Optional.ofNullable(objectMapper.readValue(json, Job.class));
        } catch (Exception exception) {
            System.out.println("Json parsing error: " + exception.getMessage());
            return Optional.ofNullable(null);
        }
    }
}
