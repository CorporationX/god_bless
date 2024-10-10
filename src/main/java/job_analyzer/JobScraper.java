package job_analyzer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JobScraper {
    private ObjectMapper objectMapper = new ObjectMapper();

    public List<Job> parseJobs(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, new TypeReference<>() {});
    }
}
