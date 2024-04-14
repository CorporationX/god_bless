package faang.school.godbless.bjs2_5223;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JobScraperJsonImpl implements JobScraper{

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Job convertToJob(String jsonObject) {
        try {
            objectMapper.registerModule(new JavaTimeModule());
            return objectMapper.readValue(jsonObject, Job.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
