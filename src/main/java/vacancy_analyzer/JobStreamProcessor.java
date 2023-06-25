package vacancy_analyzer;

import java.util.List;

public class JobStreamProcessor {
    private final JobScraper jobScraper;

    public JobStreamProcessor() {
        this.jobScraper = new JobScraper();
    }

    public List<Job> transformJsonsToJobs(List<String> jsons) {
        return jsons.stream()
                .map(jobScraper::transformJsonToJob)
                .peek(System.out::println)
                .toList();
    }
}
