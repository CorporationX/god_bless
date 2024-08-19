package faang.school.godbless.vacancy.analyzer;

import java.util.List;
import java.util.stream.Stream;

public class JobStreamProcessor {
    public static List<Job> parse(Stream<String> stream) {
        return stream.map(JobScraper::parse).toList();
    }
}
