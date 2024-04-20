package faang.school.godbless.analysis_active;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer  {
    public static List<Integer> findTop10MostActiveUsers(List<UserAction> userActions) {
        Map<Integer, Long> userActivityMap = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()));
        return userActivityMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> findTop5PopularTopics(List<String> posts, List<String> comments) {
        Map<String, Long> hashtagCounts = posts.stream()
                .flatMap(post -> extractHashtags(post).stream())
                .collect(Collectors.groupingBy(h -> h, Collectors.counting()));
        comments.stream()
                .flatMap(comment -> extractHashtags(comment).stream())
                .collect(Collectors.groupingBy(h -> h, Collectors.counting()))
                .forEach((hashtag, count) -> hashtagCounts.merge(hashtag, count, Long::sum));
        return hashtagCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> extractHashtags(String text) {
        return List.of(text.split("\\s+")).stream()
                .filter(word -> word.startsWith("#"))
                .map(word -> word.replaceAll("[^а-яА-Яa-zA-Z0-9]", ""))
                .collect(Collectors.toList());
    }

    public static List<String> findTop3UsersWithMostCommentsLastMonth(List<UserAction> userActions) {
        LocalDate lastMonth = LocalDate.now().minusMonths(1);
        Map<Integer, Long> userCommentCounts = userActions.stream()
                .filter(action -> action.getActionType() == ActionType.COMMENT)
                .filter(action -> action.getActionDate().isAfter(lastMonth))
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()));
        return userCommentCounts.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(3)
                .map(entry -> "id: " + entry.getKey() + ", количество комментариев: " + entry.getValue())
                .collect(Collectors.toList());
    }

    public static Map<ActionType, Double> calculateActionTypePercentages(List<UserAction> userActions) {
        Map<ActionType, Long> actionTypeCounts = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));
        long totalActions = actionTypeCounts.values().stream().mapToLong(Long::longValue).sum();
        Map<ActionType, Double> actionTypePercent = new HashMap<>();
        actionTypeCounts.forEach((actionType, count) ->
                actionTypePercent.put(actionType, (count * 100.0) / totalActions));
        return actionTypePercent;
    }
}
