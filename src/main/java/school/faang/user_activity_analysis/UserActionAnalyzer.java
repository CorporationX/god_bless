package school.faang.user_activity_analysis;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> users, int top) {
        if (users.isEmpty()) {
            return null;
        }
        Map<String, Long> usersActiveCount = users.stream()
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()));
        return usersActiveCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(top)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> users, int top) {
        if (users.isEmpty()) {
            return null;
        }
        Map<String, Long> typeActiveCount = users.stream()
                .filter(userAction -> userAction.content() != null
                        && (ActionType.POST.equals(userAction.actionType())
                        || ActionType.COMMENT.equals(userAction.actionType())))
                .flatMap(userAction -> Arrays.stream(userAction.content().split("\\s+")))
                .filter(string -> string.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return typeActiveCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(top)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> users, int top) {
        if (users.isEmpty()) {
            return null;
        }
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        Map<String, Long> userNameToCommentCount = users.stream()
                .filter(user -> ActionType.COMMENT.equals(user.actionType())
                        && user.actionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()));
        return userNameToCommentCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(top)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> users) {
        if (users.isEmpty()) {
            return null;
        }
        long totalAction = users.size();
        Map<ActionType, Long> actionTypeCount = users.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()));
        return actionTypeCount.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0 / totalAction)));
    }
}