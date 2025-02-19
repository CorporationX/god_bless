package school.faang.sprint2.streamapi.useractivityanalysis.bjs2_60330;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<User> findTopActiveUsers(List<UserAction> userActions, long limit) {
        Map<User, Long> userCountMap = userActions.stream()
                .collect(Collectors.groupingBy(action -> new User(action.getId(), action.getName()),
                        Collectors.counting()));
        System.out.println("\n--" + userCountMap);
        return userCountMap.entrySet().stream().sorted(Map.Entry.<User, Long>comparingByValue().reversed())
                .limit(limit).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public static List<String> findTopPopularTopic(List<UserAction> userActions, long limit) {
        Map<String, Long> wordToCount = userActions.stream()
                .filter(action -> action.getContent() != null
                        && ActionType.POST.equals(action.getActionType())
                        || ActionType.COMMENT.equals(action.getActionType()))
                .flatMap(action -> Arrays.stream(action.getContent().split("\\\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return wordToCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
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
                entry -> BigDecimal.valueOf(entry.getValue() * 100.0 / totalUserActions)
                        .setScale(2, RoundingMode.HALF_UP).doubleValue()));
    }
}
