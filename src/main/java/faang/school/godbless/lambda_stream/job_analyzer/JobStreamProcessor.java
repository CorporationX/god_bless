package faang.school.godbless.lambda_stream.job_analyzer;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class JobStreamProcessor {
    private JobScraper jobScraper;

    public JobStreamProcessor() {
        this.jobScraper = new JobScraper();
    }

    public List<Job> processJob(File json) {
        return jobScraper.parse(json).stream()
                .filter(Objects::nonNull)
                .peek(this::sendNotification)
                .toList();
    }

    private void sendNotification(Job job) {
        System.out.println("New job:");
        System.out.printf("\tPosition: %s", job.getPosition());
        System.out.printf("\tSkills: %s", job.getSkills());
        System.out.printf("\tSalary: %s", job.getSalary());
        System.out.printf("\tLocation: %s", job.getLocation());
        System.out.printf("\tDate: %s", job.getDate());
        System.out.println();
    }
}