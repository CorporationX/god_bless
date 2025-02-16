package school.faang.action_analyzer;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions, int limit) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit).map(Map.Entry::getKey).toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int limit) {
        return actions.stream()
                .filter(u -> u.getContent() != null
                        && (ActionType.COMMENT.equals(u.getActionType())
                        || ActionType.POST.equals(u.getActionType())))
                .flatMap(u -> Arrays.stream(u.getContent().split("[\s.,!?]")))
                .filter(i -> i.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(limit)
                .map(Map.Entry::getKey).toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int limit) {
        return actions.stream()
                .filter(a -> ActionType.COMMENT.equals(a.getActionType())
                        && a.getActionDate().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit).map(Map.Entry::getKey).toList();
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> actions) {
        Map<ActionType, Long> actionTypeToCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));
        return actionTypeToCount.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / actions.size()
                ));
    }

}
