package bjs2_88183;

import java.time.LocalDate;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions, int topLimit) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::userName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topLimit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int topLimit) {
        return actions.stream()
                .filter(a -> a.content() != null
                        && (a.actionType() == ActionType.POST || a.actionType() == ActionType.COMMENT))
                .flatMap(a -> Arrays.stream(a.content().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topLimit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int topLimit) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        return actions.stream()
                .filter(a -> a.actionType() == ActionType.COMMENT && a.actionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::userName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topLimit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> actions) {
        long total = actions.size();
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue() * 100.0 / total
                ));
    }
}