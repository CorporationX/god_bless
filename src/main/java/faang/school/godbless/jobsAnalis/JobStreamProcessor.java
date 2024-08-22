package faang.school.godbless.jobsAnalis;

import java.util.List;
import java.util.stream.Stream;

public class JobStreamProcessor {
    public static List<Job> process(Stream<String> stream) {
        return stream.map(JobScraper::parceJob)
                .toList();
    }
}
