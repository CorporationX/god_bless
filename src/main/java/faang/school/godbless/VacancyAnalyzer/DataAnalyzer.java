package faang.school.godbless.VacancyAnalyzer;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataAnalyzer {
    private final List<Job> jobs;

    public DataAnalyzer(Stream<String> json) {
        JobStreamProcessor processor = new JobStreamProcessor();
        jobs = processor.parseStream(json);
    }

    public List<String> getMostPopularSkills(int limit) {
        return jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> getMostPopularNames(int limit) {
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> getMostPopularOfficeLocations(int limit) {
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, List<Job>> getSalaryIntervalsWithJobs() {
        return jobs.stream()
                .collect(Collectors.groupingBy(job -> switch ((int) Math.ceil(job.getSalary() / 10000.0)) {
                    case 0,1,2,3,4,5 -> "0 - 50.000";
                    case 6,7,8,9,10 -> "50.000 - 100.000";
                    case 11,12,13,14,15 -> "100.000 - 150.000";
                    default -> "150.000 and more";
                }, Collectors.toList()));
    }

    public Map<String, List<Job>> analyzeTrends(LocalDate startDate, LocalDate endDate, TrendGranularity granularity) {
          return jobs.stream()
                .filter(job -> job.getDateAdded().isAfter(startDate.atStartOfDay()) && job.getDateAdded().isBefore(endDate.atStartOfDay()))
                .collect(Collectors.groupingBy(job -> switch (granularity) {
                    case MONTH -> job.getDateAdded().getMonth().toString();
                    case WEEK -> job.getDateAdded().getMonth().toString() + " " + job.getDateAdded().getDayOfMonth() + " " + job.getDateAdded().getDayOfWeek().toString();
                    case DAY -> job.getDateAdded().getMonth().toString() + " " + job.getDateAdded().getDayOfWeek().toString();
                }, Collectors.toList()));
    }
}
