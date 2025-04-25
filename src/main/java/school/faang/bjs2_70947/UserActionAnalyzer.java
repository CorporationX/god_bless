package school.faang.bjs2_70947;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions, int limit) {
        return actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getName,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int limit) {
        return actions.stream()
                .filter(action -> action.getContent().contains("#"))
                .collect(Collectors.groupingBy(
                        UserAction::getName,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int limit) {
        return actions.stream()
                .filter(action -> action
                        .getActionDate()
                        .isAfter(action.getActionDate().minusMonths(1)))
                .collect(Collectors.groupingBy(
                        UserAction::getName,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors
                        .groupingBy(
                                userAction -> userAction.getActionType().toString(),
                                Collectors.collectingAndThen(
                                        Collectors.counting(),
                                        count -> (double) count / actions.size()
                                )
                        ));
    }
}
