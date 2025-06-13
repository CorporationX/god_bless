package school.faang.module1.bjs2_81044;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static school.faang.module1.bjs2_81044.ActionType.COMMENT;
import static school.faang.module1.bjs2_81044.ActionType.POST;

public class UserActionAnalyzer {

    private static final String HASHTAG_CLEANUP_REGEX = "[^#\\w\\s]";
    private static final String SPLIT_REGEX = "\\s+";
    private static final String HASHTAG_PREFIX = "#";
    private static final int MIN_WORD_LENGTH = 2;
    private static final int LAST_MONTHS_INTERVAL = 1;
    private static final double PERCENT_MULTIPLIER = 100.0;
    private static final double ROUNDING_FACTOR = 100.0;

    public static List<String> getTopActiveUsers(List<UserAction> actions, int n) {
        return actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getName,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(n)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> getTopPopularHashtags(List<UserAction> actions, int n) {
        return actions.stream()
                .filter(userAction ->
                        userAction.getActionType().equals(COMMENT) || userAction.getActionType().equals(POST))
                .flatMap(userAction -> extractHashtags(userAction.getContent()).stream())
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(n)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }

    private static List<String> extractHashtags(String content) {
        if (content == null || content.isBlank()) {
            return List.of();
        }
        String cleanedContent = content.replaceAll(HASHTAG_CLEANUP_REGEX, "");
        return Arrays.stream(cleanedContent.split(SPLIT_REGEX))
                .filter(word -> word.startsWith(HASHTAG_PREFIX) && word.length() >= MIN_WORD_LENGTH)
                .collect(Collectors.toList());
    }

    public static List<String> getTopCommentersLastMonth(List<UserAction> actions, int n) {
        return actions.stream()
                .filter(userAction -> userAction.getActionType().equals(COMMENT))
                .filter(userAction ->
                        userAction.getActionDate().isAfter(LocalDate.now().minusMonths(LAST_MONTHS_INTERVAL)))
                .collect(Collectors.groupingBy(
                        UserAction::getName,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(n)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<ActionType, Double> getActionTypePercentages(List<UserAction> actions) {
        long totalCountOfActions = actions.size();
        if (totalCountOfActions == 0) {
            return Collections.emptyMap();
        }
        return actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> roundToTwoDecimalPlaces(entry.getValue() * PERCENT_MULTIPLIER / totalCountOfActions)
                ));
    }

    private static double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * ROUNDING_FACTOR) / ROUNDING_FACTOR;
    }
}