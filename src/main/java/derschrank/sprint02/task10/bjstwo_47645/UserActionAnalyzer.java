package derschrank.sprint02.task10.bjstwo_47645;


import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions) {
        Map<Integer, String> idAndNameUsers = getIdAndNameOfUsers(actions);

        Map <Integer, Integer> idAndCountOfActivity = new HashMap<>();
        for (Integer id : idAndNameUsers.keySet()) {
            idAndCountOfActivity.put(
                    id,
                    (int) actions.stream()
                            .filter(action -> id.equals(action.id()))
                            .count()
            );
        }

        return idAndCountOfActivity.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .limit(10)
                .map(entry -> idAndNameUsers.get(entry.getKey()))
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        List<String> hashTags = actions.stream()
                .filter(action -> action.content().startsWith("#"))
                .map(action -> action.content().split(" ", 2)[0])
                .toList();

        Map<String, Integer> tagCount = hashTags.stream()
                .collect(Collectors.toMap(
                        hash -> hash,
                        hash -> 1,
                        (a, b) -> a + b));

        return tagCount.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        LocalDate lastMothBorder = LocalDate.now().minusMonths(1);

        return actions.stream()
                .filter(action -> "comment".equals(action.actionType())
                        && action.actionDate().isAfter(lastMothBorder))
                .collect(Collectors.toMap(
                        action -> Map.entry(action.id(), action.name()),
                        action ->1,
                        (a, b) -> a + b
                )).entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .map(entry -> entry.getKey().getValue())
                .limit(3)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        return actions.stream()
                        .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()))
                        .entrySet().stream()
                        .collect(Collectors
                                .toMap(Map.Entry::getKey,
                                        entry -> ((double) 100 * entry.getValue())/actions.size()));
    }

    private static Map<Integer, String> getIdAndNameOfUsers(List<UserAction> actions) {
        return actions.stream()
                        .map(action -> Map.entry(action.id(), action.name()))
                        .distinct()
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
