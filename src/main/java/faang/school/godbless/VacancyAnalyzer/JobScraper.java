package faang.school.godbless.VacancyAnalyzer;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JobScraper {
    private final ObjectMapper mapper = new ObjectMapper();

    public Job parse(String json) {
        try {
            return mapper.readValue(json, Job.class);
        } catch (IOException e) {
            return null;
        }
    }
}
