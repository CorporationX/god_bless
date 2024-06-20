package faang.school.godbless.job_alalyzer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class JobStreamProcessor {
    public List<Job> parseStreamOfJson(Stream<String> jsonStream) {
        return jsonStream
                .map(JobScraper::convertJsonIntoJob)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
