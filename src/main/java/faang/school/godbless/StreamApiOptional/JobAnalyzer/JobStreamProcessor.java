package faang.school.godbless.StreamApiOptional.JobAnalyzer;

import java.util.List;
import java.util.stream.Stream;

public class JobStreamProcessor {
    public static List<Job> getListOfJobs(Stream<String> strings){
        return strings.map(JobScraper::convertJSONtoNewJobObject).toList();
    }
}
