package school.faang.task_58261;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> users, int numberOfActions) {
        Map<String, Long> activeUsers = users.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return activeUsers.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(numberOfActions)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> users, int numberOfActions) {
        Map<String, Long> popularHashtags = users.stream()
                .filter(action -> action.getContent() != null
                        && ActionType.POST.equals(action.getActionType())
                        || ActionType.COMMENT.equals(action.getActionType()))
                .flatMap(action -> Arrays.stream(action.getContent().split("////s+")))
                .filter(a -> a.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return popularHashtags.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(numberOfActions)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> users, int numberOfActions) {
        LocalDate todayIsMinus = LocalDate.now().minusMonths(1);
        Map<String, Long> commenters = users.stream()
                .filter(action -> ActionType.COMMENT.equals(action.getActionType())
                        && action.getActionDate().isAfter(todayIsMinus))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return commenters.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(numberOfActions)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> users) {
        long actionSize = users.size();
        Map<ActionType, Long> actionTypeToCount = users.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));
        return actionTypeToCount.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey().name(),
                        ent -> (ent.getValue().doubleValue() * 100) / actionSize
                ));
    }

}
