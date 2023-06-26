package faang.school.godbless.vacancy_analyzer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JobStreamProcessor {
    private JobScraper jobScraper;

    public JobStreamProcessor(){
        this.jobScraper = new JobScraper();
    }

    public List<Job> processJobStream(Stream<String> jobsToProcess) {
        return jobsToProcess.map(jobScraper::parseJsonToJob)
                .peek(this::sendNotification)
                .collect(Collectors.toList());
    }

    private void sendNotification(Job job) {
        System.out.println("A new job processed:  " + job.getPosition());
    }

}
