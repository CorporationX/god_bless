package school.faang.stream2.useractivityinsocialnet;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public List<String> makeListOfTopActiveUsers(ActionList usersActionList, int limitNumber) {
        return countUsersActions(usersActionList).entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .map(entry -> entry.getKey())
                .limit(limitNumber)
                .toList();
    }

    public Map<String, Integer> countUsersActions(ActionList usersActionList) {
        Map<String, Integer> usersActions = new HashMap<>();
        usersActionList.getActions().stream()
                .forEach(action -> {
                    usersActions.merge("id: " + action.getUserId().toString() + " - " + action.getName(),
                            1, Integer::sum);
                });
        return usersActions;
    }

    public List<String> makeListOfTopPopularHashtags(ActionList usersActionList, int limitNumber) {
        Map<String, Integer> usersActions = new HashMap<>();
        usersActionList.getActions().stream()
                .flatMap(userAction -> Arrays.stream(userAction.getContent().split("\\s+"))
                        .map(word -> word.replaceAll("[^#\\w]", ""))
                        .filter(word -> word.startsWith("#")))
                .forEach(hashtag -> usersActions.merge(hashtag, 1, Integer::sum));

        return usersActions.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(limitNumber)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> makeListOfTopCommentersLastMonth(ActionList usersActionList, int limitNumber) {
        ActionList commentersList = new UsersActionList();
        commentersList.setActions(usersActionList.getActions().stream()
                .filter(userAction -> userAction.getActionType() == ActionType.COMMENT)
                .filter(userAction -> userAction.getActionDate()
                        .isAfter(LocalDate.now().minusMonths(1)))
                .toList());
        return makeListOfTopActiveUsers(commentersList, limitNumber);
    }

    public Map<String, Double> makeMapOfActionTypePercentages(ActionList usersActionList) {
        double allActionsCount = usersActionList.getActions().size();
        Map<ActionType, List<UserAction>> actionsGroupedByType = usersActionList.getActions().stream()
                .collect(Collectors.groupingBy(UserAction::getActionType));
        Map<String, Double> mapOfActionTypePercentages = new HashMap<>();
        actionsGroupedByType.forEach((type, actionList) ->
                mapOfActionTypePercentages.put(type.toString(), actionList.size() / allActionsCount * 100));
        return mapOfActionTypePercentages;
    }
}
