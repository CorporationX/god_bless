package school.faang.users_activity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> getTopTenActiveUsers(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getTopFivePopularHashtags(List<UserAction> actions) {
        return actions.stream()
                .filter(act -> !act.getActionType().isEmpty()
                        && (act.getActionType().equals("post") || act.getActionType().equals("comment")))
                .flatMap(act -> Arrays.stream(act.getContent().split("[,.! ]")))
                .filter(str -> str.startsWith("#"))
                .collect(Collectors.groupingBy(tag -> tag, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getTopThreeCommentersLastMonth(List<UserAction> actions) {
        LocalDate threshold = LocalDate.now().minusMonths(1);
        return actions.stream()
                .filter(act -> act.getActionType().equals("comment")
                        && act.getActionDate().isAfter(threshold))
                .collect(Collectors.groupingBy(act -> act.getName(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> getActionTypePercentages(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        type -> Math.round(type.getValue() * 10e3 / actions.size()) / 100.0
                ));
    }
}
