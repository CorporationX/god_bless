package school.faang.bjs247244;

import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JobStreamProcessor {
    private final JobScraper jobScraper;

    public JobStreamProcessor() {
        this.jobScraper = new JobScraper();
    }

    public List<Job> getProcessJobs(@NonNull Stream<String> jsonStream) {
        return jsonStream
                .map(jobScraper::parseJob)
                .peek(job -> System.out.println("Обработана вакансия: " + job.getPosition()))
                .collect(Collectors.toList());
    }
}
