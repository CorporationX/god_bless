package school.faang.task_47090;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@UtilityClass
public class UserActionAnalyzer {
    public static List<Integer> topActiveUsers(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::id, Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        return actions.stream()
                .filter(a -> getHashTag(a.content()) != null)
                .collect(Collectors.groupingBy(
                        userAction -> getHashTag(userAction.content()),
                        Collectors.counting()))
                .entrySet().stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    private static String getHashTag(String content) {
        Pattern pattern = Pattern.compile("#\\w+\\b");
        Matcher matcher = pattern.matcher(content);

        if (matcher.find()) {
            return matcher.group();
        }

        return null;
    }

    public static List<Integer> topCommentersLastMonth(List<UserAction> actions) {
        LocalDate today = LocalDate.of(2024, 10, 10);
        LocalDate lastMonth = today.plusMonths(-1);

        return actions.stream()
                .filter(action ->
                        action.date().isAfter(lastMonth)
                                && action.date().isBefore(today)
                                && !action.content().isEmpty())
                .collect(Collectors.groupingBy(UserAction::id, Collectors.counting()))
                .keySet().stream()
                .limit(3)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::type, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                e -> Math.round(e.getValue() * 100.0 / actions.size() * 100) / 100.0
                        )
                );
    }
}
