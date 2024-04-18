package faang.school.godbless.VacancyAnalyzer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataAnalyzer {
    public List<String> getMostPopularSkills(List<Job> jobs, int limit) {
        return jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> getMostPopularNames(List<Job> jobs, int limit) {
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> getMostPopularOfficeLocations(List<Job> jobs, int limit) {
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, List<Job>> getSalaryIntervalsWithJobs(List<Job> jobs, Set<SalaryRange> salaryRanges) {
        return jobs.stream()
                .collect(Collectors.groupingBy(job -> salaryRanges.stream()
                                .filter(range -> range.getHigher() >= job.getSalary() && range.getLower() < job.getSalary())
                                .map(SalaryRange::getName)
                                .findAny()
                                .orElse("Out of ranges")
                        , Collectors.toList()));
    }

    public Map<String, List<Job>> analyzeTrends(List<Job> jobs, LocalDate startDate, LocalDate endDate, TrendGranularity granularity) {
          return jobs.stream()
                .filter(job -> job.getDateAdded().isAfter(startDate.atStartOfDay()) && job.getDateAdded().isBefore(endDate.atStartOfDay()))
                .collect(Collectors.groupingBy(job -> switch (granularity) {
                    case MONTH -> job.getDateAdded().format(DateTimeFormatter.ofPattern("MM.yyyy"));
                    case YEAR -> job.getDateAdded().format(DateTimeFormatter.ofPattern("yyyy"));
                    case DAY -> job.getDateAdded().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                }, Collectors.toList()));
    }
}
