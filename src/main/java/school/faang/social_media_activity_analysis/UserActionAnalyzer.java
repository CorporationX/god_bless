package school.faang.social_media_activity_analysis;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class UserActionAnalyzer {

    // Топ-N самых активных пользователей
    public static List<String> topActiveUsers(List<UserAction> userActions, int num) {
        Map<String, Long> actionsCount = userActions
                .stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        return actionsCount.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(num).map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topContent(List<UserAction> userActions, int num) {
        Map<String, Long> hashtagCount = userActions
                .stream()
                .filter(action -> action.getContent() != null
                        && ActionType.POST.equals(action.getActionType())
                        || ActionType.COMMENT.equals(action.getActionType()))
                .flatMap(action -> Arrays.stream(action.getContent().split("\\\\s+")))
                .filter(action -> action.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return hashtagCount.entrySet()
                .stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(num).map(Map.Entry::getKey).toList();
    }

    public static List<String> topUsersByComments(List<UserAction> userActions, int num) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        Map<String, Long> commentsByUserCount = userActions
                .stream()
                .filter(action -> ActionType.COMMENT
                .equals(action.getActionType()) && action.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        return commentsByUserCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(num).map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> calculatePercentage(List<UserAction> userActions) {
        long totalActions = userActions.size();

        Map<ActionType, Long> actionTypeCounter = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        return actionTypeCounter.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey, entry -> (entry.getValue() * 100.0) / totalActions));
    }

}
