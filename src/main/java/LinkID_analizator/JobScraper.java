package LinkID_analizator;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.stream.Stream;

public abstract class JobScraper {

    public abstract Stream<Job> parseJobs(String source);


    public Job fromJson(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, Job.class);
        } catch (IOException e) {
            System.err.println("Ошибка при преобразовании JSON в объект Job: " + e.getMessage());
            return null;
        }
    }
}


