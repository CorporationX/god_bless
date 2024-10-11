package analysisOfUserActivity_35491;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

//    new UserAction(1, "Alice", "post",LocalDate.of(2024, 9, 1), "Check out this amazing #newfeature!"),
//    new UserAction(2, "Bob", "comment", LocalDate.of(2024, 9, 2), "I totally agree with #newfeature."),
//    new UserAction(1, "Alice", "like", LocalDate.of(2024, 9, 3), ""),
//    new UserAction(3, "Charlie", "share", LocalDate.of(2024, 9, 4), ""),
//    new UserAction(4, "Dave", "post", LocalDate.of(2024, 9, 5), "#Java is awesome!"),
//    new UserAction(2, "Bob", "like", LocalDate.of(2024, 9, 6), ""),


    public static List<String> topActiveUsers(List<UserAction> actions, int limit) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int limit) {
        return null;
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int limit) {
        return null;
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        return null;
    }
}
