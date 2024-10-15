package school.faang.job.analyzer;

import java.time.LocalDate;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataAnalyzer {
    public static final int SALARY_RANGE_DELTA = 50000;

    public List<String> mostPopularRequirements(List<Job> jobs) {
        return jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )).entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> mostPopularPositions(List<Job> jobs) {
        return jobs.stream()
                .map(Job::getPosition)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )).entrySet().stream()
                .sorted(Map.Entry.<String,Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<Range, List<Job>> groupingBySalaryRange(List<Job> jobs) {
        IntSummaryStatistics statistics = jobs.stream()
                .map(Job::getSalary)
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        int lowerBound = statistics.getMin();
        int upperBound = statistics.getMax();
        Set<Range> salaryRanges = Stream.iterate(lowerBound, salaryBound -> salaryBound < upperBound,
                        salaryBound -> salaryBound + SALARY_RANGE_DELTA)
                .map(salaryBound -> new Range(salaryBound, salaryBound + SALARY_RANGE_DELTA))
                .collect(Collectors.toSet());
        salaryRanges.add(new Range(upperBound));

        return jobs.stream()
                .collect(Collectors.groupingBy(
                        job ->
                                salaryRanges.stream()
                                        .filter(range -> range.inRange(job.getSalary()))
                                        .findFirst()
                                        .orElseThrow(() -> new IllegalArgumentException("отсутствует диапазон для salary" +
                                                job.getSalary()))
                ));
    }

    public List<String> mostPopularLocations(List<Job> jobs) {
        return jobs.stream()
                .map(Job::getLocation)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting())
                ).entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<DateRange, JobStatistic> analyzeTrends(List<Job> jobs, LocalDate startDate,
                                                      LocalDate endDate, Granularity granularity) {
        var dateDeltaFunc = defineDateDelta(granularity);
        Map<DateRange, JobStatistic> trends = new TreeMap<>();
        for (LocalDate date = startDate; !date.isAfter(endDate); date = dateDeltaFunc.apply(date)) {
            LocalDate currEndDate = dateDeltaFunc.apply(date);
            JobStatistic statistic = analyzeTrendsOverRange(jobs, date, currEndDate);
            DateRange dateRange = new DateRange(date, currEndDate, granularity);
            trends.put(dateRange, statistic);
        }
        return trends;
    }

    private Function<LocalDate, LocalDate> defineDateDelta(Granularity granularity) {
        return switch (granularity) {
            case DAILY -> (date) -> date.plusDays(1);
            case WEEKLY -> (date) -> date.plusWeeks(1);
            case MONTHLY -> (date) -> date.plusMonths(1);
        };
    }

    private JobStatistic analyzeTrendsOverRange(List<Job> jobs, LocalDate startDate, LocalDate endDate) {
        List<Job> jobsInDateRange = getJobsInDateRange(jobs, startDate, endDate);
        int numOfJobs = jobsInDateRange.size();
        int numOfRequirements = jobsInDateRange.stream()
                .mapToInt(job -> job.getRequirements().size())
                .sum();
        return new JobStatistic(numOfJobs, numOfRequirements);
    }

    private List<Job> getJobsInDateRange(List<Job> jobs, LocalDate startDate, LocalDate endDate) {
        return jobs.stream()
                .filter(job -> DateRange.isDateInRange(job.getDatePosted(), startDate, endDate))
                .toList();
    }
}
