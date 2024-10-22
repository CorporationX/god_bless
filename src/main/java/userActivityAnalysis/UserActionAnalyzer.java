package userActivityAnalysis;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> userActionList) {
        return userActionList.stream()
                .collect(Collectors.groupingBy(UserAction::getName))
                .entrySet().stream()
                .sorted((o1, o2) -> o1.getValue().size() - o2.getValue().size())
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> userActionsList) {
        return userActionsList.stream()
                .filter(userAction -> !userAction.getContent().isEmpty() && userAction.getContent().charAt(0) == '#')
                .collect(Collectors.groupingBy(UserAction::getContent))
                .entrySet().stream()
                .sorted(((o1, o2) -> o1.getValue().size() - o2.getValue().size()))
                .map(Map.Entry::getKey)
                .limit(5)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> userActionList) {
        return userActionList.stream()
                .filter(userAction -> userAction.getActionDate().isAfter(LocalDate.now().minusMonths(1)) &&
                        userAction.getActionType().equals("comment"))
                .collect(Collectors.groupingBy(UserAction::getName))
                .entrySet().stream()
                .sorted((o1, o2) -> o1.getValue().size() - o2.getValue().size())
                .map(Map.Entry::getKey)
                .limit(3)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> userActionList) {
        int countingOfAllAction = userActionList.size();
        return userActionList.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue().size() * 100.0) / countingOfAllAction
                ));
    }
}
