package faang.school.godbless.activity_analysis;

import lombok.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionProcessor {
    public static List<Integer> findTopTenMostActiveUsers(@NonNull List<UserAction> users,
                                                          @NonNull List<ActionType> actions) {
        return users.stream()
                .filter(userAction -> actions.contains(userAction.actionType()))
                .collect(Collectors.groupingBy(UserAction::id, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .map(Map.Entry::getKey)
                .limit(10)
                .toList();
    }

    public static List<String> findTopFiveMostDiscussedThemes(@NonNull List<UserAction> users) {
        return users.stream()
                .filter(userAction -> userAction.actionType() == ActionType.COMMENT
                        || userAction.actionType() == ActionType.POST)
                .flatMap(userAction -> Arrays.stream(userAction.content().split("[ .,!?/:]")))
                .filter(string -> string.startsWith("#"))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(string -> string, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<Integer> findTopThreeMostActiveUsersInComments(@NonNull List<UserAction> users) {
        return users.stream()
                .filter(user -> user.actionType() == ActionType.COMMENT)
                .collect(Collectors.groupingBy(UserAction::id, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> countPercentageOfEachActionType(@NonNull List<UserAction> users,
                                                                          @NonNull List<ActionType> actionTypes) {
        Map<ActionType, Long> actionTypeGrouped = users.stream()
                .filter(user -> actionTypes.contains(user.actionType()))
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()));

        Double sum = actionTypeGrouped.values().stream()
                .mapToDouble(l -> l).sum();

        return actionTypeGrouped.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue() / sum));
    }
}
