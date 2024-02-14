package AnalyzatorVakansiy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JobStreamProcessor {
    private final JobScraper jobScraper;

    public JobStreamProcessor(JobScraper jobScraper) {
        this.jobScraper = jobScraper;
    }

    public List<Job> processJobs(Stream<String> jobStream) {
        return jobStream
                .map(jobScraper::parseJson)
                .filter(job -> job != null)  // нам не нужны пустышки
                .peek(job -> System.out.println("Job added: " + job))
                .collect(Collectors.toList());
    }
}
