package faang.school.godbless.vacancy_analyzer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JobStreamProcessor {
    public List<Job> processJobStream(Stream<String> jobStream) {
        return jobStream.map(JobScraper::parseJsonToJob)
                .peek(job -> System.out.println("Уведомление о вакансии: " + job.getPosition()))
                .collect(Collectors.toList());
    }
}
