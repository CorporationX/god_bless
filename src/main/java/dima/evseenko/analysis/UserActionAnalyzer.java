package dima.evseenko.analysis;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> userActions) {
        return userActions
                .stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map((entry) -> entry.getKey() + " actions: " + entry.getValue())
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> userActions) {
        String[] content = userActions
                .stream()
                .map((UserAction::getContent))
                .filter(userActionContent -> userActionContent.contains("#"))
                .reduce("", String::concat)
                .replaceAll("[(\\\\s,.\"!?:';)]+", " ")
                .split(" ");

        return Stream.of(content)
                .filter(s -> s.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map((entry) -> entry.getKey() + " count: " + entry.getValue()).toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> userActions) {
        return userActions
                .stream()
                .filter((userAction -> userAction.getActionType().equals(ActionType.COMMENT) && userAction.getActionDate().isAfter(LocalDate.now().minusMonths(1))))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(entry -> entry.getKey() + " count: " + entry.getValue())
                .toList();
    }

    public static Map<ActionType, Double> actionPercentages(List<UserAction> userActions) {
        return userActions
                .stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (e.getValue() * 100) / (double) userActions.size()));
    }
}
