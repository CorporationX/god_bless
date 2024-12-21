package school.faang.sprint_2.task_47360;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    private static final Pattern HASHTAG_PATTERN = Pattern.compile("#\\w+");

    private static <K> List<K> sortAndLimit(Map<K, Long> map, int limit) {
        return map.entrySet().stream()
                .sorted(Map.Entry.<K, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topActiveUsers(List<UserAction> actions) {
        Map<String, Long> userActionsCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()));
        return sortAndLimit(userActionsCount, 10);
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        Map<String, Long> hashtagCounts = actions.stream()
                .flatMap(action -> HASHTAG_PATTERN.matcher(action.content()).results().map(MatchResult::group))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return sortAndLimit(hashtagCounts, 5);
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        return actions.stream()
                .filter(Objects::nonNull)
                .filter(action -> action.actionDate() != null)
                .filter(action -> !action.actionDate().isBefore(LocalDate.now().minusMonths(1)))
                .filter(action -> "comment".equals(action.actionType()))
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        long totalActions = actions.size();
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.collectingAndThen(
                        Collectors.counting(), count -> (count * 100.0) / totalActions
                )));
    }
}
