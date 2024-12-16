package school.faang.sprint_2.task_47227;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> userActions) {
        String hashtags = "#";
        return userActions.stream()
                .filter(a -> a.content() != null && a.actionType().equals("post") || a.actionType().equals("comment"))
                .flatMap(a -> Arrays.stream(Objects.requireNonNull(a.content()).split("\\\\\\\\s+")))
                .filter(w -> w.startsWith(hashtags))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> userActions) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        return userActions.stream()
                .filter(a -> a.actionType().equals("comment") && a.actionDate().isBefore(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Long> actionTypePercentages(List<UserAction> userActions) {
        long totalActions = userActions.size();
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100) / totalActions
                ));
    }
}