package school.faang.UserActivity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions) {
        return actions.stream().collect(Collectors.groupingBy(UserAction::getName))
                .entrySet().stream().sorted((o1, o2) -> -Integer.compare(o2.getValue().size(), o1.getValue().size()))
                .limit(10).map(Map.Entry::getKey).toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        return actions.stream().filter(e -> e.getActionType().equals("post") || e.getActionType().equals("comment"))
                .flatMap(e -> Arrays.stream(e.getContent().split("\\s+")))
                .filter(e -> e.startsWith("#"))
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream().sorted((o1, o2) -> -Long.compare(o1.getValue(), o2.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        return actions.stream().filter(e -> e.getActionDate().isAfter(oneMonthAgo) && e.getActionType().equals("comment"))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted((o1, o2) -> -Long.compare(o1.getValue(), o2.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        long total = actions.size();
        return actions.stream().collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> (double) entry.getValue() / total * 100));
    }
}
