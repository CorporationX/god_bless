package school.faang.task_47181;

import school.faang.task_47181.model.ActionType;
import school.faang.task_47181.model.UserAction;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topHashtags(List<UserAction> actions) {
        return actions.stream()
                .filter(action -> !action.getContent().isBlank())
                .flatMap(action -> Arrays.stream(action.getContent().split(" ")))
                .map(line -> line.replaceAll("[^a-zA-Z#]", ""))
                .filter(line -> line.startsWith("#"))
                .collect(Collectors.groupingBy(item -> item, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        LocalDate now = LocalDate.now();
        LocalDate oneMonthAgo = now.minusMonths(1);

        return actions.stream()
                .filter(action -> action.getActionType() == ActionType.COMMENT
                        && !action.getActionDate().isBefore(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> calculateActionPercentages(List<UserAction> actions) {
        Map<ActionType, Long> groupedActions = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        long actionsSize = groupedActions.values().stream().reduce(0L, Long::sum);

        return groupedActions.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (double) (entry.getValue() * 100) / actionsSize
                ));
    }
}
