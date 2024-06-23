package faang.school.godbless.sprint_2.stream_API.task_3_user_activity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class Program {
    public static void main(String[] args) {
        List<UserAction> userActions = List.of(
                new UserAction(1, ActionType.POST, LocalDate.now(), "#theme1 " + 1),
                new UserAction(2, ActionType.COMMENT, LocalDate.now(), "#theme1 " + 2),
                new UserAction(7, ActionType.POST, LocalDate.now(), "#theme2 " + 2),
                new UserAction(3, ActionType.LIKE, LocalDate.now(), ""),
                new UserAction(1, ActionType.POST, LocalDate.now(), "#theme8 " + 1),
                new UserAction(13, ActionType.COMMENT, LocalDate.now(), "#theme4 " + 1),
                new UserAction(2, ActionType.COMMENT, LocalDate.now(), "#theme2 " + 2),
                new UserAction(3, ActionType.POST, LocalDate.now(), "#theme6 " + 3),
                new UserAction(1, ActionType.POST, LocalDate.now(), "#theme8 " + 1),
                new UserAction(5, ActionType.COMMENT, LocalDate.now(), "#theme4 " + 1),
                new UserAction(2, ActionType.COMMENT, LocalDate.now(), "#theme2 " + 2),
                new UserAction(12, ActionType.POST, LocalDate.now(), "#theme6 " + 3),
                new UserAction(1, ActionType.SHARE, LocalDate.now(), ""),
                new UserAction(3, ActionType.LIKE, LocalDate.now(), ""),
                new UserAction(2, ActionType.SHARE, LocalDate.now(), ""),
                new UserAction(6, ActionType.LIKE, LocalDate.now(), ""),
                new UserAction(6, ActionType.COMMENT, LocalDate.now(), "#theme5 " + 1),
                new UserAction(2, ActionType.COMMENT, LocalDate.now(), "#theme2 " + 2),
                new UserAction(3, ActionType.POST, LocalDate.now(), "#theme7 " + 3),
                new UserAction(3, ActionType.LIKE, LocalDate.now(), ""),
                new UserAction(1, ActionType.POST, LocalDate.now(), "#theme6 " + 1),
                new UserAction(11, ActionType.LIKE, LocalDate.now(), ""),
                new UserAction(7, ActionType.COMMENT, LocalDate.now(), "#theme5 " + 1),
                new UserAction(2, ActionType.COMMENT, LocalDate.now(), "#theme2 " + 2),
                new UserAction(3, ActionType.POST, LocalDate.now(), "#theme3 " + 3),
                new UserAction(8, ActionType.SHARE, LocalDate.now(), ""),
                new UserAction(8, ActionType.SHARE, LocalDate.now(), ""),
                new UserAction(1, ActionType.POST, LocalDate.now(), "#theme2 " + 1),
                new UserAction(9, ActionType.COMMENT, LocalDate.now(), "#theme5 " + 1),
                new UserAction(2, ActionType.COMMENT, LocalDate.now(), "#theme2 " + 2),
                new UserAction(10, ActionType.POST, LocalDate.now(), "#theme3 " + 3),
                new UserAction(2, ActionType.COMMENT, LocalDate.now(), "#theme2 " + 2),
                new UserAction(10, ActionType.LIKE, LocalDate.now(), "")
        );

        // топ-10 самых активных пользователей
        List<Integer> topTenActiveUsers = findTopTenActiveUsers(userActions);

        // Топ-5 наиболее популярных тем обсуждения
        List<String> topFiveTopics = findTopFiveTopics(userActions);

        // Топ-3 пользователей за последний месяц
        List<Integer> topThreeActivityUsersLastMonth = findTopThreeActivityUsersLastMonth(userActions);

        // Вычислить процент действий
        Map<String, Long> actionsInPercent = calcActionInPercent(userActions);
    }

    private static Map<String, Long> calcActionInPercent(List<UserAction> userActions) {
        int count = userActions.size();

        Map<String, Long> actionCountMap = userActions.stream()
                .map(act -> act.actionType().toString())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return actionCountMap.entrySet().stream()
                .collect(toMap(Map.Entry::getKey, entry -> entry.getValue() * 100 / count));
    }

    private static List<Integer> findTopThreeActivityUsersLastMonth(List<UserAction> userActions) {
        Predicate<UserAction> filterActivityByLastMonth = act -> {
            LocalDate lastMonth = LocalDate.now().minusMonths(1);
            return act.actionDate().isAfter(lastMonth);
        };

        Map<Integer, Long> groupById = userActions.stream()
                .filter(filterActivityByLastMonth)
                .collect(groupingBy(UserAction::id, counting()));

        return groupById.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    private static List<String> findTopFiveTopics(List<UserAction> userActions) {
        Predicate<UserAction> filterByType = act -> act.actionType() == ActionType.POST || act.actionType() == ActionType.COMMENT;

        Stream<String> contentStream = userActions.stream()
                .filter(filterByType)
                .map(UserAction::content);

        Stream<String> topics = contentStream.flatMap(content -> Arrays.stream(content.split(" ")))
                .filter(word -> word.startsWith("#"));

        return topics.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    private static List<Integer> findTopTenActiveUsers(List<UserAction> userActions) {
        Map<Integer, Long> groupById = userActions.stream()
                .collect(groupingBy(UserAction::id, counting()));

        return groupById.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }
}
