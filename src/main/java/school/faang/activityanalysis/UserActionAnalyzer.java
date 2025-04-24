package school.faang.activityanalysis;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions, int n) {
        Map<String, Long> topUsersCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return topUsersCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int n) {
        Map<String, Long> hashtagToCount = actions.stream()
                .filter(action -> action.getContent() != null)
                .filter(action -> action.getActionType() == ActionType.POST
                        || action.getActionType() == ActionType.COMMENT)
                .flatMap(action -> Arrays.stream(action.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return hashtagToCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int n) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        Map<String, Long> userNameToCommentCount = actions.stream()
                .filter(action -> ActionType.COMMENT.equals(action.getActionType())
                        && action.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return userNameToCommentCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> calculateActionPercentages(List<UserAction> actions) {
        if (actions.isEmpty()) {
            return Map.of();
        }
        long totalActions = actions.size();

        Map<ActionType, Long> actionTypeToCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));
        return actionTypeToCount.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> (entry.getValue() * 100.0) / totalActions));
    }
}
