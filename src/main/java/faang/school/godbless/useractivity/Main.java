package faang.school.godbless.useractivity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    //Найти топ-10 самых активных пользователей (по количеству действий: посты, комментарии, лайки и репосты). Отдельный метод класса.
    public static List<String> geTopTenActiveUsers(List<UserAction> userActions) {
        Map<String, Long> map = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()));
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(entry -> entry.getKey())
                .toList();
    }

    //Определить Топ-5 наиболее популярных тем обсуждения (по количеству упоминаний хештегов в постах и комментариях. Хэштег — слово, начинающееся с символа #). Отдельный метод класса.
    public static List<String> getTopFiveThemas(List<UserAction> userActions) {
        Map<String, Long> topActivity = userActions.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.POST) || userAction.getActionType().equals(ActionType.COMMENT))
                .filter(userAction -> userAction.getContent().contains("#"))
                .flatMap(userAction -> Arrays.stream(userAction.getContent().split(" ")))
                .collect(Collectors.groupingBy(content -> content, Collectors.counting()));
        return topActivity.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(entry -> entry.getKey())
                .toList();
    }

    //Найти Топ-3 пользователей, которые оставили наибольшее количество комментариев в последний месяц. Отдельный метод класса.
    public static List<String> getTopThreeUsers(List<UserAction> userActions) {
        Map<String, Long> users = userActions.stream()
                .filter(userAction -> userAction.equals(ActionType.COMMENT))
                .filter(userAction -> userAction.getDateTime().isBefore(LocalDateTime.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()));
        return users.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(entry -> entry.getKey())
                .toList();
    }

    //Вычислить процент действий (посты, комментарии, лайки и репосты) для каждого типа действий. Отдельный метод класса.
    public static Map<ActionType, Double> activityInPercent(List<UserAction> userActions) {
        long actionCount = userActions.stream().count();
        Map<ActionType, Long> actionTypeCounts = userActions.stream()
                .map(userAction -> userAction.getActionType())
                .collect(Collectors.groupingBy(type -> type, (Collectors.counting())));
        return actionTypeCounts.entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> actionCount == 0 ? 0 : ((double) entry.getValue() / actionCount) * 100));
    }

    public static void main(String[] args) {

    }
}
