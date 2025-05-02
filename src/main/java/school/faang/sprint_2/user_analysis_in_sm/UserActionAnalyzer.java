package school.faang.sprint_2.user_analysis_in_sm;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static Map<String, Integer> findTopOfActiveUsers(List<UserAction> actions, int top) {
        return actions.stream()
                .map(UserAction::getId) // Integer
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(top)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().intValue(),
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    public static Map<String, Integer> topPopularHashtags(List<UserAction> actions, int top) {
        return actions.stream()
                .map(UserAction::getContent)
                .filter(content -> content != null && !content.isEmpty())
                .flatMap(content -> Arrays.stream(content.split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .map(tag -> tag.replaceAll("[^#\\w]", "").toLowerCase())
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(top)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (tag, amount) -> tag,
                        LinkedHashMap::new
                ));
    }

    public static Map<Integer, Integer> topCommentersLastMonth(List<UserAction> actions, int top) {
        LocalDate latestDate = actions.stream()
                .map(UserAction::getActionDate)
                .max(Comparator.comparing(LocalDate::getYear)
                        .thenComparing(LocalDate::getMonthValue))
                .orElse(null);

        if (latestDate == null) {
            return Collections.emptyMap();
        }

        int targetYear = latestDate.getYear();
        int targetMonth = latestDate.getMonthValue();

        List<UserAction> latestMonthComments = actions.stream()
                .filter(action -> action.getActionType() == ActionType.COMMENT)
                .filter(action -> {
                    LocalDate date = action.getActionDate();
                    return date.getYear() == targetYear && date.getMonthValue() == targetMonth;
                })
                .toList();

        Map<Integer, Integer> commentCounts = latestMonthComments.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getId,
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
                ));

        return commentCounts.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(top)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (userId, comments) -> userId,
                        LinkedHashMap::new
                ));
    }

    public static Map<ActionType, Double> calculateActionTypePercentages(List<UserAction> actions) {
        return (actions == null || actions.isEmpty())
                ? Collections.emptyMap()
                : actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        LinkedHashMap::new,
                        Collectors.collectingAndThen(
                                Collectors.counting(),
                                count -> (count * 100.0) / actions.size()
                        )
                ));
    }
}
