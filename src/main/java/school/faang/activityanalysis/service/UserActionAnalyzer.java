package school.faang.activityanalysis.service;

import school.faang.activityanalysis.entity.ActionType;
import school.faang.activityanalysis.entity.UserAction;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> getTopActiveUsers(List<UserAction> actions, int num) {
        Map<Long, String> idAndNames = actions.stream()
                .collect(Collectors.toMap(
                        UserAction::getId,
                        UserAction::getName,
                        (a, b) -> a
                ));
        return actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getId,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<Long, Long>comparingByValue().reversed())
                .limit(num)
                .map(entry -> idAndNames.get(entry.getKey()))
                .toList();
    }

    public static List<String> getTopPopularHashtags(List<UserAction> actions, int num) {
        return actions.stream()
                .filter(u -> u.getContent() != null && !u.getContent().isBlank())
                .flatMap(user -> Arrays.stream(user.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .map(word -> word.replaceAll("[^#\\w]", ""))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(num)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getTopCommentersLastMonth(List<UserAction> actions, int num) {
        LocalDate lastMonth = LocalDate.now().minusMonths(1);
        Map<Long, String> idAndNames = actions.stream()
                .collect(Collectors.toMap(
                        UserAction::getId,
                        UserAction::getName,
                        (a, b) -> a
                ));
        return actions.stream()
                .filter(user ->
                        user.getActionType() == ActionType.COMMENT
                                && user.getActionDate().isAfter(lastMonth))
                .collect(Collectors.groupingBy(
                        UserAction::getId,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<Long, Long>comparingByValue().reversed())
                .limit(num)
                .map(entry -> idAndNames.get(entry.getKey()))
                .toList();
    }

    public static Map<ActionType, Double> getActionTypePercent(List<UserAction> actions) {
        long allActions = actions.size();
        return actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        v -> (v.getValue() * 100.0) / allActions
                ));
    }
}
