package faang.school.godbless.user_activity_analysis;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(findTopUsersByActions(getUserActions(), 10));
        System.out.println(findTopFiveTopics(getUserActions()));
        System.out.println(findTopThreeUsersByCountCommentedLastMonth(getUserActions()));
        System.out.println(getStatisticsForUserActions(getUserActions()));
    }

    public static List<Integer> findTopUsersByActions(List<UserAction> actions, int count) {
        Map<Integer, List<UserAction>> map = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId));
        return map.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size())
                .map(Map.Entry::getKey)
                .limit(count)
                .toList();
    }

    public static List<String> findTopFiveTopics(List<UserAction> actions) {
        Map<String, Long> map = actions.stream()
                .filter(action -> action.getActionType().equals(ActionType.COMMENT)
                        || action.getActionType().equals(ActionType.POST))
                .flatMap(action -> Arrays.stream(action.getContent().split(" ")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<Integer> findTopThreeUsersByCountCommentedLastMonth(List<UserAction> actions) {
        List<UserAction> filteredActions = actions.stream()
                .filter(action -> action.getActionDate().isAfter(LocalDateTime.now().minusMonths(1)))
                .toList();
        return findTopUsersByActions(filteredActions, 3);
    }

    public static Map<ActionType, Double> getStatisticsForUserActions(List<UserAction> actions) {
        int totalActions = actions.size();
        return actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.collectingAndThen(Collectors.counting(), value -> (double) value / totalActions * 100))
                );
    }

    private static List<UserAction> getUserActions() {
        return List.of(
                new UserAction(1, "test1", ActionType.SHARE, LocalDateTime.now(), "#test1"),
                new UserAction(2, "test1", ActionType.COMMENT, LocalDateTime.now(), "test1"),
                new UserAction(3, "test1", ActionType.SHARE, LocalDateTime.now(), "test1"),
                new UserAction(4, "test1", ActionType.SHARE, LocalDateTime.now(), "test1"),
                new UserAction(5, "test1", ActionType.COMMENT, LocalDateTime.now(), "test1"),
                new UserAction(6, "test1", ActionType.SHARE, LocalDateTime.now(), "#test1"),
                new UserAction(7, "test1", ActionType.LIKE, LocalDateTime.now(), "test1"),
                new UserAction(8, "test1", ActionType.LIKE, LocalDateTime.now(), "test1"),
                new UserAction(9, "test1", ActionType.LIKE, LocalDateTime.now(), "#test2"),
                new UserAction(10, "test1", ActionType.COMMENT, LocalDateTime.now(), "test1"),
                new UserAction(1, "test1", ActionType.COMMENT, LocalDateTime.now(), "test1"),
                new UserAction(21, "test1", ActionType.COMMENT, LocalDateTime.now(), "#test3"),
                new UserAction(1, "test1", ActionType.LIKE, LocalDateTime.now(), "#test4"),
                new UserAction(22, "test1", ActionType.COMMENT, LocalDateTime.now(), "#test5"),
                new UserAction(3, "test1", ActionType.LIKE, LocalDateTime.now(), "test1"),
                new UserAction(41, "test1", ActionType.POST, LocalDateTime.now(), "test1"),
                new UserAction(3, "test1", ActionType.POST, LocalDateTime.now(), "#test6"),
                new UserAction(4, "test1", ActionType.COMMENT, LocalDateTime.now(), "#test6"),
                new UserAction(6, "test1", ActionType.POST, LocalDateTime.now(), "test1"),
                new UserAction(72, "test1", ActionType.POST, LocalDateTime.now(), "test1"),
                new UserAction(10, "test1", ActionType.SHARE, LocalDateTime.now(), "test1")
        );
    }
}