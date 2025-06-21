package school.faang.vacancy;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
@Slf4j(topic = "Main")
public class Main {

    public static void main(String[] args) throws IOException {
        var path = Paths.get("src/main/resources/vacancies.json");
        List<String> strings = new ArrayList<>();
        var sb = new StringBuilder();
        try (var lines = Files.lines(path)) {
            lines.forEach(line -> {
                if (!(line.startsWith("[") || line.startsWith("]"))) {
                    sb.append(line.trim());
                    if (line.contains("}")) {
                        strings.add(sb.toString());
                        sb.setLength(0);
                    }
                }
            });
        }
        var jobs = JobStreamProcessor.process(strings.stream());

        var top5MostMentionedSkills = DataAnalyzer.getTopMostMentionedSkills(jobs, 5);
        log.info("Top-5 most mentioned skills: {}", top5MostMentionedSkills);

        var top5MostPopularPositions = DataAnalyzer.getTop5MostPopularPositions(jobs);
        log.info("Top-5 most popular positions: {}", top5MostPopularPositions);

        var jobsBySalaryRange = DataAnalyzer.getJobsBySalaryRange(jobs);
        log.info("JOB BY SALARY");
        for (var jobBySalary : jobsBySalaryRange.entrySet()) {
            log.info("{}: {}", jobBySalary.getKey(), jobBySalary.getValue());
        }

        var top5MostPopularOfficeLocations = DataAnalyzer.getTopMostPopularOfficeLocations(jobs, 5);
        log.info("Top-5 most popular office locations: {}", top5MostPopularOfficeLocations);
    }
}
