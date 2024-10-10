package bjs2_35433;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions) {
        return actions
                .stream()
                .collect(Collectors.groupingBy(UserAction::getId))
                .entrySet()
                .stream()
                .sorted((entry1, entry2) ->
                        Integer.compare(entry2.getValue().size(), entry1.getValue().size()))
                .limit(10)
                .map(entry -> entry.getValue().get(0).getName())
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        return actions
                .stream()
                .filter(action -> action.getContent().startsWith("#"))
                .collect(Collectors.groupingBy(UserAction::getContent, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((entry1, entry2) ->
                        Long.compare(entry2.getValue(), entry1.getValue()))
                .limit(5)
                .map(entry -> entry.getKey() + ": " + entry.getValue() + " times.")
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        return actions
                .stream()
                .filter(action -> {
                    LocalDate actionDate = action.getActionDate();
                    LocalDate today = LocalDate.now();

                    return actionDate.isAfter(today.minusMonths(1)) &&
                            action.getActionType().equals("comment");
                })
                .collect(Collectors.groupingBy(UserAction::getId))
                .entrySet()
                .stream()
                .sorted((entry1, entry2) ->
                        Integer.compare(entry2.getValue().size(), entry1.getValue().size()))
                .limit(3)
                .map(entry -> entry.getValue().get(0).getName())
                .toList();
    }

    public static Map<String, Double> actionPercentages(List<UserAction> actions) {
        return actions
                .stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> ((double) entry.getValue() / (double) actions.size()) * 100
                ));
    }
}
