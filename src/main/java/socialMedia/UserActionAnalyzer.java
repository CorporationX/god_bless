package socialMedia;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions, int number) {
        Map<String, Long> usersToActionsCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return usersToActionsCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(number)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int number) {
        Map<String, Long> wordToCount = actions.stream()
                .filter(action -> action.getContent() != null && ActionType.POST.equals(action.getActionType())
                        || ActionType.COMMENT.equals(action.getActionType()))
                .flatMap(action -> Arrays.stream(action.getContent().split("\\\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return wordToCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(number)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int number) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        Map<String, Long> userNameToCommentCount = actions.stream()
                .filter(action -> ActionType.COMMENT.equals(action.getActionType()) && action.getActionDate()
                        .isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return userNameToCommentCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(number)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        long totalActions = actions.size();

        Map<String, Long> actionTypeToCount = actions.stream()
                .collect(Collectors.groupingBy(action -> action.getActionType().name(), Collectors.counting()));
        return actionTypeToCount.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / totalActions
                ));
    }
}

