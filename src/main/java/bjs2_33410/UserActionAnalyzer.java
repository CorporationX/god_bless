package bjs2_33410;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<Integer> findMostActiveUsers(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getId))
                .entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size())
                .map(Map.Entry::getKey)
                .limit(10)
                .toList();
    }

    public static List<String> findHotTopics(List<UserAction> userActions) {
        return userActions.stream()
                .filter(userAction -> userAction.getActionType().equals("post") ||
                        userAction.getActionType().equals("comment"))
                .flatMap(userAction -> Arrays.stream(userAction.getContent().split(" ")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(word -> word))
                .entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size())
                .map(Map.Entry::getKey)
                .limit(5)
                .toList();
    }

    public static List<Integer> mostActiveUsers(List<UserAction> userActions) {
        return userActions.stream()
                .filter(userAction -> userAction.getActionType().equals("comment"))
                .collect(Collectors.groupingBy(UserAction::getId))
                .entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size())
                .map(Map.Entry::getKey)
                .limit(3)
                .toList();
    }

    public static Map<String, Double> computeActionPercentages(List<UserAction> userActions) {
        long totalActions = userActions.size();

        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (double) entry.getValue() * 100 / totalActions
                ));

    }
}
