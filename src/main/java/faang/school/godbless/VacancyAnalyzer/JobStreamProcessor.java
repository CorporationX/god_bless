package faang.school.godbless.VacancyAnalyzer;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class JobStreamProcessor {
    private final JobScraper scraper = new JobScraper();

    public List<Job> parseStream(Stream<String> json) {
        return json
                .map(scraper::parse)
                .filter(Objects::nonNull)
                .peek(job -> System.out.println("Вакансия " + job.getName() + " - успешно обработана"))
                .toList();
    }
}
