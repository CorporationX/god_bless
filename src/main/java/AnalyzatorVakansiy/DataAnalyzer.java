package AnalyzatorVakansiy;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataAnalyzer {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public List<String> getTopSkills(List<Job> jobs, int limit) {
        return jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<String> getTopPositions(List<Job> jobs, int limit) {
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Map<String, Long> getSalaryDistribution(List<Job> jobs, int salaryRange) {
        return jobs.stream()
                .collect(Collectors.groupingBy(job -> getSalaryRange(job.getSalary(), salaryRange), Collectors.counting()));
    }

    public List<String> getTopLocations(List<Job> jobs, int limit) {
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private List<Job> jobs;
    public DataAnalyzer(List<Job> jobs) {
        this.jobs = jobs;
    }

    public Map<LocalDate, Long> analyzeTrends(LocalDate startDate, LocalDate endDate, TrendGranularity granularity) {
        Function<Job, LocalDate> dateExtractor = Job::getVacancyDate;

        List<Job> filteredJobs = jobs.stream()
                .filter(job -> isWithinDateRange(job.getVacancyDate(), startDate, endDate))
                .collect(Collectors.toList());

        return getTrendData(filteredJobs, granularity, dateExtractor);
    }

    private boolean isWithinDateRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return !date.isBefore(startDate) && !date.isAfter(endDate);
    }

    private Map<LocalDate, Long> getTrendData(List<Job> jobs, TrendGranularity granularity, Function<Job, LocalDate> dateExtractor) {
        return jobs.stream()
                .collect(Collectors.groupingBy(job -> getTrendDate(dateExtractor.apply(job), granularity), Collectors.counting()));
    }

    public Map<String, Long> getTopSkillsTrends(List<Job> jobs, TrendGranularity granularity, LocalDate startDate, LocalDate endDate) {
        return jobs.stream()
                .filter(job -> isWithinDateRange(job.getVacancyDate(), startDate, endDate))
                .flatMap(job -> job.getRequirements().stream()
                        .map(req -> getTrendDate(job.getVacancyDate(), granularity) + " " + req))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private LocalDate getTrendDate(LocalDate date, TrendGranularity granularity) {
        return granularity.adjustStartDate(date);
    }

    private String getSalaryRange(double salary, int salaryRange) {
        int lowerBound = ((int) salary / salaryRange) * salaryRange;
        int upperBound = lowerBound + salaryRange;
        return String.format("%dk-%dk", lowerBound, upperBound);
    }
}