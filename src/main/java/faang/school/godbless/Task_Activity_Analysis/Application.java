package faang.school.godbless.Task_Activity_Analysis;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
public class Application {

    public static List<Integer> findTheMostActiveUsers(List<UserAction> userActions) {
        Map<Integer, Integer> namesAndActions = new HashMap<>();
        userActions.forEach(x -> {
            int numberOfActions = (int) userActions.stream().filter(y -> y.getId() == x.getId()).count();
            namesAndActions.put(x.getId(), numberOfActions);
        });
        return namesAndActions.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).limit(10)
                .map(Map.Entry::getKey).toList();
    }

    public static List<String> findPopularTopics(List<UserAction> userActions) {
        Map<String, Integer> hashtagStats = new HashMap<>();
        List<String> hashtags = userActions.stream().map(UserAction::getContent).
                filter(x -> x.startsWith("#")).toList();
        hashtags.forEach(x -> {
            int quantity = (int) hashtags.stream().filter(y -> y.equals(x)).count();
            hashtagStats.put(x, quantity);
        });
        return hashtagStats.entrySet().stream().
                sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).
                limit(5).map(Map.Entry::getKey).toList();
    }

}
