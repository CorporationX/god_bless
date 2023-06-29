package faang.school.godbless.VacancyAnalysing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JobScraper {
    private final ObjectMapper objectMapper;

    public JobScraper() {
        this.objectMapper = new ObjectMapper();
    }

    public ArrayList<Job> transformJsonToJob(File json) {
        try {
            return objectMapper.readValue(json, new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
