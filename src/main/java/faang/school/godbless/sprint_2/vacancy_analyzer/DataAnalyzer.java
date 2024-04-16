package faang.school.godbless.sprint_2.vacancy_analyzer;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataAnalyzer {

    private final Comparator<Map.Entry<String, Long>> DESCENDING_COMPARATOR = Map.Entry.comparingByValue(Comparator.reverseOrder());

    public List<String> findTopKRequirements(List<Job> jobs, int k) {
        return jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(DESCENDING_COMPARATOR)
                .limit(k)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> findTopKPopularPositions(List<Job> jobs, int k) {
        return collectJobToMapByCounting(jobs, Job::getPosition)
                .sorted(DESCENDING_COMPARATOR)
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
        return collectJobToMapByCounting(jobs, Job::getLocation)
                .sorted(DESCENDING_COMPARATOR)
                .limit(k)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<Integer, List<Job>> analyzeTrends(List<Job> jobs, LocalDate startDate, LocalDate endDate, TrendGranularity granularity) {
        ChronoField chronoField = switch (granularity) {
            case DAY -> ChronoField.DAY_OF_YEAR;
            case WEEK -> ChronoField.ALIGNED_WEEK_OF_YEAR;
            case MONTH -> ChronoField.MONTH_OF_YEAR;
        };
        return jobs.stream()
                .filter(job -> job.getCreatedAt().isAfter(startDate))
                .filter(job -> job.getCreatedAt().isBefore(endDate))
                .collect(Collectors.groupingBy(job -> job.getCreatedAt().get(chronoField)));
    }

    private Stream<Map.Entry<String, Long>> collectJobToMapByCounting(List<Job> jobs, Function<Job, String> keyFunction) {
        return jobs.stream()
                .collect(Collectors.groupingBy(keyFunction, Collectors.counting()))
                .entrySet()
                .stream();
    }
}