package school.faang.task_47144;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static school.faang.task_47144.ActionType.COMMENT;

public class UserActionAnalyzer {
    private static final String SPECIAL_SYMBOLS_REGEX = "^\\W+|\\W+$";
    private static final String HASHTAG = "#";

    public static List<String> topActiveUsers(List<UserAction> actions) {
        Map<String, Long> actionsByUserNames = actions.stream()
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()));

        return actionsByUserNames.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int topPopularHashtags) {
        Map<String, Long> countHashtags = actions.stream()
                .map(UserAction::content)
                .map(s -> s.replaceAll(SPECIAL_SYMBOLS_REGEX, ""))
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .filter(s -> s.startsWith(HASHTAG))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        return countHashtags.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(topPopularHashtags)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int topPopularComments) {
        Map<String, Long> countCommentByNames = actions.stream()
                .filter(f -> f.actionType().equals(COMMENT))
                .filter(f -> !f.content().isBlank())
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()));

        return countCommentByNames.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(topPopularComments)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::actionType,
                        Collectors.collectingAndThen(
                                Collectors.counting(), s -> (double) s * 100 / actions.size()))
                );
    }
}