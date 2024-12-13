package school.faang.bjs_47153;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions) {
        Map<UserAction, Integer> users = new HashMap<>();

        actions.forEach(action -> {
            Integer count = users.computeIfPresent(action, (k,v) -> v++);
            if (count == null) {
                users.put(action, 1);
            }
        });

        return users.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(10)
                .map(entry -> entry.getKey().getUserName())
                .toList();
    }
}
