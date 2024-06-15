package faang.school.godbless.stream.jobs;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public record DataAnalyzer() {

    public List<String> listTop5InDemandSkills(List<Job> jobs) {
        return jobs.stream()
                .flatMap(job -> job.reqs().stream())
                .collect(Collectors.groupingBy(req -> req, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> listTop5JobTitles(List<Job> jobs) {
        return findTop5ByCriteria(jobs, Job::title);
    }

    public SalaryRangeInfo categorizeBySalaryRange(List<Job> jobs) {
        var result = new SalaryRangeInfo();
        jobs.stream()
                .map(Job::offeredSalary)
                .forEach(result::appendStatistics);
        return result;
    }

    public List<String> listTop5Locations(List<Job> jobs) {
        return findTop5ByCriteria(jobs, Job::location);
    }

    public void analyzeTrends(LocalDate startDate, LocalDate endDate, TrendGranularity trendGranularity) {
        
    }

    private static List<String> findTop5ByCriteria(List<Job> jobs, Function<Job, String> criteria) {
        return jobs.stream()
                .collect(Collectors.groupingBy(criteria, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }
}
