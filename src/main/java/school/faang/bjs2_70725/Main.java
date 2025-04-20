package school.faang.bjs2_70725;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class Main {
    private static final JobStreamProcessor jobStreamProcessor = new JobStreamProcessor();

    public static void main(String[] args) {
        try (Stream<String> jsonStream = Files.lines(Paths.get("src/main/resources/vacancies.json"))) {
            List<Job> jobs = jobStreamProcessor.parseJobs(jsonStream);

            log.info("Five most needed skills: {}", DataAnalyzer.findFiveMostNeededSkills(jobs));
            log.info("Five most popular positions: {}", DataAnalyzer.findFiveMostPopularPositions(jobs));
            log.info("Grouped jobs by salary range: {}", DataAnalyzer.groupJobsBySalaryRange(jobs));
            log.info("Five most popular locations: {}", DataAnalyzer.findFiveMostPopularLocations(jobs));
        } catch (IOException e) {
            log.error("Exception {} was thrown", e.getMessage());
        }
    }
}