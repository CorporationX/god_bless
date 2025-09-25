package school.faang.bsj2_89498;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public List<Integer> getTopActiveUsers(List<UserAction> userActions, int resultCount) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::userId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(resultCount)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> getTopThemes(List<UserAction> userActions, int resultCount) {
        Map<String, Long> themesCount = userActions.stream()
                .filter((action) -> action.content() != null
                        && (Actions.POST.equals(action.actionType())
                        || Actions.COMMENT.equals(action.actionType())))
                .flatMap((action) -> Arrays.stream(action.content().split(" +")))
                .filter((word) -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return themesCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(resultCount)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<Integer> getTopCommentUsersOfLastMonth(List<UserAction> userActions, int resultCount) {
        LocalDate periodStart = LocalDate.now().minusMonths(1);
        Map<Integer, Long> usersComments = userActions.stream()
                .filter((action) -> action.actionDate().isAfter(periodStart)
                        && Actions.COMMENT.equals(action.actionType()))
                .collect(Collectors.groupingBy(UserAction::userId, Collectors.counting()));
        return usersComments.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(resultCount)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<Actions, Double> calculateActionPercentage(List<UserAction> userActions) {
        long totalActionsCount = userActions.size();

        Map<Actions, Long> actionTypes = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()));
        return actionTypes.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / totalActionsCount));
    }
}
