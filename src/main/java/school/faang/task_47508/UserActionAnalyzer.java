package school.faang.task_47508;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    private static final int TOP_ACTIVE_USERS_MAX_SIZE = 10;
    private static final int TOP_POPULAR_HASHTAGS_MAX_SIZE = 5;
    private static final int TOP_COMMENTERS_LAST_MONTH_MAX_SIZE = 3;
    private static final double PERCENTAGES_NUMBER = 100.0;

    public static List<String> topActiveUsers(List<UserAction> userActions) {
        return userActions.stream().collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(TOP_ACTIVE_USERS_MAX_SIZE)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> userActions) {
        return userActions.stream()
                .filter(action -> action.getContent() != null && action.getActionType()
                        .equals(ActionType.post) || action.getActionType().equals(ActionType.comment))
                .flatMap(action -> Arrays.stream(action.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(TOP_POPULAR_HASHTAGS_MAX_SIZE)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> userActions) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        return userActions.stream()
                .filter(action -> action.getActionType().equals(ActionType.comment) && action.getActionDate()
                        .isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(TOP_COMMENTERS_LAST_MONTH_MAX_SIZE)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {

        long totalActions = actions.size();

        return actions.stream()
                .collect(Collectors.groupingBy(userAction -> userAction.getActionType()
                        .toString(), Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry ->
                        (entry.getValue() * PERCENTAGES_NUMBER) / totalActions));
    }
}