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
        Map<Long, String> idAndNames = getIdAndNames(actions);
        Map<Long, Long> actionCounts = actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getId,
                        Collectors.counting()
                ));
        return actionCounts.entrySet().stream()
                .sorted(Map.Entry.<Long, Long>comparingByValue().reversed())
                .limit(num)
                .map(entry -> idAndNames.get(entry.getKey()))
                .toList();
    }

    public static List<String> getTopPopularHashtags(List<UserAction> actions, int num) {
        Map<String, Long> hashtagCounts = actions.stream()
                .filter(u -> u.getContent() != null && !u.getContent().isBlank())
                .flatMap(user -> Arrays.stream(user.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .map(word -> word.replaceAll("[^#\\w]", ""))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        return hashtagCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(num)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getTopCommentersLastMonth(List<UserAction> actions, int num) {
        LocalDate lastMonth = LocalDate.now().minusMonths(1);
        Map<Long, String> idAndNames = getIdAndNames(actions);
        Map<Long, Long> commentActionCount = actions.stream()
                .filter(user -> user.getActionType() == ActionType.COMMENT
                        && user.getActionDate().isAfter(lastMonth))
                .collect(Collectors.groupingBy(
                        UserAction::getId,
                        Collectors.counting()
                ));
        return commentActionCount.entrySet().stream()
                .sorted(Map.Entry.<Long, Long>comparingByValue().reversed())
                .limit(num)
                .map(entry -> idAndNames.get(entry.getKey()))
                .toList();
    }

    public static Map<ActionType, Double> getActionTypePercent(List<UserAction> actions) {
        long allActions = actions.size();
        Map<ActionType, Long> actionTypeCount = actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.counting()
                ));
        return actionTypeCount.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        v -> (v.getValue() * 100.0) / allActions
                ));
    }

    private static Map<Long, String> getIdAndNames(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.toMap(
                        UserAction::getId,
                        UserAction::getName,
                        (a, b) -> a
                ));
    }
}