package school.faang.bjs2_70826;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> getMostActiveList(List<UserAction> userActions) {
        return userActions.stream()
                .filter(userAction -> Objects.equals(userAction.actionDate, LocalDate.now()))
                .collect(Collectors.teeing(
                        Collectors.groupingBy(UserAction::getId, Collectors.counting()),
                        Collectors.toMap(
                                UserAction::getId,
                                UserAction::getName,
                                (existing, replacement) -> existing),
                        (mapWithCounts, mapWithNames) -> mapWithCounts.entrySet().stream()
                                .sorted(Map.Entry.<Long, Long>comparingByValue().reversed())
                                .limit(3)
                                .map(entry -> mapWithNames.get(entry.getKey()))
                                .collect(Collectors.toList())
                ));

    }

    public static List<String> getMostPopularHashTag(List<UserAction> userActions) {
        return userActions.stream()
                .filter(userAction -> Objects.equals(userAction.actionDate, LocalDate.now()))
                .flatMap(userAction -> Arrays.stream(userAction.getContent().split(" ")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<String> getUsersWithMostComments(List<UserAction> userActions) {
        return userActions.stream()
                .filter(userAction -> Objects.equals(userAction.actionDate, LocalDate.now()))
                .filter(userAction -> userAction.getActionType() == ActionType.COMMENT)
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .distinct()
                .toList();
    }

    public static Map<ActionType, Double> calculatePercentage(List<UserAction> userActions) {
        return userActions.stream()
                .filter(userAction -> Objects.equals(userAction.actionDate, LocalDate.now()))
                .map(UserAction::getActionType)
                .collect(Collectors.teeing(
                        Collectors.groupingBy(Function.identity(), Collectors.counting()),
                        Collectors.counting(),
                        (countByType, total) -> countByType.entrySet().stream()
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        entry -> entry.getValue() * 100.0 / total
                                ))
                ));
    }
}
