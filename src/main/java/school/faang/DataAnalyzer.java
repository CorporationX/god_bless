package school.faang;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {
    private static final int SALARY_BUCKET_SIZE = 50000;

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

    public static Map<String, List<Job>> groupJobsBySalary(List<Job> jobs) {
        validateJobs(jobs);
        return jobs.stream()
                .collect(Collectors.groupingBy(job -> getSalaryRange(job.getSalary())));
    }

    public static List<String> getTopFivePopularOffices(List<Job> jobs) {
        validateJobs(jobs);
        return jobs.stream()
                .sorted(Comparator.comparing(Job::getLocation))
                .limit(5)
                .map(Job::getPosition)
                .toList();
    }

    private static String getSalaryRange(int salary) {
        int lowerBound = salary / SALARY_BUCKET_SIZE * SALARY_BUCKET_SIZE;
        return lowerBound + "-" + (lowerBound + SALARY_BUCKET_SIZE) + "k";
    }

    private static void validateJobs(List<Job> jobs) {
        if (jobs == null) {
            throw new IllegalArgumentException("Job list can't be null.");
        }
        for (Job job : jobs) {
            if (job == null) {
                throw new IllegalArgumentException("Job in list can't be null.");
            }
        }
    }
}
