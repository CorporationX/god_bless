package school.faang.task58032.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions, int numb) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(numb)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int numb) {

        return new ArrayList<>();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int i) {

        return new ArrayList<>();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {

        return new HashMap<>();
    }
}
