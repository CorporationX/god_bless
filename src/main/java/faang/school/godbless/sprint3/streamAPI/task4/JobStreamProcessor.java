package faang.school.godbless.sprint3.streamAPI.task4;

import java.util.List;
import java.util.stream.Collectors;

public class JobStreamProcessor {

    private final JobScraper jobScraper;

    public JobStreamProcessor() {
        this.jobScraper = new JobScraper();
    }

    public List<Job> transformJsonsToJobs(List<String> jsons) {
        return jsons.stream()
                .map(jobScraper::transformJsonToJob)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }
}
