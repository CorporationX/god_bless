package school.faang.analyzeactivity;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    private static final Pattern PATTERN_FIND_HASHTAG = Pattern.compile("#\\w+");
    private static final int MONTHS_TO_SUBTRACT = 1;

    public static List<String> topActiveUsers(List<UserAction> userActions, int limit) {
        validateList(userActions);
        validateLimit(limit);
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey).limit(limit).toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> userActions, int limit) {
        validateList(userActions);
        validateLimit(limit);
        return userActions.stream().map(UserAction::getContent).map(PATTERN_FIND_HASHTAG::matcher)
                .filter(Matcher::find).map(Matcher::group)
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey).limit(limit).toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> userActions, int limit) {
        validateList(userActions);
        validateLimit(limit);
        return userActions.stream()
                .filter(element -> element.getActionType() == ActionType.COMMENT
                        && element.getActionDate().isAfter(LocalDate.now().minusMonths(MONTHS_TO_SUBTRACT)))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey).limit(limit).toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> userActions) {
        validateList(userActions);
        return userActions.stream().collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream().collect(Collectors.toMap(
                        key -> String.valueOf(key.getKey()),
                        value -> executePercent(value.getValue(), userActions.size())));
    }

    private static double executePercent(long value, int count) {
        return (double) value / count * 100;
    }

    private static void validateList(List<UserAction> userActions) {
        Objects.requireNonNull(userActions, "Invalid value for list");
        if (userActions.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
    }

    private static void validateLimit(int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException("Limit must be greater than 0");
        }
    }
}
