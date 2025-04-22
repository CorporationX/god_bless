package useractivityanalytics;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions, int n) {
        return actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getName,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int n) {
        return actions.stream()
                .map(UserAction::getContent)
                .filter(Objects::nonNull)
                .flatMap(content -> Arrays.stream(content.split("\\s+")))
                .filter(word -> word.startsWith("#") && word.length() > 1)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int n) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);

        return actions.stream()
                .filter(a -> a.getActionType() == ActionType.COMMENT)
                .filter(a -> a.getActionDate() != null
                        && !a.getActionDate().isBefore(oneMonthAgo))
                .collect(Collectors.groupingBy(
                        UserAction::getName,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> calculateActionTypePercentages(List<UserAction> actions) {
        long total = actions.size();

        return actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / total
                ));
    }
}
