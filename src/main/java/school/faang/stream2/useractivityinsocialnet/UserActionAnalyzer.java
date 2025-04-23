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

    private Map<String, Integer> countUsersActions(ActionList usersActionList) {
        return usersActionList.getActions().stream()
                .collect(Collectors.toMap(
                        action -> "id: " + action.getUserId().toString() + " - " + action.getName(),
                        action -> 1,
                        Integer::sum
                ));
    }

    public List<String> makeListOfTopPopularHashtags(ActionList usersActionList, int limitNumber) {
        Map<String, Long> usersActions = usersActionList.getActions().stream()
                .flatMap(userAction -> Arrays.stream(userAction.getContent().split("\\s+"))
                        .map(word -> word.replaceAll("[^#\\w]", ""))
                        .filter(word -> word.startsWith("#")))
                .collect(Collectors.groupingBy(hashtag -> hashtag,
                        Collectors.counting()));

        return usersActions.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
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

        Map<String, Double> mapOfActionTypePercentages =
                actionsGroupedByType.entrySet().stream()
                        .collect(Collectors.toMap(
                                entry -> entry.getKey().toString(),
                                entry -> entry.getValue().size() / allActionsCount * 100
                        ));

        return mapOfActionTypePercentages;
    }
}
