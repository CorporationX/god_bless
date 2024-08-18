package faang.school.godbless.BJS2_22852;

import java.util.List;
import java.util.stream.Stream;

public class JobStreamProcessor {
    public List<Job> getJobs(Stream<String> json) {
        JobScraper jobScraper = new JobScraper();
        return json.map(jobScraper::convertToJob)
                .peek(System.out::println)
                .toList();
    }
}
