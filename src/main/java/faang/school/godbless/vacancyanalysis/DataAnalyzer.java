package faang.school.godbless.vacancyanalysis;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {

    public List<String> getMostPopularSkills(List<Job> jobs) {
        return jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(jobName -> jobName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .limit(5)
                .toList();
    }

    public List<String> getMostPopularJobs(List<Job> jobs) {
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .limit(5)
                .toList();
    }

    public Map<String, Long> getCountJobsInSalaryRange(List<Job> jobs, int range, int bound) {
        return jobs.stream()
                .collect(Collectors.groupingBy(job -> this.getSalaryRange(job, range, bound), Collectors.counting()));
    }

    public List<String> getMostPopularLocations(List<Job> jobs) {
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()))
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .limit(5)
                .toList();
    }

    private String getSalaryRange(Job job, int range, int bound) {
        for (int i = 0; i < bound; i += range) {
            if (job.getSalary() >= i && job.getSalary() <= i + range) {
                return String.format(String.format("%dK-%dK", i / 1000, (i + range) / 1000));
            }
        }
        return "Unidentified";
    }
}
