package useractionanalyzer;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class UserActionAnalyzer {
    private static final String LOG_TOP_USERS = "Топ-{} активных пользователей: {}";
    private static final String LOG_TOP_HASHTAGS = "Топ-{} популярных хэштегов: {}";
    private static final String LOG_TOP_COMMENTERS = "Топ-{} комментаторов за последний месяц: {}";
    private static final String LOG_ACTION_PERCENTAGES = "Процентное распределение действий: {}";
    private static final int HUNDRED_PERCENT = 100;

    public static List<String> topActiveUsers(List<UserAction> actions, int n) {
        List<String> result = actions.stream()
                .collect(Collectors.groupingBy(UserAction::userName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();

        log.info(LOG_TOP_USERS, n, result);
        return result;
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int n) {
        List<String> result = actions.stream()
                .map(UserAction::content)
                .flatMap(content -> Arrays.stream(content.split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();

        log.info(LOG_TOP_HASHTAGS, n, result);
        return result;
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int n) {
        LocalDate lastMonth = LocalDate.now().minusMonths(1);
        List<String> result = actions.stream()
                .filter(action -> action.actionType() == ActionType.COMMENT
                        && action.actionDate().isAfter(lastMonth))
                .collect(Collectors.groupingBy(UserAction::userName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();

        log.info(LOG_TOP_COMMENTERS, n, result);
        return result;
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        if (actions == null || actions.isEmpty()) {
            log.info(LOG_ACTION_PERCENTAGES, Map.of());
            return Map.of();
        }

        long totalActions = actions.size();
        Map<String, Double> percentages = Arrays.stream(ActionType.values())
                .collect(Collectors.toMap(
                        Enum::name,
                        type -> roundToTwoDecimals(
                                (double) actions.stream().filter(a ->
                                        a.actionType() == type).count() / totalActions * HUNDRED_PERCENT
                        )
                ));
        log.info(LOG_ACTION_PERCENTAGES, percentages);
        return percentages;
    }

    private static double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}


