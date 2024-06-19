package faang.school.godbless.lamdbastreamapi.analyzator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JobScraper {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Job parseJsonToJob(String jsonString) throws JsonProcessingException {
         return objectMapper.readValue(jsonString, Job.class);
    }
}
