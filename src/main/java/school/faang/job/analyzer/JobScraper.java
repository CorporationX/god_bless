package school.faang.job.analyzer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.Optional;

public class JobScraper {

    private final ObjectMapper objectMapper;

    public JobScraper() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    public Optional<Job> parseJonFromJson(String jobNode) {
        try {
            return Optional.ofNullable(objectMapper
                    .readValue(jobNode.getBytes(), Job.class));
        } catch (Exception e) {
            System.out.println("Json parse error " + e.getMessage());
        }
        return Optional.empty();
    }
}
