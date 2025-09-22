package school.faang.bsj2_89498;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public List<Integer> getTopActiveUsers(List<UserAction> userActions, int n) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> getTopThemes(List<UserAction> userActions, int n) {
        Map<String, Long> themesCount = userActions.stream()
                .filter((action) -> action.getContent() != null
                        && (Actions.POST.equals(action.getActionType())
                        || Actions.COMMENT.equals(action.getActionType())))
                .flatMap((action) -> Arrays.stream(action.getContent().split(" +")))
                .filter((word) -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return themesCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<Integer> getTopCommentUsersOfLastMonth(List<UserAction> userActions, int n) {
        LocalDate periodStart = LocalDate.now().minusMonths(1);
        Map<Integer, Long> usersComments = userActions.stream()
                .filter((action) -> action.getActionDate().isAfter(periodStart)
                        && Actions.COMMENT.equals(action.getActionType()))
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()));
        return usersComments.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<Actions, Double> calculateActionPercentage(List<UserAction> userActions) {
        long totalActionsCount = userActions.size();

        Map<Actions, Long> actionTypes = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));
        return actionTypes.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / totalActionsCount));
    }
}
