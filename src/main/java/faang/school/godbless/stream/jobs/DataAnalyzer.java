package faang.school.godbless.stream.jobs;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public record DataAnalyzer() {

    public List<String> listTopFiveInDemandSkills(List<Job> jobs) {
        return jobs.stream()
                .flatMap(job -> job.reqs().stream())
                .collect(Collectors.groupingBy(req -> req, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> listTopFiveJobTitles(List<Job> jobs) {
        return findTopFiveByCriteria(jobs, Job::title);
    }

    public SalaryRangeInfo categorizeBySalaryRange(List<Job> jobs) {
        var result = new SalaryRangeInfo();
        jobs.stream()
                .map(Job::offeredSalary)
                .forEach(result::appendStatistics);
        return result;
    }

    public List<String> listTopFiveLocations(List<Job> jobs) {
        return findTopFiveByCriteria(jobs, Job::location);
    }

    private static List<String> findTopFiveByCriteria(List<Job> jobs, Function<Job, String> criteria) {
        return jobs.stream()
                .collect(Collectors.groupingBy(criteria, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }
}
