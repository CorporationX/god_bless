package faang.school.godbless.task.stream.api.job.analizer;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataAnalyzer {
    private static final int MOST_POPULAR_SKILLS_LIMIT = 5;
    private static final int MOST_POPULAR_POSITION_LIMIT = 5;
    private static final int MOST_POPULAR_LOCATION_LIMIT = 5;

    public List<String> mostPopularSkills(List<Job> jobs) {
        return jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(Map.Entry<String, Long>::getValue).reversed())
                .limit(MOST_POPULAR_SKILLS_LIMIT)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> mostPopularPositions(List<Job> jobs) {
        return jobs.stream()
                .map(Job::getPosition)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(Map.Entry<String, Long>::getValue).reversed())
                .limit(MOST_POPULAR_POSITION_LIMIT)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<Double, Long> analysisSalaryDistribution(List<Job> jobs, double diapasonStep) {
        return jobs.stream()
                .collect(Collectors.groupingBy(
                        job -> Math.round(job.getSalary() / diapasonStep) * diapasonStep,
                        Collectors.counting()));
    }

    public List<String> mostPopularLocation(List<Job> jobs) {
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(Map.Entry<String, Long>::getValue).reversed())
                .limit(MOST_POPULAR_LOCATION_LIMIT)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, Long> analyzeTrends(List<Job> jobs, LocalDate startDate, LocalDate endDate,
                                           TrendGranularity granularity) {
        return jobs.stream()
                .filter(job -> job.getDateOfCreation().toLocalDate().isAfter(startDate) &&
                        job.getDateOfCreation().toLocalDate().isBefore(endDate))
                .collect(Collectors.groupingBy(job -> granularity.get(job), Collectors.counting()));
    }
}
