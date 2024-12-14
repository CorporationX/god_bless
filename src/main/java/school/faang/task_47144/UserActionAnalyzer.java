package school.faang.task_47144;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static school.faang.task_47144.ActionType.COMMENT;

public class UserActionAnalyzer {
    private static final String REGEX_FOR_REMOVE_SPECIAL_SYMBOLS = "^\\W+|\\W+$";
    private static final String HASHTAG = "#";
    private static final int TOP_3 = 3;
    private static final int TOP_5 = 5;

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
                .map(s -> s.replaceAll(REGEX_FOR_REMOVE_SPECIAL_SYMBOLS, ""))
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .filter(s -> s.startsWith(HASHTAG))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        return countHashtags.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(TOP_5)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        Map<String, Long> countCommentByNames = actions.stream()
                .filter(f -> f.getActionType().equals(COMMENT.getActionName()))
                .filter(f -> !f.getContent().isBlank())
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        return countCommentByNames.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(TOP_3)
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