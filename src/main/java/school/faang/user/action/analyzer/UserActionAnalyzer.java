package school.faang.user.action.analyzer;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static final int MAX_TOP_ACTIVE_USERS = 10;
    public static final int MAX_TOP_POPULAR_HASHTAG = 5;
    public static final int MAX_TOP_COMMENTS = 3;

    public static List<String> topActiveUsers(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(MAX_TOP_ACTIVE_USERS)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        return actions.stream()
                .map(UserAction::getContent)
                .flatMap(content -> Arrays.stream(content.split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .map(word -> word.replaceAll("\\W", ""))
                .collect(Collectors.groupingBy(
                        hashtag -> hashtag,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .limit(MAX_TOP_POPULAR_HASHTAG)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        return actions.stream()
                .filter(action -> action.getActionDate().isAfter(LocalDate.now().minusMonths(1)))
                .filter(action -> ActionType.COMMENT.equals(action.getActionType()))
                .collect(Collectors.groupingBy(
                        UserAction::getName,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .limit(MAX_TOP_COMMENTS)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (double) ((entry.getValue() * 100) / actions.size())
                ));
    }
}
