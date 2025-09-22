package school.faang.user_activity_analysis;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Проект: god_bless
 * Класс UserActionAnalyzer
 * Автор: Vital
 * Дата: 22.09.2025
 */

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions, int n) {
        Map<Integer, Long> usersToActionsCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()));
        return usersToActionsCount.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(n)
                .map(entry -> "User " + entry.getKey())
                .collect(Collectors.toList());
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int n) {
        Map<String, Long> hashtagToCount = actions.stream()
                .filter(action -> action.getContent() != null && (action.getActionType() == ActionType.POST
                        || action.getActionType() == ActionType.COMMENT))
                .flatMap(action -> Arrays.stream(action.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return hashtagToCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int n) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        Map<Integer, Long> userToCommentCount = actions.stream()
                .filter(action ->
                        action.getActionType() == ActionType.COMMENT && action.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()));
        return userToCommentCount.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(n)
                .map(entry -> "User " + entry.getKey())
                .collect(Collectors.toList());
    }

    public static Map<ActionType, Double> calculateActionPercentages(List<UserAction> actions) {
        long totalActions = actions.size();
        Map<ActionType, Long> actionTypeToCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));
        return actionTypeToCount.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / totalActions
                ));
    }
}
