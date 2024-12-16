package school.faang.task_47218;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    private static final double PERCENTAGE_MULTIPLIER = 100.0;
    private static final int TOP_ACTIVE_USERS_LIMIT = 10;
    private static final int TOP_HASHTAGS_LIMIT = 5;


    public static List<String> topActiveUsers(List<UserAction> userActions) {

        Map<String, Long> totalUserActions = new HashMap<>();

        Map<String, Long> postUsersCount = getTopUsersByActionCount(userActions, ActionType.POST);
        mergeUserActions(totalUserActions, postUsersCount);

        Map<String, Long> commentUsersCount = getTopUsersByActionCount(userActions, ActionType.COMMENT);
        mergeUserActions(totalUserActions, commentUsersCount);

        Map<String, Long> likeUsersCount = getTopUsersByActionCount(userActions, ActionType.LIKE);
        mergeUserActions(totalUserActions, likeUsersCount);

        Map<String, Long> shareUsersCount = getTopUsersByActionCount(userActions, ActionType.SHARE);
        mergeUserActions(totalUserActions, shareUsersCount);


        return totalUserActions.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(TOP_ACTIVE_USERS_LIMIT)
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }

    private static Map<String, Long> getTopUsersByActionCount(List<UserAction> users, ActionType actionType) {
        if (users.isEmpty()) {
            throw new NoSuchElementException("Список пуст");
        }
        return users.stream()
                .filter(action -> actionType.equals(action.getActionType()))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
    }

    private static void mergeUserActions(Map<String, Long> totalUserActions, Map<String, Long> userActions) {
        userActions.forEach((user, count) ->
                totalUserActions.merge(user, count, Long::sum)
        );
    }

    public static List<String> topPopularHashtags(List<UserAction> userActions) {

        return userActions.stream().map(UserAction::getContent)
                .flatMap(content -> Arrays.stream(content.split("\s+")))
                .filter(string -> string.startsWith("#"))
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()))
                .entrySet().stream()
                .limit(TOP_HASHTAGS_LIMIT)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topCommentersLastMonth(List<UserAction> userActions) {
        var currentYear = LocalDate.now().getYear();
        var maxMonth = userActions.stream()
                .filter(action -> action.getActionDate().getYear() == currentYear)
                .map(action -> action.getActionDate().getMonthValue())
                .max(Integer::compareTo).orElseThrow(() -> new NoSuchElementException("Даты отсутствуют"));

        return userActions.stream()
                .filter(s -> s.getActionDate().getMonthValue() == maxMonth)
                .filter(action -> action.getActionType().equals(ActionType.COMMENT))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> userActions) {
        long totalActions = userActions.size();
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors
                        .toMap(Map.Entry::getKey, entry -> entry.getValue() * PERCENTAGE_MULTIPLIER / totalActions));
    }

}
