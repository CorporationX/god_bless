package school.faang.task_47218;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> userActions) {

        Map<String, Long> totalUserActions = new HashMap<>();

        Map<String, Long> postUsersCount =
                getTopUsersByActionCount(userActions, "post");
        Map<String, Long> commentUsersCount =
                getTopUsersByActionCount(userActions, "comment");
        Map<String, Long> likeUsersCount =
                getTopUsersByActionCount(userActions, "like");
        Map<String, Long> shareUsersCount =
                getTopUsersByActionCount(userActions, "share");

        mergeUserActions(totalUserActions, postUsersCount);
        mergeUserActions(totalUserActions, commentUsersCount);
        mergeUserActions(totalUserActions, likeUsersCount);
        mergeUserActions(totalUserActions, shareUsersCount);


        return totalUserActions.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(10)
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }

    private static Map<String, Long> getTopUsersByActionCount(List<UserAction> users, String actionType) {
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
                .flatMap(content -> Arrays.stream(content.split(" ")))
                .filter(string -> string.startsWith("#"))
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()))
                .entrySet().stream()
                .limit(5)
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
                .filter(action -> action.getActionType().equals("comment"))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> userActions) {
        long totalActions = userActions.size();
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue() * 100.0 / totalActions));
    }

}
