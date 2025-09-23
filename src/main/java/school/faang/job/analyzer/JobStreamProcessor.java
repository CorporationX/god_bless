package school.faang.job.analyzer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class JobStreamProcessor {

    public List<Job> parseFromJson(Stream<String> jobsNode) {
        JobScraper jobScraper = new JobScraper();
        return jobsNode
                .map(jobScraper::parseJonFromJson)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
