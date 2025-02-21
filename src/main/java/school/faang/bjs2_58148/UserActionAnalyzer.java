package school.faang.bjs2_58148;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions, int count) {
        Map<String, Long> usersToActionsCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return usersToActionsCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(count)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int count) {
        Map<String, Long> hashtagsCount = actions.stream()
                .filter(action -> action.getActionType().equals(ActionType.POST)
                        || action.getActionType().equals(ActionType.COMMENT))
                .flatMap(action -> Arrays.stream(action.getContent().split(" ")))
                .filter(s -> s.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return null;
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int count) {
        return null;
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        return null;
    }

}
