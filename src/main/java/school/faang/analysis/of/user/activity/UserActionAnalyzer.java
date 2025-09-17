package school.faang.analysis.of.user.activity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions, Integer number) {
        Map<String, Long> usersToActionCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::userName, Collectors.counting()));
        return usersToActionCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(number)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, Integer number) {
        Map<String, Long> hashtagToCount = actions.stream()
                .filter(action -> action.content() != null)
                .filter(action -> ActionType.POST.equals(action.actionType())
                        || ActionType.COMMENT.equals(action.actionType()))
                .flatMap(action -> Arrays.stream(action.content().split("\\\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return hashtagToCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(number)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, Integer number) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        Map<String, Long> userNameToCommentCount = actions.stream()
                .filter(action -> action.content() != null && ActionType.COMMENT.equals(action.actionType())
                        && action.actionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::userName, Collectors.counting()));
        return userNameToCommentCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(number)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> actions) {
        long totalActions = actions.size();

        Map<ActionType, Long> actionTypeToCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()));
        return actionTypeToCount.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / totalActions
                ));
    }
}
