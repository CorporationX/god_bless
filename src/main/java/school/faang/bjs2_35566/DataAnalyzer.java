package school.faang.bjs2_35566;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Map<String, Long> hashtagCount = userActions.stream()
                .flatMap(list -> Stream.of(list.getContent().split(" ")))
                .map(word -> word.replaceAll("[^a-zA-Z#]", ""))
                .filter(word -> Pattern.matches("#.+", word))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        return hashtagCount.entrySet().stream()
                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

     public static List<String> topCommenters(List<UserAction> userActions) {
         Map<Integer, List<UserAction>> sortedMap = userActions.stream()
                .filter(list -> list.getActionDate().getMonthValue() == 10 && !list.getContent().isEmpty())
                .collect(Collectors.groupingBy(UserAction::getId));

         Map<String, List<UserAction>> transformedMap = sortedMap.values().stream()
                 .flatMap(List::stream)
                 .collect(Collectors.groupingBy(UserAction::getName));

         return transformedMap.entrySet().stream()
                 .sorted(Comparator.comparing(map -> map.getValue().size()))
                 .limit(3)
                 .map(Map.Entry::getKey)
                 .toList();
     }

     public static Map<UserAction.ActionType, Double> actionPercentages(List<UserAction> userActions) {
        int totalActions = userActions.size();

        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> (entry.getValue() * 100.0) / totalActions));
     }
}
