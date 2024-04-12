package faang.school.godbless.useractives;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<UserAction> userActions = List.of(
                new UserAction(1, ActionType.POST, LocalDateTime.now().minusDays(30), "#IT"),
                new UserAction(1, ActionType.COMMENT, LocalDateTime.now(), "#IT"),
                new UserAction(1, ActionType.LIKE, LocalDateTime.now().minusDays(10)),
                new UserAction(2, ActionType.COMMENT, LocalDateTime.now().minusDays(5), "#java"),
                new UserAction(2, ActionType.COMMENT, LocalDateTime.now(), "#IT"),
                new UserAction(2, ActionType.POST, LocalDateTime.now(), "#IT"),
                new UserAction(2, ActionType.SHARE, LocalDateTime.now().minusDays(3)),
                new UserAction(3, ActionType.COMMENT, LocalDateTime.now().minusDays(3), "#IT"),
                new UserAction(3, ActionType.POST, LocalDateTime.now(), "#java"),
                new UserAction(4, ActionType.COMMENT, LocalDateTime.now().minusDays(3), "#HR"),
                new UserAction(5, ActionType.COMMENT, LocalDateTime.now().minusDays(3), "#manager"),
                new UserAction(5, ActionType.POST, LocalDateTime.now().minusDays(3), "#java"),
                new UserAction(6, ActionType.COMMENT, LocalDateTime.now().minusDays(3), "#IT"),
                new UserAction(6, ActionType.COMMENT, LocalDateTime.now().minusDays(3), "#IT"),
                new UserAction(7, ActionType.COMMENT, LocalDateTime.now().minusDays(3), "#python"),
                new UserAction(7, ActionType.POST, LocalDateTime.now(), "#HR"),
                new UserAction(8, ActionType.COMMENT, LocalDateTime.now().minusDays(3), "#IT"),
                new UserAction(9, ActionType.COMMENT, LocalDateTime.now().minusDays(3), "#HR"),
                new UserAction(10, ActionType.COMMENT, LocalDateTime.now().minusDays(3), "#manager"),
                new UserAction(11, ActionType.LIKE, LocalDateTime.now().minusDays(3))
        );

        System.out.println("findMostActivitiesUsers TEST");
        findMostActivitiesUsers(userActions, ActionType.COMMENT).forEach(System.out::println);

        System.out.println("getTop5MostPopularThemes TEST");
        getTop5MostPopularThemes(userActions).forEach(System.out::println);

        System.out.println("getTop3ByComments TEST");
        getTop3ByComments(userActions).forEach(System.out::println);

        System.out.println("getActionTypePercent TEST");
        System.out.println(getActionTypePercent(userActions));
    }

    public static List<Integer> findMostActivitiesUsers(List<UserAction> userActions, ActionType actionType) {
        return userActions.stream()
                .filter(userAction -> userAction.getActionType().equals(actionType))
                .collect(Collectors.groupingBy(UserAction::getUserId))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().size()
                ))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .map(Map.Entry::getKey)
                .limit(10)
                .toList();
    }

    public static List<String> getTop5MostPopularThemes(List<UserAction> userActions) {
        return userActions.stream()
                .filter(userAction -> userAction.getContent() != null)
                .collect(Collectors.groupingBy(UserAction::getContent))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().size()
                ))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .map(Map.Entry::getKey)
                .limit(5)
                .toList();
    }

    public static List<Integer> getTop3ByComments(List<UserAction> userActions) {
        return userActions.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.COMMENT))
                .filter(userAction -> userAction.getActionDate().isAfter(LocalDateTime.now().minusDays(30)))
                .collect(Collectors.groupingBy(UserAction::getUserId))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().size())
                ).entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .map(Map.Entry::getKey)
                .limit(3)
                .toList();
    }

    public static Map<ActionType, Double> getActionTypePercent(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType))
                .entrySet()
                .stream()
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> Math.floor((double) entry.getValue().size() / userActions.size() * 10000) / 100
                        )
                );
    }
}
