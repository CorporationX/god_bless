package school.faang.user.action.analyzer;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionStatistics {

    private List<String> getTopFromUsersWithActivity(Map<String, Long> userWithActivity, int n) {
        return userWithActivity.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> getTopActiveUsers(List<UserAction> userActions, int n) {
        return getTopFromUsersWithActivity(
                userActions
                        .stream()
                        .collect(Collectors.groupingBy(UserAction::getUsername, Collectors.counting())),
                n);
    }

    public List<String> getTopPopularTheme(List<UserAction> userActions, int n) {
        return getTopFromUsersWithActivity(
                userActions
                        .stream()
                        .filter(userAction -> !userAction.getContent().isBlank()
                                && userAction.getContent().startsWith("#"))
                        .collect(Collectors.groupingBy(UserAction::getUsername, Collectors.counting())),
                n);
    }

    public List<String> getTopActiveUsersWithComment(List<UserAction> userActions, int n) {
        return getTopFromUsersWithActivity(
                userActions
                        .stream()
                        .filter(userAction -> userAction.getActionType().equals(ActionType.COMMENT)
                                && ChronoUnit.MONTHS.between(LocalDate.now(), userAction.getActionDate()) <= 1)
                        .collect(Collectors.groupingBy(UserAction::getUsername, Collectors.counting())),
                n);
    }

    public Map<ActionType, Double> getPercentageOfActionType(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.collectingAndThen(
                                Collectors.counting(),
                                count -> count * 100.0 / userActions.size()
                        )
                ));
    }
}
