package faang.school.godbless.stream;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static faang.school.godbless.stream.ActionType.*;

public class UserActionAnalyze {


    //Найти топ-10 самых активных пользователей (по количеству действий: посты, комментарии, лайки и репосты)
    public static List<Integer> getTenMostPopularUsers(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


    //Определить Топ-5 наиболее популярных тем обсуждения (по количеству упоминаний хештегов в постах и комментариях.
    // Хэштег — слово, начинающееся с символа #)
    public static List<String> getMostPopularContents(List<UserAction> userActions) {

        return userActions.stream()
                .filter(userAction -> userAction.getActionType().equals(POST) ||
                        userAction.getActionType().equals(COMMENT))
                .filter(userAction -> userAction.getContent().contains("#"))
                .collect(Collectors.toMap(UserAction::getContent,
                        userAction -> Arrays.stream(userAction.getContent().split(" "))
                                .filter(str -> str.matches("^#\\w+"))
                                .count(),
                        (content1, content2) -> content1))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }

    //Найти Топ-3 пользователей, которые оставили наибольшее количество комментариев в последний месяц.
    public static List<Integer> getMostActiveUsersByLastMonth(List<UserAction> userActions) {

        return userActions.stream()
                .filter(userAction -> userAction.getActionType().equals(COMMENT))
                .filter(userAction -> userAction.getActionDate().isAfter(LocalDateTime.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    //Вычислить процент действий (посты, комментарии, лайки и репосты) для каждого типа действий
    public static Map<ActionType, Double> getActionPercentage(List<UserAction> userActions) {

        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue() * 100.0 / userActions.size()));
    }
}
