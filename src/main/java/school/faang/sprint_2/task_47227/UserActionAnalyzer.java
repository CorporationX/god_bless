package school.faang.sprint_2.task_47227;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    private static final int ACTIVE_USERS_QUANTITY = 10;
    private static final int POPULAR_HASHTAGS_QUANTITY = 5;
    private static final int COMMENTERS_LAST_MONTH = 3;

    public static List<String> topActiveUsers(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(ACTIVE_USERS_QUANTITY)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> userActions) {
        String hashtags = "#";
        return userActions.stream()
                .filter(a -> a.content() != null && a.actionType().equals(ActionType.POST)
                        || a.actionType().equals(ActionType.COMMENT))
                .flatMap(a -> Arrays.stream(Objects.requireNonNull(a.content()).split("\\s+")))
                .filter(w -> w.startsWith(hashtags))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(POPULAR_HASHTAGS_QUANTITY)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> userActions) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        return userActions.stream()
                .filter(a -> a.actionType().equals(ActionType.COMMENT) && a.actionDate().isBefore(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(COMMENTERS_LAST_MONTH)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Long> actionTypePercentages(List<UserAction> userActions) {
        long totalActions = userActions.size();
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100) / totalActions
                ));
    }
}
