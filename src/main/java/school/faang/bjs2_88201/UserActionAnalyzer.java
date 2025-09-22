package school.faang.bjs2_88201;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions, int limit) {
        return actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getUserName,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Comparator.comparingInt(x -> Math.toIntExact(x.getValue())))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int limit) {
        return actions.stream()
                .map(UserAction::getContent)
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .filter(word -> word.startsWith("#"))
                .map(hashtag -> hashtag.replaceAll("[^\\p{L}]+$", ""))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Comparator.comparingInt(x -> Math.toIntExact(x.getValue())))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int limit) {
        return actions.stream()
                .filter(action -> action.getActionType().equals(ActionType.COMMENT))
                .collect(Collectors.groupingBy(
                        UserAction::getUserName,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Comparator.comparingInt(x -> Math.toIntExact(x.getValue())))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(
                        action -> action.getActionType().name(),
                        Collectors.collectingAndThen(
                                Collectors.counting(),
                                i -> new BigDecimal(i * 100.0 / actions.size()).setScale(2,
                                        RoundingMode.HALF_UP).doubleValue())
                ));
    }
}
