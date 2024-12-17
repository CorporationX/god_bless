package school.faang.sprint2.bjs_47270;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    private static final int TOP_ACTIVE_USERS_LIMIT = 10;
    private static final int TOP_HASHTAGS_LIMIT = 5;
    private static final int TOP_COMMENTERS_LIMIT = 3;
    private static final double PERCENTAGE_MULTIPLIER = 100.0;
    private static final String HASHTAG_SPLIT_REGEX = "[ ,.;!]+";

    public static List<String> topActiveUsers(List<UserAction> userActions) {
        Map<String, Long> users = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()));

        return users.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(TOP_ACTIVE_USERS_LIMIT)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topPopularHashtags(List<UserAction> userActions) {
        Map<String, Long> hashtags = userActions.stream()
                .filter(x -> x.content() != null
                        && x.actionType().equals(ActionType.POST)
                        || x.actionType().equals(ActionType.COMMENT))
                .flatMap(x -> Arrays.stream(x.content().split(HASHTAG_SPLIT_REGEX)))
                .filter(x -> x.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return hashtags.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(TOP_HASHTAGS_LIMIT)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topCommentersForPreviousMonth(List<UserAction> userActions) {
        LocalDate previousMonth = LocalDate.now().minusMonths(1);

        Map<String, Long> users = userActions.stream()
                .filter(x -> x.actionType().equals(ActionType.COMMENT) && x.actionDate().isAfter(previousMonth))
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()));

        return users.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(TOP_COMMENTERS_LIMIT)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> userActions) {
        Map<ActionType, Long> actionTypes = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()));

        int generalSumActionTypes = actionTypes.values().stream()
                .mapToInt(Long::intValue)
                .sum();

        return actionTypes.entrySet().stream()
                .collect(Collectors.toMap(
                        k -> k.getKey(),
                        v -> (v.getValue() * PERCENTAGE_MULTIPLIER / generalSumActionTypes)
                ));
    }
}
