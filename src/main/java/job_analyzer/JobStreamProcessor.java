package job_analyzer;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JobStreamProcessor {
    private final JobScraper jobScraper = new JobScraper();

    /**
     * Processes a stream of strings representing a JSON array of jobs.
     *
     * @param jsonStream stream of strings representing a JSON array of jobs
     * @return a list of {@link Job} objects parsed from the JSON array
     * @throws JsonProcessingException if the JSON array is malformed
     */
    public List<Job> processJobs(Stream<String> jsonStream) throws JsonProcessingException {
        String json = jsonStream.collect(Collectors.joining("\n")).trim();

        return jobScraper.parseJobs(json);
    }
}
