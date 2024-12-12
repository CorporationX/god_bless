package school.faang.task47250;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    private static final int TOP_ACTIVE_USERS = 10;
    private static final int TOP_POPULAR_TOPICS = 5;
    private static final int TOP_USERS_MOST_COMMENTS = 3;
    private static final Pattern HASHTAG_SEARH_PATTERN = Pattern.compile("#\\w+.");
    private static final String REGEX_REMOVING_PUNCTUATION = "[.,;!?]*$";

    private static void validateActions(List<UserAction> actions) {
        if (actions == null) {
            throw new IllegalArgumentException("actions can`t be null");
        }
    }

    public static List<String> topActiveUsers(List<UserAction> actions) {
        validateActions(actions);

        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(TOP_ACTIVE_USERS)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        validateActions(actions);

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
                .limit(TOP_USERS_MOST_COMMENTS)
                .map(entry -> namesId.get(entry.getKey())).toList();

    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        validateActions(actions);


        return actions.stream()
                .map(UserAction::getContent)
                .filter(content -> content.contains("#"))
                .flatMap(string -> Arrays.stream(string.split(" ")))
                .filter(string -> HASHTAG_SEARH_PATTERN.matcher(string).matches())
                .collect(Collectors.toMap(
                        string -> string.replaceAll(REGEX_REMOVING_PUNCTUATION, ""),
                        count -> 1,
                        (existing, replacement) -> existing + 1))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(TOP_POPULAR_TOPICS)
                .map(Map.Entry::getKey).toList();
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> actions) {
        validateActions(actions);

        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> (double) entry.getValue() / actions.size()));
    }

}
