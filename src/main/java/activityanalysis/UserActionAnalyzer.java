package activityanalysis;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        return actions.stream()
                .filter(action -> action.getContent().contains("#"))
                .flatMap(action -> Arrays.stream(action.getContent().split("[\\s,;:.!]+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        return actions.stream()
                .filter(action -> action.getActionType().equals("comment")
                        && action.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(
                        UserAction::getName,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / actions.size()
                ));
    }
}
