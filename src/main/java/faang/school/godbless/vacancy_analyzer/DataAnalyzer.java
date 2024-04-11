package faang.school.godbless.vacancy_analyzer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataAnalyzer {

    public List<String> findTopKRequirements(List<Job> jobs, int k) {
        return jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .limit(k)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> findTopKPopularPositions(List<Job> jobs, int k) {
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getPosition, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .limit(k)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, Long> countJobsBySalaryRange(List<Job> jobs, int salaryStep) {
        return jobs.stream()
                .collect(Collectors.groupingBy(job ->
                        (job.getSalary() / salaryStep) * salaryStep + "-" + (job.getSalary() / salaryStep + 1) * salaryStep,
                        Collectors.counting()
                ));
    }

    public List<String> findTopKLocations(List<Job> jobs, int k) {
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .limit(k)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<Integer, List<Job>> analyzeTrends(List<Job> jobs, LocalDateTime startDate, LocalDateTime endDate, TrendGranularity granularity) {
        ChronoField chronoField = switch (granularity) {
            case DAY -> ChronoField.DAY_OF_YEAR;
            case WEEK -> ChronoField.ALIGNED_WEEK_OF_YEAR;
            case MONTH -> ChronoField.MONTH_OF_YEAR;
        };
        return jobs.stream()
                .collect(Collectors.groupingBy(job -> job.getCreatedAt().get(chronoField)));
    }
}