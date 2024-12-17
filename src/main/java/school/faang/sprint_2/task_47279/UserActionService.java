package school.faang.sprint_2.task_47279;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionService {
    private static final int  SIZE_TEN = 10;
    private static final int  SIZE_FIVE = 5;
    private static final int  SIZE_THREE = 3;
    private static final int PERCENTAGE_INDEX = 100;

    public List<String> geTopActiveUsers(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(SIZE_TEN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> getPopularTags(List<UserAction> userActions) {
        return userActions.stream()
                .filter(userAction -> userAction.content() != null
                        && ActionType.POST.equals(userAction.actionType())
                        || ActionType.COMMENT.equals(userAction.actionType()))
                .flatMap(userAction -> Arrays.stream(userAction.content().split("\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(SIZE_FIVE)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> getTopMonthCommenters(List<UserAction> userActions) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        return userActions.stream()
                .filter(userAction -> userAction.content() != null
                        && ActionType.COMMENT.equals(userAction.actionType())
                        && userAction.actionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(SIZE_THREE)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, Double> getActionTypePercentages(List<UserAction> userActions) {
        double totalActions = userActions.size();
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().toString(),
                        entry -> (entry.getValue() * PERCENTAGE_INDEX) / totalActions
                ));
    }
}
