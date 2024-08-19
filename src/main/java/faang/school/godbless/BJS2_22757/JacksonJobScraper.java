package faang.school.godbless.BJS2_22757;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JacksonJobScraper implements JobScraper {
    private final ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();

    @Override
    public Job convert(String json) {
        try {
            return mapper.readValue(json, Job.class);
        } catch (IOException e) {
            throw new RuntimeException("Error converting json to an object");
        }
    }

    public static void main(String[] args) throws IOException {
        JacksonJobScraper scraper = new JacksonJobScraper();
        Job job = scraper.mapper.readValue("{\"jobName\": \"Software Engineer\", \"salary\": 150000, \"location\": \"Moscow\", \"postingDate\": \"2024-08-01\", \"skills\": [\"Python\", \"Django\", \"REST API\"]}", Job.class);
        System.out.println(job);
    }
}
