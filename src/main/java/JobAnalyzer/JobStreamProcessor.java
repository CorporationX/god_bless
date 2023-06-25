package JobAnalyzer;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.stream.Stream;

public class JobStreamProcessor {
    public static List<Job> parseJsonToJob(Stream<String> jsonStream) {
        return jsonStream.map(json -> {
                    try {
                        return JobScrapper.scrappJsonToJob(json);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                }).peek(job -> System.out.println("Предложение о вакансии " + job.vocation() + " разобрано"))
                .toList();
    }
}
