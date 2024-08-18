package faang.school.godbless.BJS222551;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static List<Long> findTop10ActiveUsers(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .limit(10)
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> findTop5PopularTopics(List<UserAction> userActions) {
        return userActions.stream()
                .filter(userAction ->
                        (userAction.getActionType() == ActionType.POST || userAction.getActionType() == ActionType.COMMENT)
                                && userAction.getContent().contains("#"))
                .flatMap(userAction -> Arrays.stream(userAction.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }


    public static List<Long> findTop3CommentersLastMonth(List<UserAction> userActions) {
        LocalDateTime oneMonthAgo = LocalDateTime.now().minusMonths(1);

        return userActions.stream()
                .filter(userAction -> userAction.getActionType() == ActionType.COMMENT
                        && userAction.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> calculateActionTypePercentage(List<UserAction> userActions) {
        long totalActions = userActions.size();

        return userActions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / totalActions
                ));
    }

}
