package faang.school.godbless.activity_analysis;

import lombok.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionProcessor {
    public static List<Integer> findIdOfTopNMostActiveUsers(@NonNull List<UserAction> userActionList,
                                                            @NonNull List<ActionType> actionTypeList,
                                                            int top) {
        Map<Integer, Long> userIdAndPostsCountMap = userActionList.stream()
                .filter(userAction -> actionTypeList.contains(userAction.actionType()))
                .collect(Collectors.groupingBy(UserAction::id, Collectors.counting()));

        return userIdAndPostsCountMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(top)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> findTopNMostDiscussedThemes(@NonNull List<UserAction> userActionList, int top) {
        Map<String, Long> hashtagAndCountMap = userActionList.stream()
                .filter(userAction -> userAction.actionType() == ActionType.COMMENT
                        || userAction.actionType() == ActionType.POST)
                .flatMap(userAction -> Arrays.stream(userAction.content().split("[ .,!?/:]")))
                .filter(string -> string.startsWith("#"))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(string -> string, Collectors.counting()));

        return hashtagAndCountMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(top)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<Integer> findIdOfTopNMostActiveUsersInComments(@NonNull List<UserAction> userActionList, int top) {
        Map<Integer, Long> userIdAndPostsCountMap = userActionList.stream()
                .filter(user -> user.actionType() == ActionType.COMMENT)
                .collect(Collectors.groupingBy(UserAction::id, Collectors.counting()));

        return userIdAndPostsCountMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(top)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> countPercentageOfEachActionType(@NonNull List<UserAction> userActionList,
                                                                          @NonNull List<ActionType> actionTypeList) {
        Map<ActionType, Long> actionTypeGrouped = userActionList.stream()
                .filter(user -> actionTypeList.contains(user.actionType()))
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()));

        Double sum = actionTypeGrouped.values().stream()
                .mapToDouble(value -> value)
                .sum();

        return actionTypeGrouped.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue() / sum));
    }
}
