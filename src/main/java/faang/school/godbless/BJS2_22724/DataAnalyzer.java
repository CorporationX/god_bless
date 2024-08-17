package faang.school.godbless.BJS2_22724;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataAnalyzer {

    public List<String> mostPopularOffices(List<Job> jobList) {
        Map<String, Long> resultMap = jobList.stream()
                .map(Job::getLocation)
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()));

        Stream<Map.Entry<String, Long>> sortedStream = resultMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(5);

        return sortedStream
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .toList();
    }

    public List<String> mostPopularSkillsPositions(List<Job> jobList, Function<List<Job>, Map<String, Long>> action) {
        Map<String, Long> resultMap = action.apply(jobList);

        Stream<Map.Entry<String, Long>> sortedStream = resultMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(5);

        return sortedStream
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .toList();
    }

    public Map<String, Long> salaryDistribution(List<Job> jobList) {
        Map<String, Long> salary50k = jobList.stream()
                .map(Job::getSalary)
                .filter(salary -> salary > 0 && salary <= 50000)
                .collect(Collectors.groupingBy(t -> "0-50k", Collectors.counting()));

        Map<String, Long> salary100k = jobList.stream()
                .map(Job::getSalary)
                .filter(salary -> salary > 50000 && salary <= 100000)
                .collect(Collectors.groupingBy(t -> "50-100k", Collectors.counting()));

        Map<String, Long> salaryOver100k = jobList.stream()
                .map(Job::getSalary)
                .filter(salary -> salary > 100000)
                .collect(Collectors.groupingBy(t -> ">100k", Collectors.counting()));

        return Stream.of(salary50k, salary100k, salaryOver100k)
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
    }
}
