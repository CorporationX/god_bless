package school.faang.analizeactivityusers;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topTenActiveUsers(List<UserAction> list) {
        return list.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topFivePopularHashtags(List<UserAction> list) {
        return list.stream()
                .collect(Collectors.groupingBy(UserAction::getContent, Collectors.counting()))
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .filter(s -> s.startsWith("#"))
                .collect(Collectors.toList());
    }

    public static List<String> topThreeCommentersLastMonth(List<UserAction> list) {
        return list.stream()
                .filter(action -> "comment".equals(action.getActionType()))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> list) {
        Map<String, Double> mapOfActionTypePercentages = new HashMap<>();

        if (list.isEmpty()) {
            System.out.println("Массив пустой");
        } else {

        double onePercent = list.size() / 100.0;
        mapOfActionTypePercentages = list.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue() / onePercent
                ));
        }
        return mapOfActionTypePercentages;
    }
}
