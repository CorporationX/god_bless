package faang.school.godbless.userBehaviorAnalysis;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserActionProcessor {

    public static Map<Integer, Long> top10ActiveUsers(List<UserAction> userActions) {
        return userActions.stream().collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<String, Long> top5HashTags(List<UserAction> userActions) {
        return userActions.stream().flatMap(action -> Stream.of(action.getContent())
                .filter(a -> a.contains("#")))
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<String, Long> top3MonthCommentators(List<UserAction> userActions) {
        return userActions.stream()
                .filter(userAction -> userAction.getActionType() == ActionType.COMMENT)
                .filter(userAction -> userAction.getActionDate().startsWith("2023-06"))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
    }

    public static Map<ActionType, Long> percent(List<UserAction> userActions) {
        //TODO

        return null;
    }
}
