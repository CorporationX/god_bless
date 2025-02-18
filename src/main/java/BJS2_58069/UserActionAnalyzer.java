package BJS2_58069;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions, int n) {
        Map<String, Long> userActionCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        return userActionCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int n) {
        Map<String, Long> hashtagCount = actions.stream()
                .filter(action -> action.getContent().startsWith("#"))
                .map(action -> action.getContent().split(" ")[0])
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()));

        return hashtagCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int n) {
        return actions.stream()
                .filter(action -> action.getActionType() == ActionType.COMMENT)
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        Map<ActionType, Long> actionTypeCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        long totalActions = actions.size();
        return actionTypeCount.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().name(), entry -> (double) entry.getValue() / totalActions * 100)
                );
    }
}
