package faang.school.godbless.BJS2_22852;

import java.util.List;
import java.util.stream.Stream;

public class JobStreamProcessor {

    private final JobScraper jobScraper = new JobScraper();

    public List<Job> getJobs(Stream<String> json) {
        return json.map(jobScraper::convertToJob)
                .peek(System.out::println)
                .toList();
    }
}
