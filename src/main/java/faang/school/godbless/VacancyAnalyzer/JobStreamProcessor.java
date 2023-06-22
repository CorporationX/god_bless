package faang.school.godbless.VacancyAnalyzer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JobStreamProcessor {
    public static List<Job> process(Stream<String> stream) {
        return stream.map(string -> {
            Job job = JobScraper.jsonToJob(string);
            System.out.println(job);
            return job;
        }).collect(Collectors.toList());
    }
}
