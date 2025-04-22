package school.faang.bjs270881;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions, int top) {
        Map<String, Long> userActionCounts = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        return userActionCounts.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(top)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int top) {
        Map<String, Long> hashtagCounts = actions.stream()
                .map(UserAction::getContent)
                .filter(Objects::nonNull)
                .filter(contentText -> !contentText.isEmpty())
                .flatMap(contentText -> Arrays.stream(contentText.split(" ")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return hashtagCounts.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(top)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int top) {
        LocalDate lastMonth = LocalDate.now().minusMonths(1);
        Map<String, Long> commentCountsByUser = actions.stream()
                .filter(text -> text.getAction() == ActionType.COMMENT)
                .filter(date -> date.getActionDate().isBefore(lastMonth))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        return commentCountsByUser.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(top)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        long total = actions.size();
        Map<String, Long> actionTypeCounts = actions.stream()
                .collect(Collectors.groupingBy(userAction ->
                        userAction.getAction().name(), Collectors.counting()));

        return actionTypeCounts.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, element ->
                        element.getValue() * 100.00 / total));
    }
}