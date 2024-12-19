package derschrank.sprint02.task10.bjstwo_47645;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    private static final String ACTION_TYPE_POST = "post";
    private static final String ACTION_TYPE_COMMENT = "comment";

    public static List<String> topActiveUsers(List<UserAction> actions) {
        Map<Integer, String> idAndNameUsers = getIdAndNameOfUsers(actions);

        return idAndNameUsers.keySet().stream()
                .map(id -> Map.entry(id,
                        actions.stream()
                                .filter(action -> id.equals(action.id()))
                                .count())
                )
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .limit(10)
                .map(entry -> idAndNameUsers.get(entry.getKey()))
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {

        return actions.stream()
                .filter(action -> ACTION_TYPE_POST.equals(action.actionType())
                        ||  ACTION_TYPE_COMMENT.equals(action.actionType()))
                .filter(action -> action.content().contains("#"))
                .map(action -> Arrays.stream(action.content().split("\\s+"))
                        .filter(word -> word.startsWith("#")).findFirst().orElse("#error"))
                .collect(Collectors.toMap(
                        hash -> hash,
                        hash -> 1,
                        (a, b) -> a + b))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        LocalDate lastMothBorder = LocalDate.now().minusMonths(1);

        return actions.stream()
                .filter(action -> "comment".equals(action.actionType())
                        && action.actionDate().isAfter(lastMothBorder))
                .collect(Collectors.groupingBy(
                        action -> Map.entry(action.id(), action.name()),
                        Collectors.counting()
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
                                        entry -> ((double) 100 * entry.getValue()) / actions.size()));
    }

    private static Map<Integer, String> getIdAndNameOfUsers(List<UserAction> actions) {
        return actions.stream()
                        .map(action -> Map.entry(action.id(), action.name()))
                        .distinct()
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
