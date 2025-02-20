package school.faang.BJS2_57993;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(@NonNull List<UserAction> userActions, int limit) {
        Map<String, Long> users = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return groupingBy(users, limit);
    }

    public static List<String> topPopularHashtags(@NonNull List<UserAction> userActions, int limit) {
        List<String> allTags = userActions.stream()
                .map(UserAction::getContent)
                .flatMap(s -> Arrays.stream(s.split("[?!.\s]")))
                .filter(s -> s.startsWith("#"))
                .toList();
        Map<String, Long> groupTags = allTags.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        return groupingBy(groupTags, limit);
    }

    public static List<String> topCommentersLastMonth(@NonNull List<UserAction> userActions, int limit) {
        LocalDate lastMonth = LocalDate.now().minusMonths(1);
        Map<String, Long> groupByLastMonth = userActions.stream()
                .filter(action -> action.getActionType() == ActionType.COMMENT
                        && action.getActionDate().isAfter(lastMonth))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return groupingBy(groupByLastMonth, limit);
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> userActions) {
        int totalActions = userActions.size();
        Map<String, Long> groupActionType = userActions.stream()
                .collect(Collectors.groupingBy(user -> user.getActionType().name(), Collectors.counting()));
        return groupActionType.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (double) (e.getValue() * 100) / totalActions));
    }

    private static List<String> groupingBy(Map<String, Long> group, int topN) {
        return group.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }
}