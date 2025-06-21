package school.faang.vacancy;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DataAnalyzer {

    public static List<String> getTopMostMentionedSkills(@NonNull Set<Job> jobs, int topNumber) {
        return jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .limit(topNumber)
                .toList();
    }

    public static List<String> getTop5MostPopularPositions(@NonNull Set<Job> jobs) {
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getPosition, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .limit(5)
                .toList();
    }

    public static Map<String, List<Job>> getJobsBySalaryRange(@NonNull Set<Job> jobs) {
        final var thousands = 1000;
        final var salaryStep = 50000;
        return jobs.stream()
                .collect(Collectors.groupingBy(job -> {
                    var start = (int) (job.getSalary() / salaryStep) * salaryStep;
                    var end = start + salaryStep;
                    return "%s-%sk".formatted(start / thousands, end / thousands);
                }))
                .entrySet().stream()
                .sorted(Map.Entry.<String, List<Job>>comparingByKey().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    public static List<String> getTopMostPopularOfficeLocations(@NonNull Set<Job> jobs, int topNumber) {
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .limit(topNumber)
                .toList();
    }
}
