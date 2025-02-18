package school.faang.sprint2.streamapi.useractivityanalysis.bjs2_60330;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<User> findTopActiveUsers(List<UserAction> userActions, long limit) {
        Map<User, Long> userCountMap = userActions.stream()
                .collect(Collectors.groupingBy(action -> new User(action.getId(), action.getName()),
                        Collectors.counting()));
        return userCountMap.entrySet().stream().sorted(Map.Entry.<User, Long>comparingByValue().reversed())
                .limit(limit).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public static List<String> findTopPopularTopic(List<UserAction> userActions, long limit) {
        return userActions.stream().filter(action -> action.getContent().startsWith("#"))
                .map(action -> action.getContent().substring(1, action.getContent().indexOf(" ")))
                .collect(Collectors.toList());
    }

    public static List<User> findTopUsersWithMaxCountComments(List<UserAction> userActions, long limit) {
        Map<User, Long> maxCountCommentsMap = userActions.stream().collect(Collectors.groupingBy(action ->
                new User(action.getId(), action.getName()), Collectors.counting()));
        return maxCountCommentsMap.entrySet().stream().limit(limit).map(Map.Entry::getKey).toList();
    }

    public static Map<ActionType, Double> findActionTypePercent(List<UserAction> userActions) {
        Map<ActionType, Long> tempMap = userActions.stream().collect(Collectors
                .groupingBy(UserAction::getActionType, Collectors.counting()));
        long totalUserActions = userActions.size();
        return tempMap.entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey(),
                entry -> entry.getValue().doubleValue() * 100 / totalUserActions));
    }
}
