
package school.faang.sprint2.rating;


import java.util.*;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions) {

        Map<Integer, Set<String>> idName = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.mapping(UserAction::getName, Collectors.toSet())));

        List<Integer> top10Ids = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(10).map(Map.Entry::getKey).toList();

        return top10Ids.stream()
                .map(id -> idName.entrySet().stream()
                        .filter(ids -> ids.getKey().equals(id))
                        .map(value -> value.getValue().stream().findFirst())
                        .map(x -> x.orElse("No strings"))
                        .findFirst().orElse("No name"))
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        return actions.stream()
                .filter(action -> action.getContent() != null && action.getActionType().equals("post") || action.getActionType().equals("comment"))
                .flatMap(action -> Arrays.stream(action.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet().stream() //might apply Function.identity()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        return actions.stream()
                .filter(action -> action.getActionType().equals("comment") && action.getContent() != null)
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3).map(Map.Entry::getKey).toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        long allActions = actions.size();

        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> Math.round((entry.getValue() * 100.0 / allActions) * 100 )/100.0));

    }
}
