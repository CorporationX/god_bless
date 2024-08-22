package faang.school.godbless.AnalysisVacantion;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDateTime;

class JobScraper {
    ObjectMapper mapper = new ObjectMapper();
    public Job parseJson(String json) {
        mapper.registerModule(new JavaTimeModule());
        Job job = null;
        try {
            job = mapper.readValue(json, Job.class);
        } catch (JsonProcessingException e) {
            System.out.println("json бракованный :(");
            throw new RuntimeException(e);
        }
        job.setAddDate(LocalDateTime.now());
        return job;
    }
}
