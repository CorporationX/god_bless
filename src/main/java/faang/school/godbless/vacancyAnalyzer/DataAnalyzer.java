package faang.school.godbless.vacancyAnalyzer;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataAnalyzer {
    private final Comparator<Map.Entry<String, Long>> descendingComparator = Map.Entry.comparingByValue(Comparator.reverseOrder());

    public List<String> findTopXRequirements(List<Job> jobs, int x) {
        return jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(descendingComparator)
                .limit(x)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> findTopXPopularPositions(List<Job> jobs, int x) {
        return collectJobToMapByCounting(jobs, Job::getPosition)
                .sorted(descendingComparator)
                .limit(x)
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

    public List<String> findTopXLocations(List<Job> jobs, int x) {
        return collectJobToMapByCounting(jobs, Job::getLocation)
                .sorted(descendingComparator)
                .limit(x)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<Integer, List<Job>> analyzeTrends(List<Job> jobs, LocalDate startDate, LocalDate endDate, TrendGranularity granularity) {
        ChronoField chronoField = ChronoField.valueOf(String.valueOf(granularity));
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
