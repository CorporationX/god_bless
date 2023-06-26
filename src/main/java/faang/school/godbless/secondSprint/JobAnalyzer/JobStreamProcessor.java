package faang.school.godbless.secondSprint.JobAnalyzer;

import java.util.List;
import java.util.stream.Stream;

public class JobStreamProcessor {
    public static List<Job> convertJsonToJob(Stream<String> jsonStream) {
        return jsonStream.map(JobScraper::transformJsonToJob)
                .peek(job -> System.out.println("Вакансия " + job.position() + " преобразована"))
                .toList();
    }
}
