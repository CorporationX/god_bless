package school.faang.task_47258;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    private static final int TOP_ACTIVE_USERS = 10;
    private static final int TOP_POPULAR_HASHTAGS = 5;
    private static final int TOP_USERS_COMMENTS = 3;
    private static final int TO_PERCENTAGE = 100;
    private static final String WHITESPACES_REGEX = "\\s+";


    public static List<String> topActiveUsers(List<UserAction> userActions) {
        validateInputList(userActions);

        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(TOP_ACTIVE_USERS)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> userActions) {
        validateInputList(userActions);

        return userActions.stream()
                .filter(action -> action.getActionType() == ActionType.POST
                        || action.getActionType() == ActionType.COMMENT)
                .flatMap(action -> Arrays.stream(action.getContent().split(WHITESPACES_REGEX)))
                .filter(tag -> tag.startsWith("#"))
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(TOP_POPULAR_HASHTAGS)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> userActions) {
        validateInputList(userActions);

        var oneMonthAgo = LocalDate.now().minusMonths(1);
        return userActions.stream()
                .filter(action -> action.getActionType() == ActionType.COMMENT
                        && action.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(TOP_USERS_COMMENTS)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, String> actionPercentages(List<UserAction> userActions) {
        validateInputList(userActions);

        var allActionCount = (long) userActions.size();
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> getPercentage(entry.getValue(), (double) allActionCount)));
    }

    private static String getPercentage(Long entryValue, double allActionCount) {
        var percentage = Math.round((entryValue / allActionCount) * TO_PERCENTAGE);

        return percentage + "%";
    }

    private static void validateInputList(List<UserAction> userActions) {
        if (userActions == null || userActions.isEmpty()) {
            throw new IllegalArgumentException("Input parameters can't be null or empty!");
        }
    }
}
