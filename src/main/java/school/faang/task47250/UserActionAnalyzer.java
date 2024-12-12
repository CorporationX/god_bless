package school.faang.task47250;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    private static void validate(List<UserAction> actions) {
        if (actions == null) {
            throw new IllegalArgumentException("actions can`t be null");
        }
    }

    public static List<String> topActiveUsers(List<UserAction> actions) {
        validate(actions);

        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        validate(actions);

        int maxMonth = actions.stream()
                .map(UserAction::getActionDate)
                .max(Comparator.naturalOrder())
                .orElse(LocalDate.now()).getMonthValue();

        Map<Integer, String> namesId = actions.stream()
                .collect(Collectors
                        .toMap(UserAction::getId, UserAction::getName, (existing, replacement) -> existing));

        Map<Integer, List<String>> commentsByUser = actions.stream()
                .collect(Collectors.toMap(
                        UserAction::getId,
                        action -> actions.stream()
                                .filter(action1 -> action.getId() == action1.getId())
                                .filter(action1 -> action1.getActionDate().getMonthValue() == maxMonth)
                                .map(UserAction::getContent)
                                .filter(content -> !content.isBlank())
                                .toList(),
                        (existing, replacement) -> existing
                ));


        return commentsByUser.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((list1, list2) -> list2.size() - list1.size()))
                .limit(3)
                .map(entry -> namesId.get(entry.getKey())).toList();

    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        validate(actions);

        Pattern pattern = Pattern.compile("#\\w+.");

        return actions.stream()
                .map(UserAction::getContent)
                .filter(content -> content.contains("#"))
                .flatMap(string -> Arrays.stream(string.split(" ")))
                .filter(string -> pattern.matcher(string).matches())
                .collect(Collectors.toMap(
                        string -> string.replaceAll("[.,;!?]*$", ""),
                        count -> 1,
                        (existing, replacement) -> existing + 1))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey).toList();
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> actions) {
        validate(actions);

        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> (double) entry.getValue() / actions.size()));
    }

}
