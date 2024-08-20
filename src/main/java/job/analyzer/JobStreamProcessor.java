package job.analyzer;

import java.util.List;
import java.util.stream.Stream;

public class JobStreamProcessor {

    private final JobScraper jobScraper;

    public JobStreamProcessor(JobScraper jobScraper) {
        this.jobScraper = jobScraper;
    }

    public List<Job> process(Stream<String> jobsStream) {
        return jobsStream
            .map(this.jobScraper::parse)
            .filter((job -> job != null && job.getName() != null))
            .peek(job -> System.out.println("Открыта следующая вакансия: " + job))
            .toList();
    }
}
