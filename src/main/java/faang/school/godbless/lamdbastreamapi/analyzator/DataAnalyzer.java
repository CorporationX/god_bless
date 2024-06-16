package faang.school.godbless.lamdbastreamapi.analyzator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {

    public static List<String> getTopSkills(List<Job> jobs, int limitTop) {
        Map<String, Long> jobCount = jobs.stream()
                .flatMap(job -> {
                    return job.requirements().stream();
                })
                .collect(Collectors.groupingBy(requirement -> requirement, Collectors.counting()));

        return jobCount.entrySet().stream()
                .sorted((job1, job2) -> job2.getValue().compareTo(job1.getValue()))
                .limit(limitTop)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getTopPosition(List<Job> jobs, int limitTop) {

    }

    public static Map<String, Integer> getDistributionOfSalaries(List<Job> jobs) {

    }

    public static List<String> getTopLocations() {

    }

    // как доп задание, реализовать метод
    //public static analyzeTrends(LocalDate startDate, LocalDate endDate, TrendGranularity granularity)
}
