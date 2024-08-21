package faang.school.godbless.bjs2_22762;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JobScraperJson extends JobScraper {
    ObjectMapper mapper;

    public JobScraperJson() {
        mapper = new ObjectMapper();
    }

    public Job parse(String json) {
        Job job = null;
        try {
            job = mapper.readValue(json, Job.class);
        } catch (JsonProcessingException e) {
            System.err.println("Error parsing JSON: " + e.getMessage());
        }
        return job;
    }
}
