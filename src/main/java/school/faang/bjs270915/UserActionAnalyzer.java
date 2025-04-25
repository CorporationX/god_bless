package school.faang.bjs270915;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions, int num) {
        Map<String, Long> usersToActionsCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()));
        return usersToActionsCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(num)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int num) {
        Map<String, Long> usersToHashtagsCount = actions.stream()
                .filter(userAction -> !userAction.content().isEmpty())
                .peek(userAction -> Arrays.stream(userAction.content().split(""))
                        .filter(s -> s.startsWith("#")))
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()));

        return usersToHashtagsCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(num)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int num) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        Map<String, Long> usersToCommentCount = actions.stream()
                .filter(userAction -> userAction.actions().equals(ActionType.COMMENT))
                .filter(userAction -> userAction.actionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()));

        return usersToCommentCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(num)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> actions) {
        long totalActions = actions.size();
        Map<ActionType, Long> actionTypeToCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::actions, Collectors.counting()));
        return actionTypeToCount.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / totalActions
                ));
    }
}
