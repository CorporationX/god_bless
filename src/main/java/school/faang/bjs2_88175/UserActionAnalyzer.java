package school.faang.bjs2_88175;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions, int n) {
        Map<String, Long> usersToActionsCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::userName, Collectors.counting()));
        return usersToActionsCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int n) {
        Map<String, Long> hashtagToCount = actions.stream()
                .filter(action -> action.content() != null
                        && (ActionType.POST.equals(action.actionType())
                        || ActionType.COMMENT.equals(action.actionType())))
                .flatMap(action -> Arrays.stream(action.content().split("\\s+")))
                .filter(word -> !word.isEmpty() && word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return hashtagToCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int n) {
        LocalDate referenceDate = LocalDate.of(2024, 10, 31);
        LocalDate oneMonthAgo = referenceDate.minusMonths(1);
        Map<String, Long> userNameToCommentCount = actions.stream()
                .filter(action -> ActionType.COMMENT.equals(action.actionType())
                        && action.actionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::userName, Collectors.counting()));
        return userNameToCommentCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> calculateActionPercentages(List<UserAction> actions) {
        long totalActions = actions.size();

        Map<ActionType, Long> actionTypeToCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()));
        return actionTypeToCount.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / totalActions
                ));
    }
}
