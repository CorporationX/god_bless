package school.faang.task_58140;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserActionAnalyzer {
    private static final Pattern PATTERN = Pattern.compile("#\\w+");
    private static final LocalDate REQUIRED_DATE = LocalDate.now().minusMonths(1);

    public static List<String> topActiveUsers(@NonNull List<UserAction> actions, int top) {
        Map<String, Long> numberOfUserActions = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return reversSort(numberOfUserActions, top);
    }

    public static List<String> topPopularHashtags(@NonNull List<UserAction> actions, int top) {
        Map<String, Long> numberOfHashtags = actions.stream()
                .map(UserAction::getContent)
                .flatMap(UserActionAnalyzer::getSubstrings)
                .collect(Collectors.groupingBy(string -> string, Collectors.counting()));
        return reversSort(numberOfHashtags, top);

    }

    public static List<String> topCommentersLastMonth(@NonNull List<UserAction> actions, int top) {
        Map<String, Long> numberOfUserComments = actions.stream()
                .filter(userAction -> userAction.getActionDate().isAfter(REQUIRED_DATE)
                        && ActionType.COMMENT.equals(userAction.getActionType()))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return reversSort(numberOfUserComments, top);

    }

    public static Map<ActionType, Double> actionTypePercentages(@NonNull List<UserAction> actions) {
        double actionsCount = actions.size();
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> calculateActionTypePercent(entry.getValue(), actionsCount)));
    }

    private static List<String> reversSort(@NonNull Map<String, Long> map, int top) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(top)
                .map(Map.Entry::getKey)
                .toList();
    }

    private static Stream<String> getSubstrings(@NonNull String string) {
        List<String> substrings = new ArrayList<>();
        Matcher matcher = PATTERN.matcher(string);
        while (matcher.find()) {
            substrings.add(matcher.group());
        }
        return substrings.stream();
    }

    private static double calculateActionTypePercent(double value, double total) {
        int decimalPlaces = 2;
        double scale = Math.pow(10, decimalPlaces);
        double percent = (value * 100) / total;

        return Math.round(percent * scale) / scale;
    }
}
