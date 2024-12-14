package school.faang.sprint2.bjs_47270;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> userActions) {
        Map<String, Long> users = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()));

        return users.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<String> topPopularHashtags(List<UserAction> userActions) {
        return userActions.stream();
    }
}
