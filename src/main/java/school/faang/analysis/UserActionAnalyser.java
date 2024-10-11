package school.faang.analysis;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyser {
    public static List<String> findTopTenActiveUsers(List<UserAction> usersActions) {
        return usersActions.stream()
                .collect(Collectors
                        .groupingBy((UserAction::getName), Collectors.counting())).entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> findTopFiveTopics(List<UserAction> usersActions) {
        return usersActions.stream()
                .filter(user -> user.getActionType().equals("post") || user.getActionType().equals("comment"))
                .flatMap(user -> Arrays.stream(user.getContent().split("[ .!?,]")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors
                        .groupingBy(word -> word, Collectors.counting())).entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> findTopThreeUsersByComments(List<UserAction> usersActions) {
        return usersActions.stream()
                .filter(user -> user.getActionType().equals("comment")
                        && user.getContent() != null
                        && user.getActionDate().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors
                        .groupingBy((UserAction::getName), Collectors.counting())).entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Long> calculateActionsPercentages(List<UserAction> usersActions) {
        return usersActions.stream()
                .collect(Collectors
                        .groupingBy((UserAction::getActionType), Collectors.counting())).entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors
                        .toMap(Map.Entry::getKey, (entry) -> (entry.getValue() * 100) / usersActions.size()));
    }
}
