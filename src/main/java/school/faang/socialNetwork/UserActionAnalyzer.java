package school.faang.socialNetwork;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    private static final int PERCENTAGE_VALUE = 100;

    public static List<String> getTopTenActiveUsers(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();

    }

    public static List<String> getTopFivePopularTopics(List<UserAction> userActions) {
        return userActions.stream()
                .filter(action -> action.getActionType().equals("comment") || action.getActionType().equals("post"))
                .flatMap(action -> Arrays.stream(action.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getTopThreeCommentatorsLastMonth(List<UserAction> userActions) {
        LocalDate oneMonth = LocalDate.now().minusMonths(1);
        return userActions.stream()
                .filter(action -> action.getActionType().equals("comment") && action.getActionDate().isAfter(oneMonth))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> getPercentageOfActions(List<UserAction> userActions) {
        long actionCount = userActions.size();
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> (double) entry.getValue() / actionCount * PERCENTAGE_VALUE));
    }

}
