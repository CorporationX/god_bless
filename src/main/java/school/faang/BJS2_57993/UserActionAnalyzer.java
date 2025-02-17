package school.faang.BJS2_57993;

import lombok.NonNull;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(@NonNull List<UserAction> userActions, int topN) {
        Map<String, Long> users = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return groupingBy(users, topN);
    }

    public static List<String> topPopularHashtags(@NonNull List<UserAction> userActions, int topN) {
        List<String> allTags = userActions.stream()
                .map(UserAction::getContent)
                .flatMap(s -> Arrays.stream(s.split("[?!.\s]")))
                .filter(s -> s.startsWith("#"))
                .toList();
        Map<String, Long> groupTags = allTags.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        return groupingBy(groupTags, topN);
    }

    public static List<String> topCommentersLastMonth(@NonNull List<UserAction> userActions, int topN) {
        List<Integer> month = userActions.stream()
                .map(s -> s.getActionDate().getMonthValue())
                .sorted(Comparator.reverseOrder())
                .toList();
        if (month.isEmpty()) {
            throw new IllegalArgumentException("No month found");
        }
        int lastMonth = month.get(0);
        Map<String, Long> groupMonth = userActions.stream()
                .filter(s -> s.getActionDate().getMonthValue() == lastMonth)
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return groupingBy(groupMonth, topN);
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> userActions) {
        int allActions = userActions.size();
        Map<String, Long> groupActionType = userActions.stream()
                .collect(Collectors.groupingBy(user -> user.getActionType().name(), Collectors.counting()));
        return groupActionType.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (double) (e.getValue() * 100) / allActions));
    }

    private static List<String> groupingBy(Map<String, Long> group, int topN) {
        return group.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }
}