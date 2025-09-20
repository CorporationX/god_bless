package school.faang.useraction_bjs2_88209;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions, int n) {
        Map<String, Long> userActionCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()));
        return userActionCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .limit(n)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int n) {
        final String hashtagSplitRegex = "\\s+";

        Map<String, Long> userHashtagCount = actions.stream()
                .filter(x -> x.getContent() != null && (ActionType.POST == x.getActionType()
                        || ActionType.COMMENT == x.getActionType()))
                .flatMap(x -> Arrays.stream(x.getContent().split(hashtagSplitRegex)))
                .filter(w -> w.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return userHashtagCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .limit(n)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int n) {
        LocalDateTime monthAgo = LocalDateTime.now().minusMonths(1);
        Map<String, Long> userHashtagCount = actions.stream()
                .filter(x -> ActionType.COMMENT == x.getActionType()
                        && x.getActionDate().isAfter(ChronoLocalDate.from(monthAgo)))
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()));
        return userHashtagCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .limit(n)
                .toList();
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> actions) {
        long totalAction = actions.size();

        Map<ActionType, Long> actionTypeCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));
        return actionTypeCount.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> Double.valueOf((double) (entry.getValue() * 100) / totalAction)
                ));
    }
}
