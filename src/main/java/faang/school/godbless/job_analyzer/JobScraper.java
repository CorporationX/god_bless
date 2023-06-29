package faang.school.godbless.job_analyzer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JobScraper {

    public Job parseJobFromJsonString(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(jsonString, Job.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
