package school.faang.bjs2_88260;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions, int n) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int n) {
        return actions.stream()
                .flatMap(a -> Arrays.stream(a.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .map(word -> word.replaceAll("\\W+$", ""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int n) {
        LocalDate lastDate = actions.stream()
                .map(UserAction::getActionDate)
                .max(LocalDate::compareTo)
                .orElse(LocalDate.now());

        LocalDate fromDate = lastDate.minusDays(30);

        return actions.stream()
                .filter(a -> a.getType() == ActionType.COMMENT)
                .filter(a -> !a.getActionDate().isBefore(fromDate) && !a.getActionDate().isAfter(lastDate))
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(n)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        double totalActions = actions.size();

        return actions.stream()
                .collect(Collectors.groupingBy(a -> a.getType().name(), Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> Math.round(e.getValue() * 1000.0 / totalActions) / 10.0
                ));

    }
}