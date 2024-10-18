package school.faang.analyzerjob;

import java.util.List;
import java.util.stream.Collectors;

public class JobStreamProcessor {


    public static List<Job> processJobStream() {
        List<Job> jobs = JobScraper.readJobsFromFile();

        return jobs.stream()
                .peek(job -> System.out.println("Processed job: " + job.getPosition()))
                .collect(Collectors.toList());
    }
}


