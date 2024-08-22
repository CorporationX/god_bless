package streamapi.three;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static List<Integer> findMostActiveUsers(List<UserAction> userActions, int top) {
        Map<Integer, Long> userActionsCount = userActions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getUserId,
                        Collectors.counting()
                ));

        return userActionsCount.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(top)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> findMostPopularHashtags(List<UserAction> userActions, int top) {

        Map<String, Long> popularHashtagMap = userActions.stream()
                .filter(action -> ActionType.POST == action.getActionType() || ActionType.COMMENT == action.getActionType())
                .flatMap(action -> Arrays.stream(action.getContent().split("\\s+"))
                        .filter(word -> word.startsWith("#")))
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        return popularHashtagMap
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(top)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<Integer> findMostActiveUsersForThreeMonths(List<UserAction> userActions, int top) {
        LocalDateTime oneMonthsAgo = LocalDateTime.now().minusMonths(1);

        Map<Integer, Long> userActionsMap = userActions.stream()
                .filter(action -> action.getActionType() == ActionType.COMMENT)
                .filter(action -> oneMonthsAgo.isAfter(action.getActionDate()))
                .collect(Collectors.groupingBy(UserAction::getUserId,
                        Collectors.counting()));

        return userActionsMap
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(top)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<ActionType, Double> getPercentageOfActionTypes(List<UserAction> userActions) {
        Map<ActionType, Long> actionTypeLongMap = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType,
                        Collectors.counting()));

        return actionTypeLongMap
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        action -> 100.0 * action.getValue() / userActions.size()
                ));
    }
}
