package school.faang.job.analyzer;

import java.util.List;

public class JobStreamProcessor {
    public static List<Job> convertToJobs(List<String> jobStrings) {
        return jobStrings.stream()
                .map(JobScraper::parseToJob)
                .peek(System.out::println)
                .toList();
    }
}
