package faang.school.godbless.lambda_stream.activity_analysis;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ActivityAnalyzer {
    public static List<Integer> getTop10ActiveUsers(List<UserAction> userActions) {
        return userActions.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey).toList();
    }

    public static List<String> getTop5PopularHashtags(List<UserAction> userActions) {
        return userActions.stream()
                .filter(Objects::nonNull)
                .map(UserAction::getContent)
                .flatMap(str -> Arrays.stream(str.split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey).toList();
    }

    public static List<Integer> getTop3UsersByCommentInLastMonth(List<UserAction> userActions) {
        LocalDateTime lastMonth = LocalDateTime.now().minusMonths(1);
        return userActions.stream()
                .filter(Objects::nonNull)
                .filter(userAction -> userAction.getActionType().equals("comment"))
                .filter(userAction -> userAction.getActionDate().isAfter(lastMonth))
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey).toList();
    }

    public static Map<String, Double> getPercentageOfActions(List<UserAction> userActions) {
        long countOfActions = userActions.size();
        Map<String, Double> groupedByActionType = userActions.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(UserAction::getActionType, (Collectors.summingDouble(action -> 1.0))));
        groupedByActionType.replaceAll((key, value) -> (value / countOfActions) * 100);
        return groupedByActionType;
    }
}
