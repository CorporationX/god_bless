package faang.school.godbless.user_activity_analysis;

import faang.school.godbless.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ActionAnalysis {

    public List<Integer> findTop10ActiveUsers(List<UserAction> usersActions) {
        return usersActions.stream().collect(Collectors.groupingBy(UserAction :: getId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((s1, s2) -> (int)(s1.getValue() - s2.getValue()))
                .limit(10)
                .map(Map.Entry :: getKey )
                .collect(Collectors.toList());
    }

    public List<String> findTop5Topics(List<UserAction> usersActions) {
        return usersActions.stream().filter(usersAction -> usersAction.getActionType() == ActionType.COMMENT || usersAction.getActionType() == ActionType.POST)
                .collect(Collectors.groupingBy(UserAction :: getContent, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((s1, s2) -> (int)(s1.getValue() - s2.getValue()))
                .limit(5)
                .map(Map.Entry :: getKey )
                .collect(Collectors.toList());
    }

    public List<Integer> findTop3CommentUser(List<UserAction> usersActions) {
        return usersActions.stream().filter(usersAction -> usersAction.getActionType() == ActionType.COMMENT)
                .filter(userAction -> userAction.getActionDate().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction :: getId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((s1, s2) -> (int)(s1.getValue() - s2.getValue()))
                .limit(3)
                .map(Map.Entry :: getKey )
                .collect(Collectors.toList());
    }

    public Map<ActionType, Double> findAShareActionType(List<UserAction> userActions) {
        Map<ActionType, Long> actionTypeCount =  userActions.stream()
                .collect(Collectors.groupingBy(UserAction :: getActionType, Collectors.counting()));

        int sumAllActions = actionTypeCount.entrySet().stream()
                .map(Map.Entry :: getValue)
                .mapToInt(Long::intValue).sum();

        return actionTypeCount.entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> (double)(entry.getValue())*100 / sumAllActions));
    }
}
