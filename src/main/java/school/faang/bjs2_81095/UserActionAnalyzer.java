package school.faang.bjs2_81095;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> list, int limit) {
        return list.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getName,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(entry -> entry.getKey() + "(" + entry.getValue() + ")")
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> list, int limit) {
        return list.stream()
                .map(UserAction::getContent)
                .filter(content -> content.contains("#"))
                .flatMap(content -> Arrays.stream(content.trim().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.reducing(0, tag -> 1, Integer::sum)
                ))
                //или использовать Collectors.collectingAndThen?
                .entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(limit)
                .map(entry -> entry.getKey() + "(" + entry.getValue() + ")")
                .collect(Collectors.toList());
    }

    public static List<String> topCommentersLastMonth(List<UserAction> list, int limit) {
        return list.stream()
                .filter(userAction ->
                        userAction.getActionType() == ActionType.COMMENT
                                && userAction.getActionDate().isAfter(
                                LocalDate.now().minusMonths(1)
                        )
                )
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(
                                UserAction::getName,
                                Collectors.counting()
                        ),
                        map -> map.entrySet().stream()
                                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                                .limit(limit)
                                .map(entry -> entry.getKey() + "(" + entry.getValue() + ")")
                                .toList()
                ));
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> list) {
        int size = list.size();
        return list.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / size
                ));
    }
}
