package school.faang.task58120;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    private static final Pattern HASHTAG_TEXT = Pattern.compile("#\\w+");

    public static List<String> topActiveUsers(@NonNull List<UserAction> userActions, int topNumber) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topNumber)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(@NonNull List<UserAction> userActions, int topNumber) {
        Map<String, Long> map = userActions.stream()
                .map(UserAction::getContent)
                .flatMap(string -> extractHashtags(string).stream())
                .collect(Collectors.groupingBy(string -> string, Collectors.counting()));
        return reverseLimitSortValues(map, topNumber);
    }

    public static List<String> topCommentersLastMonth(@NonNull List<UserAction> userActions, int topNumber) {
        Map<String, Long> map = userActions.stream()
                .filter(userAction ->
                        userAction.getActionDate().isAfter(LocalDate.now().minusMonths(1))
                        && userAction.getActionType().equals(ActionType.COMMENT))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return reverseLimitSortValues(map, topNumber);
    }

    public static Map<ActionType, Double> actionTypePercentages(@NonNull List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> getPercent((double) (entry.getValue() * 100) / userActions.size())));
    }

    private static List<String> reverseLimitSortValues(Map<String, Long> map, int topNumber) {
        return map.entrySet().stream()
                .filter(Objects::nonNull)
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topNumber)
                .map(Map.Entry::getKey)
                .toList();
    }

    private static Double getPercent(double value) {
        value = Math.round(value * 100);
        return value / 100;
    }

    private static List<String> extractHashtags(String content) {
        List<String> hashtags = new ArrayList<>();
        Matcher matcher = HASHTAG_TEXT.matcher(content);
        while (matcher.find()) {
            hashtags.add(matcher.group());
        }
        return hashtags;
    }
}
