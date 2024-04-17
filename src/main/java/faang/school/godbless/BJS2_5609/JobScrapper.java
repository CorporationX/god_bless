package faang.school.godbless.BJS2_5609;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JobScrapper {
    public Job fromJsonToJobObject(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, Job.class);
    }
}
