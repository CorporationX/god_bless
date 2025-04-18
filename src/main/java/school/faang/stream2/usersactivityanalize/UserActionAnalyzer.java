package school.faang.stream2.usersactivityanalize;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions, int limiter) {
        Map<Integer, List<UserAction>> actionsByUser = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getId));
        return actionsByUser.entrySet().stream()
                .sorted(Comparator.comparingInt(
                        (Map.Entry<Integer, List<UserAction>> e) -> e.getValue().size())
                        .reversed())
                .limit(limiter)
                .map(entry -> entry.getValue().get(0).getName())
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int limiter) {
        Map<String, Long> hashtagCount = actions.stream()
                .map(UserAction::getContent)
                .flatMap(content -> Arrays.stream(content.split(" ")))
                .filter(word -> word.startsWith("#"))
                .map(word -> word.replaceAll("\\p{Punct}$", ""))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                        )
                );

        return hashtagCount.entrySet().stream()
                .sorted(Comparator.comparingLong(Map.Entry<String, Long>::getValue).reversed())
                .map(Map.Entry::getKey)
                .limit(limiter)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int limiter) {
        List<UserAction> userCommentsLastMonth = actions.stream()
                .filter(action -> action.getActionType().equals(ActionType.COMMENT))
                .filter(action -> action.getActionDate().isAfter(LocalDate.now().minusMonths(1)))
                .toList();
        return topActiveUsers(userCommentsLastMonth, limiter);
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        Map<ActionType, Long> actionsCount =
                actions.stream()
                        .map(UserAction::getActionType)
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        ));

        return actionsCount.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().toString(),
                        entry -> entry.getValue() * 100.0 / actions.size()
                ));
    }
}