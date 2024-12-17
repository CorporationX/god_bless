package school.faang.users_activity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topTenActiveUsers(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topFivePopularHashtags(List<UserAction> actions) {
        return actions.stream()
                .filter(act -> !act.getActionType().isEmpty()
                        || act.getActionType().equals("post")
                        || act.getActionType().equals("comment"))
                .flatMap(act -> Arrays.stream(act.getContent().split("[,.! ]")))
                .filter(str -> str.startsWith("#"))
                .collect(Collectors.groupingBy(tag -> tag, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topThreeCommentersLastMonth(List<UserAction> actions) {
        return actions.stream()
                .filter(act -> act.getActionType().equals("comment")
                        && act.getActionDate().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(user -> user.getName(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }
}
