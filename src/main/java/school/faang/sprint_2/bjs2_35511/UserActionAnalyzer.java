package school.faang.sprint_2.bjs2_35511;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> userActions) {
        return userActions.stream()
                .map(UserAction::getContent)
                .map(s -> s.split(" "))
                .flatMap(Arrays::stream)
                .filter(s -> s.startsWith("#"))
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> userActions) {
        return userActions.stream()
                .filter(userAction ->
                        userAction.getActionDate().isAfter(LocalDate.now().minusMonths(1)))
                .filter(userAction -> userAction.getActionType().equals("comment"))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> userActions) {
        Map<String, Long> actionsCountByTypes = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        long allActionsCount = actionsCountByTypes.values().stream()
                .mapToLong(Long::longValue)
                .sum();

        return actionsCountByTypes.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry ->
                        ((double) entry.getValue() / allActionsCount) * 100));
    }
}
