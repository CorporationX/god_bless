package faang.school.godbless;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("God Bless!");
    }

    public static List<String> findTop10ActiveUsers(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting())).entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> findTop5PopularTopics(List<UserAction> userActions) {
        return userActions.stream()
                .filter(userAction ->
                        (userAction.getActionType() == UserAction.ActionType.POST || userAction.getActionType() == UserAction.ActionType.COMMENT)
                                && userAction.getContent().contains("#"))
                .flatMap(userAction -> Arrays.stream(userAction.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.reducing(0L, e -> 1L, (a, b) -> a + b)))  // Custom counting implementation without Long::sum
                .entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> findTop3CommentersLastMonth(List<UserAction> userActions) {
        LocalDateTime oneMonthAgo = LocalDateTime.now().minusMonths(1);

        Map<String, Long> commenterCounts = userActions.stream()
                .filter(userAction -> userAction.getActionType() == UserAction.ActionType.COMMENT
                        && userAction.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()));

        return commenterCounts.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<UserAction.ActionType, Double> calculateActionTypePercentage(List<UserAction> userActions) {
        long totalActions = userActions.size();

        Map<UserAction.ActionType, Long> actionTypeCounts = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        return actionTypeCounts.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / totalActions
                ));
    }
}