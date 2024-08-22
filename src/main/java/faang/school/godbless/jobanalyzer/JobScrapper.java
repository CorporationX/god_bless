package faang.school.godbless.jobanalyzer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public class JobScrapper {
    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    public Job parseJsonToJob(String json) {
        try {
            return mapper.readValue(json, Job.class);
        } catch (IOException e) {
            System.err.println("Error parsing JSON: " + e.getMessage());
        }
        return null;
    }
}