package school.faang.task_47477;

import java.util.*;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getName,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        return actions.stream()
                .flatMap(user -> Arrays.stream(user.getContent().split(" ")))
                .filter(content -> content.startsWith("#"))
                .map(content -> content.replaceAll("[!.,]", ""))
                .collect(Collectors.groupingBy(
                        content -> content,
                        Collectors.counting()
                )).entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        return actions.stream()
                .filter(user -> user.getActionType().equals("comment"))
                .collect(Collectors.groupingBy(
                        UserAction::getName,
                        Collectors.counting()
                )).entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.counting()
                )).entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        type -> (type.getValue() * 100.0) / actions.size())
                );
    }
}
