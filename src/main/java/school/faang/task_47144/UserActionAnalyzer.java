package school.faang.task_47144;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions) {
        Map<String, Long> actionsByUserNames = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        return actionsByUserNames.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        Map<String, Long> countHashtags = actions.stream()
                .map(UserAction::getContent)
                .map(s -> s.replaceAll("^\\W+|\\W+$", "")) //убрать все спец. символы
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .filter(s -> s.contains("#"))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        return countHashtags.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(5)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        Map<String, List<UserAction>> actionsByName = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName));

        Map<String, Long> countCommentByNames = actionsByName.entrySet().stream()
                .flatMap(s -> s.getValue().stream())
                .filter(f -> f.getActionType().equals("comment"))
                .filter(f -> !f.getContent().isBlank())
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        return countCommentByNames.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.collectingAndThen(
                                Collectors.counting(), s -> (double) s * 100 / actions.size()))
                );
    }
}