package faang.school.godbless.vacancy_analyzer;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataAnalyzer dataAnalyzer = new DataAnalyzer();
        System.out.println(dataAnalyzer.findTopKRequirements(getJobs(), 2));
        System.out.println(dataAnalyzer.findTopKPopularPositions(getJobs(), 2));
        System.out.println(dataAnalyzer.countJobsBySalaryRange(getJobs(), 50000));
        System.out.println(dataAnalyzer.findTopKLocations(getJobs(), 2));
        System.out.println(dataAnalyzer.analyzeTrends(getJobs(), LocalDateTime.now().minusDays(3), LocalDateTime.now(), TrendGranularity.DAY));
    }

    public static List<Job> getJobs() {
        return List.of(
                new Job("Developer", List.of("Java", "Spring", "SQL"), 140000, "Moscow", LocalDateTime.now().minusDays(3)),
                new Job("Developer", List.of("Java", "Python", "SQL"), 80000, "London", LocalDateTime.now().minusDays(5)),
                new Job("Developer", List.of("Java", "Spring"), 90000, "Moscow", LocalDateTime.now().minusDays(10)),
                new Job("Developer", List.of("Kotlin", "Spring", "SQL"), 170000, "Moscow", LocalDateTime.now().minusDays(1)),
                new Job("Developer", List.of("Docker", "Kubernetes", "SQL"), 30000, "Moscow", LocalDateTime.now().minusDays(2)),
                new Job("Developer", List.of("JUnit", "Spring", "SQL"), 60000, "Moscow", LocalDateTime.now())
        );
    }
}