package faang.school.godbless.secondSprint.JobAnalyzer;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataAnalyzer {
    public List<String> findMostPopularSkills(Stream<String> jsonStream) {
        List<Job> jobs = JobStreamProcessor.convertJsonToJob(jsonStream);

        Map<String, Long> sortedRequirements = jobs.stream()
                .flatMap(job -> job.requirements().stream())
                .collect(Collectors.groupingBy(r -> r, Collectors.counting()));

        return sortedRequirements.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> findMostPopularPosition(Stream<String> jsonStream) {
        List<Job> jobs = JobStreamProcessor.convertJsonToJob(jsonStream);

        Map<String, Long> sortedPositions = jobs.stream()
                .map(Job::position)
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()));

        return sortedPositions.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, Integer> getSalaryDistribution(Stream<String> jsonStream) {
        String range1 = "0 - 50.000";
        String range2 = "50.001 - 100.000";
        String range3 = "100.001 - 500.000";
        List<Job> jobs = JobStreamProcessor.convertJsonToJob(jsonStream);

        Map<String, Integer> salaryDistribution = new HashMap<>();
        salaryDistribution.put(range1, 0);
        salaryDistribution.put(range2, 0);
        salaryDistribution.put(range3, 0);

        jobs.forEach(job -> {
            if (job.salary() < 50000) {
                salaryDistribution.put(range1, salaryDistribution.get(range1) + 1);
            } else if (job.salary() > 100000) {
                salaryDistribution.put(range3, salaryDistribution.get(range3) + 1);
            } else {
                salaryDistribution.put(range2, salaryDistribution.get(range2) + 1);
            }
        });

        return salaryDistribution;
    }

    public List<String> findMostPopularLocation(Stream<String> jsonStream) {
        List<Job> jobs = JobStreamProcessor.convertJsonToJob(jsonStream);

        Map<String, Long> sortedLocation = jobs.stream()
                .map(Job::location)
                .collect(Collectors.groupingBy(l -> l, Collectors.counting()));

        return sortedLocation.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }
}
