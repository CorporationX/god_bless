package faang.school.godbless.usersactivityanalysis2703;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("god bless us");
    }

    public static List<Integer> getTopTenUsers(List<UserAction> userActions) {
        Map<Integer, Long> userActivity = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()));

        return userActivity.entrySet().stream()
                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                .limit(10)
                .map(user -> user.getKey())
                .toList();
    }

    public static List<String> getTopFiveTopics(List<UserAction> userActions) {
        Map<String, Long> topicsActivity = userActions.stream()
                .filter(userAction -> userAction.getActionType().equals("post") || userAction.getActionType().equals("comment"))
                .filter(userAction -> userAction.getContent().contains("#"))
                .flatMap(userAction -> Arrays.stream(userAction.getContent().split(" ")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(content -> content, Collectors.counting()));

        return topicsActivity.entrySet().stream()
                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                .limit(5)
                .map(topic -> topic.getKey())
                .toList();
    }

    public static List<String> getTopThreeCommentators(List<UserAction> userActions) {
        Map<String, Long> commentatorsActivity = userActions.stream()
                .filter(userAction -> userAction.getActionType().equals("comment"))
                .filter(userAction -> userAction.getActionDate().isAfter(LocalDateTime.now().minusMonths(1)))
                .collect(Collectors.groupingBy(userAction -> userAction.getName(), Collectors.counting()));

        return commentatorsActivity.entrySet().stream()
                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                .limit(3)
                .map(user -> user.getKey())
                .toList();
    }

    public static Map<String, Double> getActionPercents(List<UserAction> userActions) {
        Map<String, Long> actionsActivity = userActions.stream()
                .collect(Collectors.groupingBy(userAction -> userAction.getActionType(), Collectors.counting()));

        long actionTypesQuantity = actionsActivity.values().stream()
                .reduce(0L, Long::sum);
        if (actionTypesQuantity == 0) {
            return new HashMap<>(Map.of("", 0.0));
        }
        return actionsActivity.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> (double) entry.getValue() / actionTypesQuantity * 100));
    }
}
