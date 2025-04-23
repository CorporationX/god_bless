package school.faang.activity_analyse;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions, int count) {
        Map<String, Long> usersToActionsCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        return usersToActionsCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(count)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int count) {
        return actions.stream()
                .map(UserAction::getContent)
                .filter(userAction -> userAction.contains("#"))
                .sorted(Comparator.reverseOrder())
                .limit(count)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int count) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        Map<String, Long> usersToActionsCount = actions.stream()
                .filter(userAction -> userAction.getActionType() == ActionType.COMMENT
                        && userAction.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        return usersToActionsCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(count)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> actionPercentagesByType(List<UserAction> actions) {
        long totalActions = actions.size();
        Map<ActionType, Long> groupedActionsCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        return groupedActionsCount.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / totalActions
                ));
    }
}
