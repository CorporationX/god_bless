package school.faang.bjs2_35616.service;

import school.faang.bjs2_35616.model.UserAction;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions) {
        Map<Integer, Long> longUserActionMap = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()));

        Map<Integer, Long> sortedMap = longUserActionMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(10)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));


        // Выводим результат
        System.out.println(sortedMap);
        return null;
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        return null;
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {

        return null;
    }

    public Map<String, Double> actionTypePercentages(List<UserAction> actions) {

        return null;
    }
}
