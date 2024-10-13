package faang.school.godbless.streamapi.analyze;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    private UserActionAnalyzer() {
    }

    public static List<String> topActiveUsers(List<UserAction> actions) {

        var map = actions.stream()
                .collect(Collectors.groupingBy(a -> a, Collectors.counting()));

        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting())).entrySet().stream()
                .sorted(((o1, o2) -> Long.compare(o2.getValue(), o1.getValue())))
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();

    }

    public static List<String> topPopularHashtags (List<UserAction> actions) {
        return actions.stream()
                .filter(a-> "post".equals(a.getActionType()) || "comment".equals(a.getActionType()))
                .flatMap(s -> Arrays.stream(s.getContent().split("[^a-zA-Z#]+"))) // Разделение на слова
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(a -> a, Collectors.counting())).entrySet().stream()
                .sorted(((o1, o2) -> Long.compare(o2.getValue(), o1.getValue())))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth (List<UserAction> actions) {
        return actions.stream()
                .filter(a-> "comment".equals(a.getActionType()))
                .map(UserAction::getName)
                .collect(Collectors.groupingBy(a -> a, Collectors.counting())).entrySet().stream()
                .sorted(((o1, o2) -> Long.compare(o2.getValue(), o1.getValue())))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages (List<UserAction> actions) {
        return actions.stream()
                .map(UserAction::getActionType)
                .collect(Collectors.groupingBy(a -> a, Collectors.counting())).entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue() * 100.0 / actions.size()));
    }

}
