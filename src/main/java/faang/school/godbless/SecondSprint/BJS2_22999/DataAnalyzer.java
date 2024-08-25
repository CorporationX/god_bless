package faang.school.godbless.SecondSprint.BJS2_22999;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {

    public static List<String> top5Requirement(List<Job> jobs) {
        Map<String, Long> content = jobs.stream()
                .flatMap(k -> k.getRequirements().stream())
                .collect(Collectors.groupingBy(item -> item, Collectors.counting()));

        return getTop(content, 5);
    }

    public static List<String> top5Titles(List<Job> jobs) {
        Map<String, Long> content = jobs.stream()
                .collect(Collectors.groupingBy(Job::getTitle, Collectors.counting()));

        return getTop(content, 5);
    }

    public static List<String> top5Locations(List<Job> jobs) {
        Map<String, Long> content = jobs.stream()
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()));

        return getTop(content, 5);
    }

    public static Map<String, Long> groupSalary(List<Job> jobs) {
        return jobs.stream()
                .collect(Collectors.groupingBy(j -> getGruopOfSalary(
                                j.getSalary()),
                        Collectors.counting()));
    }

    public static String getGruopOfSalary(int i) {
        int bottomOfGroup = (i / 50_000) * 50_000;
        int topOfGroup = bottomOfGroup + 50_000;
        return bottomOfGroup + " - " + topOfGroup + "K";
    }

    public static <T> List<T> getTop(Map<T, Long> mapToRank, int rankSize) {
        List<T> result = mapToRank.entrySet().stream()
                .sorted(Map.Entry.<T, Long>comparingByValue().reversed())
                .limit(rankSize)
                .map(Map.Entry::getKey)
                .toList();

        return result;
    }
}
