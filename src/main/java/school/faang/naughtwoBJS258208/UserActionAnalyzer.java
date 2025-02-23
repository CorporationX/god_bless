package school.faang.naughtwoBJS258208;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions, int n) {
        checkActions(actions);
        checkN(n);
        Map<String, Long> activeUsers = actions.stream()
                .collect(userActionToMap());
        return sortedList(activeUsers, n);
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int n) {
        checkActions(actions);
        checkN(n);
        Map<String, Long> hashtags = actions.stream()
                .filter(action ->
                        action.content() != null
                                && (ActionType.POST.equals(action.actionType())
                                || ActionType.COMMENT.equals(action.actionType())))
                .flatMap(action -> Arrays.stream(action.content().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        return sortedList(hashtags, n);
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int n) {
        checkActions(actions);
        checkN(n);
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        Map<String, Long> activeUsers = actions.stream()
                .filter(action ->
                        action.content() != null
                                && ActionType.COMMENT.equals(action.actionType())
                                && action.actionDate().isAfter(oneMonthAgo))
                .collect(userActionToMap());
        return sortedList(activeUsers, n);
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> actions) {
        checkActions(actions);
        Map<ActionType, Long> actionType = actions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()));
        return actionType.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> entry.getValue() * 100.0 / actions.size()));
    }

    private static Collector<UserAction, ?, Map<String, Long>> userActionToMap() {
        return Collectors.toMap(
                UserAction::name,
                action -> 1L,
                Long::sum
        );
    }
    
    private static List<String> sortedList(Map<String, Long> map, int n) {
        return map.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    private static void checkActions(List<UserAction> actions) {
        if (actions == null) {
            throw new IllegalArgumentException("Actions cannot be 'null'");
        }
    }

    private static void checkN(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N cannot be less than zero");
        }
    }
}
