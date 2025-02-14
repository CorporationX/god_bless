package school.faang.useractivityanalysis;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    private static final LocalDate ONE_MONTH_FROM_NOW = LocalDate.now().minusMonths(1);
    private static final double ONE_HUNDRED = 100.0;
    private static final String HASHTAG_SIGN = "#";
    private static final String WHITESPACES = "\\s+";
    private static final int ZERO = 0;

    public static List<String> topActiveUsers(@NonNull List<UserAction> actions, int limit) {
        if (validateData(actions, limit)) {
            return Collections.emptyList();
        }

        return actions
                .stream()
                .collect(Collectors.groupingBy(
                        UserAction::getName,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(@NonNull List<UserAction> actions, int limit) {
        if (validateData(actions, limit)) {
            return Collections.emptyList();
        }

        return actions
                .stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.POST)
                        || userAction.getActionType().equals(ActionType.COMMENT))
                .flatMap(userAction ->
                        Arrays.stream(getHashtags(userAction.getContent())))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(@NonNull List<UserAction> actions, int limit) {
        if (validateData(actions, limit)) {
            return Collections.emptyList();
        }

        return actions
                .stream()
                .filter(action -> action.getActionType().equals(ActionType.COMMENT)
                        && action.getActionDate().isAfter(ONE_MONTH_FROM_NOW))
                .collect(Collectors.groupingBy(
                        UserAction::getName,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<String, Double> actionTypePercentages(@NonNull List<UserAction> actions) {
        if (actions.isEmpty()) {
            return Collections.emptyMap();
        }

        Map<ActionType, Long> counts = actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.counting()
                ));

        long totalSize = actions.size();

        return counts
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        e -> e.getKey().name(),
                        e -> (e.getValue() * ONE_HUNDRED) / totalSize));
    }

    private static String[] getHashtags(String content) {
        if (content == null || content.isEmpty()) {
            return new String[ZERO];
        }

        return Arrays.stream(content.split(WHITESPACES))
                .filter(word -> word.startsWith(HASHTAG_SIGN))
                .toArray(String[]::new);
    }

    private static boolean validateData(List<UserAction> actions, int limit) {
        return actions.isEmpty() || limit < 0;
    }
}
