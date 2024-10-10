package school.faang.analyze_users_activity_BJS2_35381;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> userActions) {
        int limitSize = 10;
        int firstIndex = 0;
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getId))
                .entrySet().stream()
                .sorted(Comparator.comparingInt(o -> o.getValue().size()))
                .limit(limitSize)
                .map(entry -> entry.getValue().get(firstIndex).getName())
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> userActions) {
        int limitSize = 5;
        String regex = "\\s+";
        return userActions.stream()
                .filter(userAction -> userAction.getActionType().equals("post")
                        || userAction.getActionType().equals("comment"))
                .flatMap(action -> Arrays.stream(action.getContent().split(regex)))
                .filter(str -> str.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .limit(limitSize)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> userActions) {
        int limitSize = 3;
        return userActions.stream()
                .filter(userAction -> userAction.getActionType().equals("post"))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted((Map.Entry.<String, Long>comparingByValue().reversed()))
                .map(Map.Entry::getKey)
                .limit(limitSize)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> userActions) {
        double percents = 100.0;
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (e.getValue() * percents) / userActions.size()));
    }

}
