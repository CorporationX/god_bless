package school.faang.analyzevacancies;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class JobStreamProcessor {
    private static final List<Job> JOBS = new ArrayList<>();
    private static final JsonFactory JSON_FACTORY = new JsonFactory();
    private static final JobScraper SCRAPER = new JobScraper();

    public List<Job> processingVacancies(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            throw new FileNotFoundException("File not found!");
        }

        JsonParser jsonParser = JSON_FACTORY.createParser(inputStream);

        if (jsonParser.nextToken() != JsonToken.START_ARRAY) {
            throw new IllegalStateException("Expected content to be an array");
        }
        while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
            Job job = SCRAPER.parsingVacancy(jsonParser);
            JOBS.add(job);
            log.info("Processed job: {}", job);
        }
        return JOBS;
    }
}
