package faang.school.godbless.job_analyzer;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class JobStreamProcessor {
    private JobScraper<Job> jobScraper;

    public JobStreamProcessor() {
        this.jobScraper = new JobScraper<>(Job.class);
    }

    public List<Job> processJob(Stream<String> jobStream) {
        return jobStream
                .map(jobScraper::parse)
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
    }
}