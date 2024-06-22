package faang.school.godbless.vacancyAnalyzator;

import java.util.List;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class JobStreamProcessor {

  public List<Job> convertStreamToJobList(Stream<String> data) {
    return data.map(JobScraper::parseVacancyJsonToJob)
        .peek((job) -> log.info("Parsed: " + job))
        .toList();
  }
}
