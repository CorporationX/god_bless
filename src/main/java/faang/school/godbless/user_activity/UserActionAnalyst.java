package faang.school.godbless.user_activity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyst {

//    Найти топ-10 самых активных пользователей (по количеству действий: посты, комментарии, лайки и репосты).
//    Отдельный метод класса.
//
//    Определить Топ-5 наиболее популярных тем обсуждения (по количеству упоминаний хештегов в постах и комментариях.
//    Хэштег — слово, начинающееся с символа #). Отдельный метод класса.
//
//    Найти Топ-3 пользователей, которые оставили наибольшее количество комментариев в последний месяц.
//    Отдельный метод класса.
//
//    Вычислить процент действий (посты, комментарии, лайки и репосты) для каждого типа действий.
//    Отдельный метод класса.

    public List<Integer> findTop10ActiveUsers(List<UserAction> userActions) {
        Map<Integer, Long> userActionsCount = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()));

        return userActionsCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<String> findTop5PopularTopics(List<UserAction> userActions) {
        Map<String, Long> topicCount = userActions.stream()
                .filter(action -> action.getContent() != null)
                .flatMap(action -> Arrays.stream(action.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        return topicCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<Integer> findTop3UsersWithMostCommentsLastMonth(List<UserAction> userActions) {
        Map<Integer, Long> userCommentCount = userActions.stream()
                .filter(action -> action.getActionType().equals(ActionType.COMMENT))
                .filter(action -> action.getActionDate().isAfter(LocalDate.now().minusMonths(1).atStartOfDay()))
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()));

        return userCommentCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Map<String, Double> calculateActionTypePercentages(List<UserAction> userActions) {
        long totalActions = userActions.size();

        Map<String, Long> actionTypeCount = userActions.stream()
                .collect(Collectors.groupingBy(action -> action.getActionType().toString(), Collectors.counting()));

        return actionTypeCount.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / totalActions
                ));
    }
}
