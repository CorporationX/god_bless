package faang.school.godbless.BJS2_10219;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        List<UserAction> actions = new ArrayList<>();
        actions.add(new UserAction(1, "n1", ActionType.COMMENT, LocalDateTime.now(), "#first какой-то коммент"));
        actions.add(new UserAction(1, "n1", ActionType.SHARE, LocalDateTime.now(), "c1"));
        actions.add(new UserAction(1, "n1", ActionType.LIKE, LocalDateTime.now(), "c1"));
        actions.add(new UserAction(2, "n2", ActionType.COMMENT, LocalDateTime.now(), "#first какой-то коммент"));
        actions.add(new UserAction(2, "n2", ActionType.POST, LocalDateTime.now(), "#second какой-то пост"));
        actions.add(new UserAction(2, "n2", ActionType.LIKE, LocalDateTime.now(), "c2"));
        actions.add(new UserAction(3, "n3", ActionType.COMMENT, LocalDateTime.of(2023, 5, 5, 5, 5), "#third какой-то коммент"));
        actions.add(new UserAction(3, "n3", ActionType.SHARE, LocalDateTime.now(), "c3"));
        actions.add(new UserAction(3, "n3", ActionType.COMMENT, LocalDateTime.of(2024, 2, 2, 2, 2), "какой-то коммент #fourth"));
        actions.add(new UserAction(3, "n3", ActionType.SHARE, LocalDateTime.now(), "c3"));
        actions.add(new UserAction(4, "n4", ActionType.COMMENT, LocalDateTime.now(), "какой-то коммент #fourth"));
        actions.add(new UserAction(4, "n4", ActionType.SHARE, LocalDateTime.now(), "c4"));
        actions.add(new UserAction(4, "n4", ActionType.COMMENT, LocalDateTime.now(), "какой-то #fifth коммент"));
        actions.add(new UserAction(4, "n4", ActionType.POST, LocalDateTime.now(), "какой-то #fifth пост"));

        findTopTenMostActiveUsersByActionsNumber(actions);
        findTopFiveMostPopularThemesInPostAndComments(actions);
        findTopThreeUsersWithMaxCommentsForMonth(actions);
        calculatePercetageOfActions(actions);
    }

    //найти топ-10 самых активных пользователей
    public static void findTopTenMostActiveUsersByActionsNumber(List<UserAction> userActions) {
        userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(10)
                .forEach(entry -> System.out.println("Юзер с id = " + entry.getKey() + " имеет " + entry.getValue() + " действий"));
    }

    public static void findTopFiveMostPopularThemesInPostAndComments(List<UserAction> userActions) {
        userActions.stream()
                .filter(action -> action.getActionType() == ActionType.COMMENT ||
                        action.getActionType() == ActionType.POST)
                .filter(action -> action.content.contains("#"))
                .map(action -> action.getContent().split(" "))
                .flatMap(strings -> Arrays.stream(strings).
                        filter(string -> string.regionMatches(0, "#", 0, 1)))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> System.out.println("хэштег " + entry.getKey() + " встречается в постах и комментариях " + entry.getValue() + " раз"));
    }

    public static void findTopThreeUsersWithMaxCommentsForMonth(List<UserAction> userActions) {
        userActions.stream()
                .filter(action -> action.getActionType() == ActionType.COMMENT)
                .filter(action -> action.getActionDate().isAfter(LocalDateTime.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(3)
                .forEach(entry -> System.out.println("Юзер с id = " + entry.getKey() + " имеет " + entry.getValue() + " комментариев за последний месяц"));
    }

    public static void calculatePercetageOfActions(List<UserAction> userActions) {
        Map<ActionType, Long> userAction = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        Integer allActionsCount = userAction.values().stream()
                .map(Long::intValue)
                .reduce(0, Integer::sum);

        userAction.forEach((key, value) -> System.out.println("действие " + key + " " + value * 100 / allActionsCount + "% из общего числа"));
    }
}
