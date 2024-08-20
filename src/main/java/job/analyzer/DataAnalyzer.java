package job.analyzer;

import java.util.*;
import java.util.stream.Collectors;


public class DataAnalyzer {
    public static List<String> mostPopularSkills(List<Job> jobs, int limit) {
        return jobs.stream()
            .flatMap(obj -> obj.getRequirements().stream())
            .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(limit)
            .map(Map.Entry::getKey)
            .toList();
    }

    public static List<String> mostPopularPositions(List<Job> jobs, int limit) {
        return jobs.stream()
            .map(Job::getName)
            .collect(Collectors.groupingBy((name) -> name, Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(limit)
            .map(Map.Entry::getKey)
            .toList();
    }

    public static Map<String, Long> salaryCountVacanciesAnalyze(List<Job> jobs, List<SalaryRange> range) {
        return jobs.stream()
            .map(Job::getSalary)
            .collect(Collectors.groupingBy((salary) -> {
                String outRange = "Не входят в диапазон";

                Optional<SalaryRange> salaryRange = range.stream()
                    .filter((r) -> r.getStart() < salary && r.getEnd() > salary)
                    .findFirst();

                if (!salaryRange.isPresent()) {
                    return outRange;
                }

                return String.format("%d - %d", salaryRange.get().getStart(), salaryRange.get().getEnd());
            }, Collectors.counting()));
    }

    public static List<String> mostPopularLocation(List<Job> jobs, int limit) {
        return jobs.stream()
            .map(Job::getLocation)
            .collect(Collectors.groupingBy((loc) -> loc, Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(limit)
            .map(Map.Entry::getKey)
            .toList();
    }
}
