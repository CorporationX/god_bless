package faang.school.godbless.jobanalyzer;

import java.util.List;
import java.util.stream.Stream;

public class JobStreamProcessor {
    public static List<Job> convertToListOfJobs(Stream<String> strings) {
        return strings.map(JobScraper::convertJSONStringToJob).toList();
    }
}
