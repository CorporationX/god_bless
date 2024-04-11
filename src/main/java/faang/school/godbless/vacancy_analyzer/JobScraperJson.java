package faang.school.godbless.vacancy_analyzer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JobScraperJson extends JobScraper{
    @Override
    public Job readValue(String data) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(data, Job.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}