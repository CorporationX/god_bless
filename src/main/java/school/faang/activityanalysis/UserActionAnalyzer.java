package school.faang.activityanalysis;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions, int count) {
        Map<String, List<UserAction>> groupByUsers = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName));
        return groupByUsers.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> -entry.getValue().size()))
                .limit(count)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int count) {
        List<String> hashtags = actions.stream()
                .map(UserAction::getContent)
                .filter(content -> content.contains("#"))
                .map(content -> {
                    int startIndex = content.indexOf('#');
                    int endIndex = content.indexOf(' ', startIndex);
                    if (endIndex == -1) {
                        endIndex = content.length();
                    }
                    return content.substring(startIndex, endIndex).replaceAll("[^a-zA-Z]", "");
                }).toList();
        List<String> hashtagsCopy = new ArrayList<>(hashtags);
        Map<String, Integer> hashtagsUnique = hashtagsCopy.stream().distinct()
                .collect(Collectors.toMap(hashtag -> hashtag, hashtag -> Collections.frequency(hashtags, hashtag)));
        return hashtagsUnique.entrySet().stream().sorted((entry1, entry2) -> entry2.getValue() - entry1.getValue())
                .map(Map.Entry::getKey).limit(count).toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int count) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        Map<String, List<UserAction>> groupingUsers = actions.stream().filter(userAction -> userAction.getActionType().equals(ActionType.COMMENT))
                .filter(userAction -> (userAction.getActionDate().isAfter(oneMonthAgo)))
                .collect(Collectors.groupingBy(UserAction::getName));

        return groupingUsers.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> -entry.getValue().size()))
                .limit(count)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        int sizeActions = actions.size();

        Map<ActionType, List<UserAction>> groupingActionType = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType));

        return groupingActionType.entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey().toString(),
                        entry -> (entry.getValue().size() * 100.0) / sizeActions));
    }
}
