package school.faang;

import java.util.List;
import java.util.stream.Stream;

public class JobStreamProcessor {
    private final JobScraper jobScraper = new JobScraper();

    public List<Job> processJobs(Stream<String> jsonStream) {
        return jsonStream
                .map(jobScraper::parseJob)
                .peek(job -> System.out.println("Обработана вакансия: " + job.getPosition())) // Уведомление
                .toList();
    }
}