package school.faang.bjs2_70725;

import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@UtilityClass
public class DataAnalyzer {
    public List<String> findFiveMostNeededSkills(List<Job> jobs) {
        return findMostPopularFromStream(
                jobs.stream()
                        .flatMap(job -> job.requirements().stream()),
                5);
    }

    public List<String> findFiveMostPopularPositions(List<Job> jobs) {
        return findMostPopularFromStream(
                jobs.stream()
                        .map(Job::position),
                5);
    }

    public List<String> findFiveMostPopularLocations(List<Job> jobs) {
        return findMostPopularFromStream(
                jobs.stream()
                        .map(Job::location),
                5);
    }

    public Map<String, List<Job>> groupJobsBySalaryRange(List<Job> jobs) {
        return jobs.stream()
                .collect(Collectors.groupingBy(job -> {
                    int salary = job.salary();
                    int lowerBound = (salary / 50000) * 50000;
                    int upperBound = lowerBound + 50000;
                    return String.format("%d-%d", lowerBound, upperBound);
                }));
    }

    private List<String> findMostPopularFromStream(Stream<String> stream, int count) {
        return stream
                .collect(Collectors.groupingBy(key -> key, Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparingLong((Map.Entry<String, Long> entry) -> entry.getValue()).reversed())
                .limit(count)
                .map(Map.Entry::getKey)
                .toList();
    }
}