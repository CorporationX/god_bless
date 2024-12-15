package school.faang.sprint_2.task_47279;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionService {
    private static final int PERCENTAGE_INDEX = 100;

    public List<String> geTopActiveUsers(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> getPopularTags(List<UserAction> userActions) {
        return userActions.stream()
                .filter(userAction -> userAction.content() != null
                        && "post".equals(userAction.actionType()) || "comment".equals(userAction.actionType()))
                .flatMap(userAction -> Arrays.stream(userAction.content().split(" ")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> getTopMonthCommenters(List<UserAction> userActions) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        return userActions.stream()
                .filter(userAction -> userAction.content() != null
                        && "comment".equals(userAction.actionType()) && userAction.actionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, Double> getActionTypePercentages(List<UserAction> userActions) {
        double totalActions = userActions.size();
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * PERCENTAGE_INDEX) / totalActions
                ));
    }
}
