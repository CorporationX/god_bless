package faang.school.godbless.task.jobAnalyzer;

import java.util.List;

public class JobStreamProcessor {
    public List<Job> transformJsonsToJobs(List<String> jsons) {
        return jsons.stream()
                .map(JobScraper::convertJsonToJob)
                .peek(System.out::println)
                .toList();
    }
}
