package faang.school.godbless.secondSprint.JobAnalyzer;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.stream.Stream;

public class JobStreamProcessor {
    public static List<Job> convertJsonToJob(Stream<String> jsonStream) {
        return jsonStream.map(json -> {
                    try {
                        return JobScraper.transformJsonToJob(json);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                }).peek(job -> System.out.println("Вакансия " + job.position() + " преобразована"))
                .toList();
    }
}
