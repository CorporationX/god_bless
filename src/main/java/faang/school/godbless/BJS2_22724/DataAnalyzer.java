package faang.school.godbless.BJS2_22724;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {
    public void mostPopularSkills(List<Job> jobList) {
        Map<String, Long> resultMap = jobList.stream()
                .map(Job::getPosition)
                .collect(Collectors.groupingBy(position -> position, Collectors.counting()));

        System.out.println(resultMap);
    }
}
