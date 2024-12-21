package school.faang.bjs247244;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JobStreamProcessor {
    private JobScraper jobScraper = new JobScraper();

    public List<Job> getProcessJobs(Stream<String> jsonStream) {

        List<Job> processJobs = jsonStream
                .map(jobScraper::parseJob)
                .peek(job -> System.out.println("Обработана вакансия: " + job.getPosition()))
                .collect(Collectors.toList());
        return processJobs;
    }
}
