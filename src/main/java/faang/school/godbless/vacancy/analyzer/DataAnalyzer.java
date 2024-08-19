package faang.school.godbless.vacancy.analyzer;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataAnalyzer {

    public List<String> findTopSkills(Stream<String> stream, int topLimit) {
        List<Job> jobs = JobStreamProcessor.parse(stream);
        return jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topLimit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> findTopPositions(Stream<String> stream, int topLimit) {
        List<Job> jobs = JobStreamProcessor.parse(stream);
        return jobs.stream()
                .map(Job::getPosition)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topLimit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, Long> salaryRangeQuantity(Stream<String> stream, String position, List<List<Integer>> ranges) {
        List<Job> jobs = JobStreamProcessor.parse(stream).stream()
                .filter(job -> job.getPosition().equals(position))
                .toList();

        return ranges.stream()
                .collect(Collectors.toMap(
                        range -> String.format("%d - %d", range.get(0), range.get(1)),
                        range -> calculateSalariesInRange(jobs, range)));
    }

    public List<String> findTopLocations(Stream<String> stream, int topLimit) {
        List<Job> jobs = JobStreamProcessor.parse(stream);
        return jobs.stream()
                .map(Job::getLocation)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topLimit)
                .map(Map.Entry::getKey)
                .toList();
    }

    private static Long calculateSalariesInRange(List<Job> jobs, List<Integer> range) {
        return jobs.stream()
                .filter(job -> job.getSalary() >= range.get(0) && job.getSalary() <= range.get(1))
                .count();
    }
}
