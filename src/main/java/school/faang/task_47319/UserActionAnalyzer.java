package school.faang.task_47319;

import java.time.LocalDate;;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;


public class UserActionAnalyzer {
    private static final int ACTIVE_USERS_LIMIT = 10;
    private static final int TOP_POPULAR_THEMES = 5;
    private static final int TOP_COMMENTERS_LAST_MONTH = 3;

    public static List<Integer> topActiveUsers(List<UserAction> users) {
        return users.stream()
                .collect(Collectors.groupingBy(UserAction::id, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByKey().reversed())
                .limit(ACTIVE_USERS_LIMIT)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        String hashtags = "#";
        return actions.stream()
                .filter(action -> action.content() != null && action.actionType().equals(ActionType.POST)
                        || action.actionType().equals(ActionType.COMMENT))
                .flatMap(a -> Arrays.stream(Objects.requireNonNull(a.content()).split("\\s+")))
                .filter(word -> word.startsWith(hashtags))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(TOP_POPULAR_THEMES)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        LocalDate monthAgo = LocalDate.now().minusMonths(1);
        return actions.stream()
                .filter(a -> a.actionType().equals(ActionType.COMMENT) && a.actionDate().isBefore(monthAgo))
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(TOP_COMMENTERS_LAST_MONTH)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Long> actionTypePercentages(List<UserAction> actions) {
        long totalActions = actions.size();
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100 / totalActions)
                ));
    }
}
