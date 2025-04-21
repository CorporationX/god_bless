package school.faang.bjs2_70725;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class JobStreamProcessor {
    public List<Job> parseJobs(Stream<String> jobsStream) {
        String jsonString = jobsStream
                .collect(Collectors.joining(""));
        return JobScraper.parseJson(jsonString);
    }
}