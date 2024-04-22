package faang.school.godbless.jobanalyzer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public class JobScarper {

    private ObjectMapper mapper;

    public JobScarper() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    public Job parseVacancy(String json) {
        try {
            return mapper.readValue(json, Job.class);
        } catch (IOException e) {
            return null;
        }
    }
}
