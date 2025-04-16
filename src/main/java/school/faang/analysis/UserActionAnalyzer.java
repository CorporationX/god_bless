package school.faang.analysis;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions, int n) {
        Map<Integer, String> userIdToName = buildMapIdToName(actions);

        return actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getUserId,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(n)
                .map(entry -> userIdToName.get(entry.getKey()))
                .toList();
    }

    private static Map<Integer, String> buildMapIdToName(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.toMap(
                        UserAction::getUserId,
                        UserAction::getUserName,
                        (existing, replacement) -> existing
                ));
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int n) {
        return actions.stream()
                .filter(a -> a.getActionType() == ActionType.POST || a.getActionType() == ActionType.COMMENT)
                .flatMap(a -> extractHashtags(a.getContent()).stream())
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    private static List<String> extractHashtags(String content) {
        return Arrays.stream(content.split("\\s+"))
                .filter(word -> word.startsWith("#"))
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int n) {
        Map<Integer, String> userIdToName = buildMapIdToName(actions);

        return actions.stream()
                .filter(a -> a.getActionType() == ActionType.COMMENT)
                .filter(a -> a.getActionDate().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(
                        UserAction::getUserId,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(n)
                .map(entry -> userIdToName.get(entry.getKey()))
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        long totalActions = actions.size();

        return actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        e -> e.getKey().toString(),
                        e -> (double) e.getValue() / totalActions * 100
                ));
    }
}
