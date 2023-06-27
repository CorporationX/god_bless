package vacancy_analyzer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {
    public List<String> getMostPopularSkills(List<Job> jobs, int limit) {
        return jobs.stream()
                .flatMap(job -> job.getSkills().stream())
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((j1, j2) -> (int) (j2.getValue() - j1.getValue()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> getMostPopularPositions(List<Job> jobs, int limit) {
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getPosition, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((j1, j2) -> (int) (j2.getValue() - j1.getValue()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, Long> getSalaryByVacancies(List<Job> jobs) {
        return jobs.stream()
                .collect(Collectors.groupingBy(e -> Math.ceil(e.getSalary() / 50000.0), Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(entry ->
                                "От " + (int) (entry.getKey() * 50_000 - 50_000) + " до " + (int) (entry.getKey() * 50_000),
                        Map.Entry::getValue));
    }

    public List<String> getMostPopularLocations(List<Job> jobs, int limit) {
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((j1, j2) -> (int) (j2.getValue() - j1.getValue()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }
}
