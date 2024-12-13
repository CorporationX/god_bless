package school.faang.bjs_47153;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions) {
        Map<Integer, Integer> users = new HashMap<>();

        actions.forEach(action -> {
            users.computeIfAbsent(action.getUserId(), k -> 0);
            users.compute(action.getUserId(), (k, count) -> count + 1);

        });


        return users.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(10)
                .map(Map.Entry::getKey)
                .map(id -> actions.stream()
                        .filter(action -> id.equals(action.getUserId()))
                        .findAny()
                        .orElseThrow().getUserName()
                )
                .toList();
    }
}
