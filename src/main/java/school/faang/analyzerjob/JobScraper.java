package school.faang.analyzerjob;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
public class JobScraper {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<Job> readJobsFromFile() {
        String filePath = "src/main/resources/vacancies.json";

        try {
            String jsonData = new String(Files.readAllBytes(Paths.get("src/main/resources/vacancies.json")));

            return objectMapper.readValue(jsonData, new TypeReference<List<Job>>() {
            });
        } catch (IOException e) {
            log.error("Failed to read or parse the file: {}", "src/main/resources/vacancies.json", e);
        }

        return List.of();
    }
}
