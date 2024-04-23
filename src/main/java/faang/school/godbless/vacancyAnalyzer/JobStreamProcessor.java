package faang.school.godbless.vacancyAnalyzer;

import java.util.List;
import java.util.stream.Stream;

public class JobStreamProcessor {
    public List<Job> streamToJobs(Stream<String> jobsStream){
        JobScraper jobScraper = new JobScraper();
        return jobsStream.map(jobScraper::createJob).peek(System.out::println).toList();
    }
}
