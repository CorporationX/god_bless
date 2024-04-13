package faang.school.godbless.jobanalyzer;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JobScarper {

    private ObjectMapper mapper = new ObjectMapper();

    public Job parseVacancy(String json) {
        try {
            return mapper.readValue(json, Job.class);
        } catch (IOException e) {
            return null;
        }
    }
}
