package streamapi.three;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static List<Integer> findMostActiveUsers(List<UserAction> userActions) {
        Map<Integer, Long> userActionsCount = userActions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getUserId,
                        Collectors.counting()
                ));

        return userActionsCount.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> findMostPopularHashtags(List<UserAction> userActions) {
        return userActions.stream()
                .filter(action -> "post".equals(action.getActionType()) || "comment".equals(action.getActionType()))
                .flatMap(action -> extractHashtags(action.getContent()).stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static List<String> extractHashtags(String content) {
        if (content == null || content.isEmpty()) {
            return null;
        }
        return Arrays.stream(content.split("\\s+"))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.toList());
    }

    public static List<Integer> findMostActiveUsersForThreeMonths(List<UserAction> userActions) {
        LocalDateTime oneMonthsAgo = LocalDateTime.now().minusMonths(1);

        return userActions.stream()
                .filter(action -> "comment".equals(action.getActionType()))
                .filter(action -> oneMonthsAgo.isAfter(action.getActionDate()))
                .collect(Collectors.groupingBy(UserAction::getUserId,
                        Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<String, Double> getPercentageOfActionTypes(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType,
                        Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        action -> 100.0 * action.getValue() / userActions.size()
                ));
    }
}
