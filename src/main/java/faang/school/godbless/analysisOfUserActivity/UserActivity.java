package faang.school.godbless.analysisOfUserActivity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActivity {
    private final int MOST_ACTIVE_USER_COUNT = 2;
    private final int MOST_POPULAR_DISCUSSION_COUNT = 3;
    private final int MOST_ACTIVE_USERS_BY_COM_COUNT = 2;

    //Найти топ-10 самых активных пользователей (по количеству действий: посты, комментарии, лайки и репосты).
    public List<String> getTopMostActiveUsers(List<UserAction> userActionList) {
        Map<String, List<UserAction>> map = userActionList.stream().collect(Collectors.groupingBy(UserAction::getId));

        return map.entrySet().stream()
                .sorted(Map.Entry.<String, List<UserAction>>comparingByValue(Comparator.comparingInt(List::size)).reversed())
                .limit(MOST_ACTIVE_USER_COUNT)
                .map(Map.Entry::getKey)
                .toList();
    }

    //Определить Топ-5 наиболее популярных тем обсуждения (по количеству упоминаний хештегов в постах и комментариях.
    //Хэштег — слово, начинающееся с символа #).
    public List<String> getTopMostPopularDiscussion(List<UserAction> userActionList) {
        return userActionList.stream()
                .filter(action -> action.getContent().contains("#") &&
                        (action.getActionType() == ActionType.POST || action.getActionType() == ActionType.COMMENT))
                .flatMap(action ->
                        Arrays.stream(action.getContent().split(" "))
                )
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))

                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(MOST_POPULAR_DISCUSSION_COUNT)
                .map(Map.Entry::getKey)
                .toList();
    }

    //Найти Топ-3 пользователей, которые оставили наибольшее количество комментариев в последний месяц.
    public List<String> getTopMostActiveUsersByComments(List<UserAction> userActionList) {
        LocalDate monthAgo = LocalDate.now().minusMonths(1);

        return userActionList.stream()
                .filter(action -> action.getActionType() == ActionType.COMMENT && action.getActionDate().isAfter(monthAgo))
                .collect(Collectors.groupingBy(UserAction::getId))
                .entrySet().stream()
                .sorted(Map.Entry.<String, List<UserAction>>comparingByValue(Comparator.comparingInt(List::size)).reversed())
                .limit(MOST_ACTIVE_USERS_BY_COM_COUNT)
                .map(Map.Entry::getKey)
                .toList();
    }

    //Вычислить процент действий (посты, комментарии, лайки и репосты) для каждого типа действий.
    public Map<ActionType, Double> getActivityPercentage(List<UserAction> userActionList) {
        Map<ActionType, Double> map = userActionList.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType))
                .entrySet().stream()
                .map(entry -> Map.entry(entry.getKey(), entry.getValue().size() * 100 / (double) userActionList.size()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        for (ActionType actionType : ActionType.values()) {
            if (!map.containsKey(actionType)){
                map.put(actionType, 0.0);
            }
        }

        return map;
    }
}
