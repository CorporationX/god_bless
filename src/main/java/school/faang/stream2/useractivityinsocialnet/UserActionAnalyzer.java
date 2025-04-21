package school.faang.stream2.useractivityinsocialnet;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@AllArgsConstructor
public class UserActionAnalyzer {
    UsersByID users;
    List<UserAction> actions;

    public List<User> getTopActiveUsers(ActionType actionType, int limitNumber) {
        return getActiveUsersByThisAction(actionType).entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .flatMap(entry -> entry.getValue().stream())
                .limit(limitNumber)
                .toList();
    }

    public Map<Integer, List<User>> getActiveUsersByThisAction (ActionType actionType){
        Map<Integer, List<User>> activeUsersByThisAction = new HashMap<>();
        Map<Integer, Integer> userActionsCount = new HashMap<>();
        actions.stream()
                .filter(action -> action.getActionType() == actionType)
                .forEach(action -> {
                    userActionsCount.merge(action.getUserID(), 1, Integer::sum);
                });
        userActionsCount.entrySet().stream()
                .forEach(entry -> {
                    Integer actionCount = entry.getValue();
                    User user = users.getUsers().get(entry.getKey());
                    activeUsersByThisAction.computeIfAbsent(actionCount, k -> new ArrayList<>())
                            .add(user);
                });
        return activeUsersByThisAction;
    }
}
