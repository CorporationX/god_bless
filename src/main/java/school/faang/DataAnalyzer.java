package school.faang;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {
    public static List<String> getTopFiveDemandingSkills(List<Job> jobs) {
        validateJobs(jobs);
        return jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((v1, v2) -> Long.compare(v2.getValue(), v1.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getTopFivePositions(List<Job> jobs) {
        validateJobs(jobs);
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getPosition, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((v1, v2) -> Long.compare(v2.getValue(), v1.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, List<Job>> groupBySalary(List<Job> jobs) {
        validateJobs(jobs);
        return jobs.stream()
                .collect(Collectors.groupingBy(job -> getSalaryRange(job.getSalary())));
    }

    private static String getSalaryRange(int salary) {
        int lowerBound = (salary / 50000) * 50000;
        return lowerBound + "-" + (lowerBound + 50000) + "k";
    }

    private static void validateJobs(List<Job> jobs) {
        if (jobs == null) {
            throw new IllegalArgumentException("Job list can't be null.");
        }
    }
}
