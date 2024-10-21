package school.faang.user_activity_analysis;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> top10ActiveUsers(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        return actions.stream()
                .filter(action -> action.getContent() != null && action.getActionType().equals(ActionType.POST) || action.getActionType().equals(ActionType.COMMENT))
                .flatMap(action -> {
                    assert action.getContent() != null;
                    return Arrays.stream(action.getContent().split("////////s+"));
                })
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        return actions.stream()
                .filter(action -> action.getActionType() == ActionType.COMMENT && action.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> actions) {
        long totalActions = actions.size();

        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / totalActions));
    }
}