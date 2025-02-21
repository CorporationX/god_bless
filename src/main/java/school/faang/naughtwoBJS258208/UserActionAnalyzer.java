package school.faang.naughtwoBJS258208;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions, int n) {
        Map<String, Long> activeUsers = actions.stream()
                //возникает дубликат ключа, я не понимаю почему, и даже не уверена что именно здесь возникает
                //при попытке найти решение выдает то же самое, что уже написано.....
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return sortedList(activeUsers, n);
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int n) {
        Map<String, Long> hashtags = actions.stream()
                .filter(action ->
                        action.getContent() != null
                                && (ActionType.POST.equals(action.getActionType())
                                || ActionType.COMMENT.equals(action.getActionType())))
                .flatMap(action -> Arrays.stream(action.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        return sortedList(hashtags, n);
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int n) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        Map<String, Long> activeUsers = actions.stream()
                .filter(action ->
                        action.getContent() != null
                                && ActionType.COMMENT.equals(action.getActionType())
                                && action.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return sortedList(activeUsers, n);
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        Map<ActionType, Long> actionType = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));
        return actionType.entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getValue().toString(),
                        entry -> entry.getValue() * 100.0 / actions.size()));
    }

    private static List<String> sortedList(Map<String, Long> map, int n) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }
}
