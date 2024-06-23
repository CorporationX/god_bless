package faang.school.godbless.sprint_2.stream_API.task_4_analizator;

import faang.school.godbless.sprint_2.stream_API.task_4_analizator.models.Job;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataAnalyzer {

    public List<String> findTopSkills(Stream<Job> stream, int limit) {
        Map<String, Long> countRequirementMap = stream.flatMap(j -> j.requirements().stream())
                .collect(Collectors.groupingBy(r -> r, Collectors.counting()));

        return countRequirementMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> findTopPositions(Stream<Job> stream, int limit) {
        Map<String, Long> positionCountMap = stream.map(Job::position)
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()));

        return positionCountMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, Long> groupByRangeSalary(Stream<Job> stream, int stepRange) {
        Stream<Integer> salaries = stream.map(Job::salary);
        return salaries.collect(Collectors.groupingBy(s -> difineRange(s, stepRange), Collectors.counting()));

    }

    private String difineRange(int value, int stepRange) {
        int secondRange = stepRange * 2;
        int thirdRange = stepRange * 3;
        if (value < stepRange) {
            return "до %d".formatted(stepRange);
        } else if (value < secondRange) {
            return "от %d до %d".formatted(stepRange, secondRange);
        } else if (value < thirdRange) {
            return "от %d до %d".formatted(secondRange, thirdRange);
        }
        return "больше %d".formatted(thirdRange);
    }

    public List<String> findTopLocations(Stream<Job> stream, int limit) {
        Map<String, Long> locationsCountMap = stream.map(Job::location)
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()));

        return locationsCountMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }
}
