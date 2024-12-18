package school.faang.task_47226;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions) {
        Map<String, Long> actionsByUser = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        return topItems(actionsByUser, 10L);
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        Map<String, Long> mentionsByHashtag = actions.stream()
                .map(UserAction::getContent)
                .flatMap(content -> Arrays.stream(content.split(" ")))
                .filter(word -> word.startsWith("#"))
                .map(hashtag -> hashtag.replaceAll("\\W*$", ""))
                .collect(Collectors.groupingBy(hashtag -> hashtag, Collectors.counting()));

        return topItems(mentionsByHashtag, 5L);
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        Map<String, Long> commentsByUser = actions.stream()
                .filter(action -> action.getActionType().equals("comment"))
                .filter(action ->
                        action.getActionDate().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        return topItems(commentsByUser, 3L);
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType,
                        collectingAndThen(Collectors.counting(),
                                count -> getRoundedPercentage((double) count / actions.size()))));
    }

    private static List<String> topItems(Map<String, Long> countsByItem, Long topLimit) {
        return countsByItem.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(topLimit)
                .toList();
    }

    private static double getRoundedPercentage(double value) {
        int places = 2;
        double scale = Math.pow(10, places);
        return Math.round(value * scale * 100) / scale;
    }
}
