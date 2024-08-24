package streamapi.four;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@AllArgsConstructor
public class JobStreamProcessor {

    private final JobScraper jobScraper;

    public List<Job> processJobStream(Stream<String> jobStream) {
        return jobStream
                .map(jobScraper::parse)
                .peek(job -> System.out.println("Спарсили вакансию: " + job))
                .collect(Collectors.toList());
    }
}
