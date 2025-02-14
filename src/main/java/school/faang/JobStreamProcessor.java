package school.faang;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.List;

public class JobStreamProcessor {
    private final ObjectMapper objectMapper;

    public JobStreamProcessor() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    public List<Job> processJobs(String json) {
        try {
            return objectMapper.readValue(json, new TypeReference<List<Job>>() {
            });
        } catch (Exception e) {
            System.err.println("Error when parsing JSON list of jobs: " + json);
            e.printStackTrace();
            return List.of();
        }
    }
}
