package faang.school.godbless.task_4_analizator.scrappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import faang.school.godbless.task_4_analizator.models.Job;

public class JsonJobScrapper implements JobScrapper{
    @Override
    public Job parse(String json) {
        if(json == null || json.isBlank()){
            throw new IllegalArgumentException("incorrect data");
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        Job job = null;

        try {
            job = mapper.readValue(json, Job.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return job;
    }
}
