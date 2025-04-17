package school.faang.bjs2_70818;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
@UtilityClass
public class UserActionAnalyzer {
    private static List<String> getTopList(Map<String, Long> workMap, Integer lim) {
        return workMap.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(lim)
            .map(Map.Entry::getKey)
            .toList();
    }

    /**
     * Топ-N самых активных пользователей (по количеству действий: посты, комментарии, лайки и репосты).
     * Метод должен возвращать список из n пользователей, которые совершили наибольшее количество действий.
     */
    public static List<String> topActiveUsers(List<UserAction> actions, Integer lim) {
        Map<String, Long> countByUser = actions.stream()
            .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()));
        log.info("countByUser: {}", countByUser);
        return getTopList(countByUser, lim);
    }

    /**
     * Топ-N наиболее популярных тем обсуждения (по количеству упоминаний хештегов в постах и комментариях).
     * Метод должен возвращать список из n самых популярных хэштегов (слова, начинающиеся с символа #).
     */
    public static List<String> topPopularHashtags(List<UserAction> actions, Integer lim) {
        Set<ActionType> filterActionType = Set.of(ActionType.POST, ActionType.COMMENT);
        Map<String, Long> countByHashTag = actions.stream()
            .filter(action -> action.content() != null && filterActionType.contains(action.actionType()))
            .flatMap(action -> Pattern.compile("#\\s*(\\w+)").matcher(action.content()).results())
            .map(MatchResult::group)
            .map(String::toLowerCase)
            .collect(Collectors.groupingBy(hashTag -> hashTag, Collectors.counting()));
        log.info("countByHashTag: {}", countByHashTag);
        return getTopList(countByHashTag, lim);
    }

    /**
     * Топ-N пользователей, которые оставили наибольшее количество комментариев в последний месяц.
     * Метод должен возвращать n пользователей, которые оставили больше всего комментариев за последний месяц.
     */
    public static List<String> topCommentersLastMonth(List<UserAction> actions, Integer lim) {
        //найти максимальную дату
        LocalDate dateBoarder = actions.stream()
            .map(UserAction::actionDate)
            .max(LocalDate::compareTo)
            .orElseGet(LocalDate::now)
            .minusMonths(1);
        log.info("dateBoarder: {}", dateBoarder);

        Map<String, Long> countByGreatestComment = actions.stream()
            .filter(action -> dateBoarder.isBefore(action.actionDate()))
            .filter(action -> action.actionType().equals(ActionType.COMMENT))
            .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()));
        log.info("countByGreatestComment: {}", countByGreatestComment);
        return getTopList(countByGreatestComment, lim);
    }

    /**
     * Вычислить процент для каждого типа действий (посты, комментарии, лайки и репосты).
     * Метод должен возвращать процентное соотношение каждого типа действия среди всех действий.
     */
    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        Map<String, Long> countByActionType = actions.stream()
            .collect(Collectors.groupingBy(action -> action.actionType().getName(), Collectors.counting()));
        log.info("countByActionType: {}", countByActionType);
        return countByActionType.entrySet().stream()
            .collect(
                Collectors.toMap(Map.Entry::getKey, entry -> (double) entry.getValue() / actions.size())
            );
    }
}
