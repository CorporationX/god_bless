package school.faang.sprint2.bjs_47270;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
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

    public static List<String> topPopularHashtags(List<UserAction> userActions) {
        Map<String, Long> hashtags = userActions.stream()
                .filter(x -> x.content() != null && x.actionType().equals("post") || x.actionType().equals("comment"))
                .flatMap(x -> Arrays.stream(x.content().split("[ ,.;!]+")))
                .filter(x -> x.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return hashtags.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topCommentersLastMonth(List<UserAction> userActions) {
        LocalDate lastMonth = LocalDate.now().minusMonths(1);

        Map<String, Long> users = userActions.stream()
                .filter(x -> x.actionType().equals("comment") && x.actionDate().isAfter(lastMonth))
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()));

        return users.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> userActions) {
        Map<String, Long> actionTypes = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()));

        int generalSumActionTypes = actionTypes.values().stream()
                .mapToInt(Long::intValue)
                .sum();

        return actionTypes.entrySet().stream()
                .collect(Collectors.toMap(
                        k -> k.getKey(),
                        v -> (v.getValue() * 100.0 / generalSumActionTypes)
                ));
    }
}
