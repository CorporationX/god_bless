package school.faang.useractivity;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions) {
        Map<String, Long> userActivities = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        return userActivities.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry::getKey))
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        Map<String, Long> hashTagCount =
                actions.stream()
                        .filter(a -> (a.getContent() != null && !a.getContent().isEmpty()))
                        .flatMap(a -> Stream.of(a.getContent().split("[^#^\\w]+")))
                        .filter(w -> w.startsWith("#"))
                        .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        return hashTagCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        Map<String, Long> usersWithRecentComments = actions.stream()
                .filter(a -> (a).getActionType().equalsIgnoreCase("comment") && a.getActionDate().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        return usersWithRecentComments.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey).toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        Map<String, Long> actionCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        return actionCount.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (e.getValue() * 100.0) / actions.size()));
    }
}
