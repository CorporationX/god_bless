package school.faang.sprint_2.task_47167;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JobStreamProcessor {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Job> processJobStream(InputStream jobStream) throws IOException {
        List<Job> jobs = objectMapper.readValue(jobStream, new TypeReference<>() {
        });

        for (Job job : jobs) {
            System.out.println("Добавлена вакансия: " + job);
        }
        return jobs;
    }
}
