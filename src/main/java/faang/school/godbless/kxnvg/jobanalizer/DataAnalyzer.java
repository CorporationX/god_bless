package faang.school.godbless.kxnvg.jobanalizer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {

    public List<String> getMostPopularSkills(List<Job> jobs, int limit) {
        return jobs.stream()
                .flatMap(job -> job.getCandidatesRequirements().stream())
                        .collect(Collectors.groupingBy(requirement -> requirement, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((x1, x2) -> (int) (x2.getValue() - x1.getValue()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<Job> getMostPopularJob(List<Job> jobs, int limit) {
        return jobs.stream()
                .collect(Collectors.groupingBy(name -> name, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((x1, x2) -> (int) (x2.getValue() - x1.getValue()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, Long> getSalaryByJobs(List<Job> jobs) {
        return jobs.stream()
                .collect(Collectors.groupingBy(job -> Math.ceil(job.getSalary() / 50000), Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(entry ->
                                "От " + (int) (entry.getKey() * 50000 - 50000) + " до " + (int) (entry.getKey() * 50000),
                        Map.Entry::getValue));
    }

    public List<String> getMostPopularLocation(List<Job> jobs, int limit) {
        return jobs.stream()
                .collect(Collectors.groupingBy(job -> job.getLocation(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((x1, x2) -> (int) (x2.getValue() - x1.getValue()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }
}
