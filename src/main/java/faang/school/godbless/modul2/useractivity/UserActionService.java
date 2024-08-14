package faang.school.godbless.modul2.useractivity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class UserActionService {
    private final static int LIMIT_FOR_TOP_10 = 10;
    private final static int LIMIT_FOR_TOP_5 = 5;
    private final static int LIMIT_FOR_TOP_3 = 3;
    private final static double SCALE_FACTOR = 10_000.0;
    private final static double DIVISOR = 100.0;

    //1.
    public List<String> getTop10ActiveUsers(List<UserAction> userActions) {
        var userActionsMap = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()));

        return convertMapToStringList(userActionsMap, LIMIT_FOR_TOP_10);
    }

    //2.
    public List<String> getTop5Topic(List<UserAction> userActions) {
        var topicsMap = userActions.stream()
                .map(UserAction::getContent)
                .map(String::toLowerCase)
                .flatMap(content -> Arrays.stream(content.split("[\\s,.!?;:()]+")))
                .filter(word -> word.matches("#.*"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return convertMapToStringList(topicsMap, LIMIT_FOR_TOP_5);
    }

    //3.
    public List<String> getTop3ActiveCommentators(List<UserAction> userActions) {
        var commentatorsMap = userActions.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.COMMENT))
                .filter(userAction -> userAction.getActionDate().getMonth().equals(LocalDateTime.now().getMonth()))
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()));

        return convertMapToStringList(commentatorsMap, LIMIT_FOR_TOP_3);
    }

    //4.
    public Map<ActionType, Double> getAnalytics(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> Math.round(entry.getValue() * SCALE_FACTOR / userActions.size()) / DIVISOR
                ));
    }


    private List<String> convertMapToStringList(Map<String, Long> userActionsMap, int limit) {
        return userActionsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    //ActiveUsersInfo
    public void printActiveUsersInfo(List<UserAction> userActions) {
        System.out.println("ActiveUsers info: ");
        userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserName,
                        Collectors.groupingBy(UserAction::getActionType, Collectors.counting())))
                .entrySet().stream()
                .sorted((e1, e2) -> Long.compare(
                        e2.getValue().values().stream().mapToLong(Long::longValue).sum(),
                        e1.getValue().values().stream().mapToLong(Long::longValue).sum()))
                .forEach(entry -> {
                    String userName = entry.getKey();
                    Map<ActionType, Long> actions = entry.getValue();
                    var totalActions = actions.values().stream().mapToLong(Long::longValue).sum();
                    var actionDetails = actions.entrySet().stream()
                            .map(actionEntry -> actionEntry.getKey() + ":" + actionEntry.getValue())
                            .collect(Collectors.joining(", "));
                    System.out.println("  " + userName + ": " + totalActions + " actions = " + actionDetails);
                });
    }
}
