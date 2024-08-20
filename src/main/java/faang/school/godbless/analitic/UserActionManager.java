package faang.school.godbless.analitic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionManager {
    //возвращает id нужных пользователей
    public static List<Integer> top10ActiveUsers(List<UserAction> actions) {
        var grouped = actions.stream()
                .collect(Collectors.groupingBy(
                        a -> a.getId(),
                        Collectors.counting()));

        return grouped.entrySet()
                .stream()
                .sorted(Comparator.comparingLong(value -> -value.getValue()))//минус нужен, чтобы сорировать по убыванию
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> top5PopularThemes(List<UserAction> actions) {
        var grouped = actions.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.COMMENT)
                        || userAction.getActionType().equals(ActionType.POST))
                .flatMap(userAction -> Arrays.stream(userAction.getContent().split(" +"))
                        .filter(string -> string.startsWith("#")))
                .collect(Collectors.groupingBy(
                        string -> string,
                        Collectors.counting()));

        return grouped.entrySet().stream()
                .sorted(Comparator.comparingLong(value -> -value.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<Integer> top3MonthActiveUsers(List<UserAction> actions) {
        var grouped =  actions.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.COMMENT)
                        && (new Date().getTime() < userAction.getActionDate().getTime() + 1000 * 60 * 60 * 24 * 30L))
                .collect(Collectors.groupingBy(
                        UserAction::getId,
                        Collectors.counting()));

        return grouped.entrySet().stream()
                .sorted(Comparator.comparingLong(value -> -value.getValue()))
                .limit(3L)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<ActionType, Double> percentsOfActions(List<UserAction> actions) {
        var grouped =  actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.counting()));
        return grouped.entrySet().stream()
                .map(pair -> Map.entry(pair.getKey(), ((double) pair.getValue() / (double) actions.size())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }
}
