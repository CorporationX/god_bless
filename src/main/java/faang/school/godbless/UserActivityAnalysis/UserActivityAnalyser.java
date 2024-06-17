package faang.school.godbless.UserActivityAnalysis;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActivityAnalyser {
    public static void findingTheMostActiveUser(List<UserAction> userActions) {
        Map<Integer, List<UserAction>> usersActions = userActions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::id
                ));
        Map<Integer, Integer> usersActivity = usersActions.values().stream()
                .mapToInt(actions -> actions.stream()
                        //usersActions.get(actions).stream()
                        .reduce(0, (actionOne, actionTwo) -> actionOne.content().length() + actionTwo.content().length()))
                .collect(Collectors.toMap(
                        a -> a.id()
                ))
    }
}