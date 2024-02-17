package faang.school.godbless.usersactivityanalysis2703;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("gold bless us");
    }

    public static List<Integer> getTopTenUsers(List<UserAction> userActions) {
        Map<Integer, Long> userActivity = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()));

        return userActivity.entrySet().stream()
                .sorted((user1, user2) -> Math.toIntExact(user1.getValue() - user2.getValue()))
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
                .sorted((topic1, topic2) -> Math.toIntExact(topic1.getValue() - topic2.getValue()))
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
                .sorted((user1, user2) -> Math.toIntExact(user1.getValue() - user2.getValue()))
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

        Map<String, Double> result = new HashMap<>();
        for (var entry : actionsActivity.entrySet()) {
            result.put(entry.getKey(), (double) entry.getValue() / actionTypesQuantity);
        }
        return result;
    }
}
