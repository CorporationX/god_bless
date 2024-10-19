package school.faang.bjs2_35566;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> userActions) {
        Map<Integer, List<UserAction>> sortedMap = userActions.stream().collect(Collectors.groupingBy(UserAction::getId));

        Map<String, List<UserAction>> transformedMap = sortedMap.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(UserAction::getName));

        return transformedMap.entrySet().stream()
                .sorted(Comparator.comparing(map -> map.getValue().size()))
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> userActions) {


    }

    // public static List<String> topCommenters(List<UserAction> userActions) {

    // }

    // public static Map<UserAction.ActionType, Double> actionPercentages(List<UserAction> userActions) {

}
