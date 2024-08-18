package faang.school.godbless.jobsAnalis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JobScraper {
    public static Job parceJob(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        Job job;

        try {
            job = objectMapper.readValue(json, Job.class);

            System.out.println("Вакансия " + job.getTitle() + " получена из JSON");
        } catch (JsonMappingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return job;
    }

    public static String toString(Job job) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(job);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
