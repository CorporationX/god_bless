package faang.school.godbless.BJS2_22724;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataAnalyzer {
    public List<String> mostPopularSkills(List<Job> jobList) {
        Map<String, Long> resultMap = jobList.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()));

        Stream<Map.Entry<String, Long>> sortedStream = resultMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(5);

        return sortedStream
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .toList();
    }


}
