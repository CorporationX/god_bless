package job_analyzer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JobScraper {
    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Parses a JSON string representing a list of jobs into a List of Job objects.
     *
     * @param json The JSON string to parse.
     * @return A List of Job objects.
     * @throws JsonProcessingException If the JSON string is invalid.
     */
    public List<Job> parseJobs(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, new TypeReference<>() {});
    }
}
