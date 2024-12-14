package faang.school.godbless.stream.socialnetwork;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SocialNetwork {

    public Map<ActionType, List<String>> findTopActiveUsers(List<UserAction> userActions) {

        Map<Integer, String> userNamesByUserId = userActions.stream().collect(
                Collectors.toMap(UserAction::getUserId, UserAction::getUserName, (id1, id2) -> id1));

        System.out.println("userNamesByUserId: " + userNamesByUserId);

        Map<ActionType, List<UserAction>> actionsByActionType = userActions.stream().collect(Collectors.groupingBy(
                UserAction::getActionType,
                Collectors.mapping(
                        Function.identity(),
                        Collectors.toList())
        ));

        Map<ActionType, List<String>> result = new HashMap<>();

        actionsByActionType.forEach((actionType, sameActions) -> {

            Map<Integer, Long> userIdsByActionAmount = sameActions.stream().collect(Collectors.groupingBy(
                    UserAction::getUserId,
                    Collectors.counting()));

            List<String> topUserIdsDescending = userIdsByActionAmount.entrySet().stream()
                    .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                    .limit(10)
                    .peek(e -> System.out.println(actionType + ": " + userNamesByUserId.get(e.getKey()) + " - " + e.getValue() + " times"))
                    .map(Map.Entry::getKey)
                    .map(userNamesByUserId::get)
                    .toList();

            result.put(actionType, topUserIdsDescending);
        });

        return result;
    }

    public Map<String, Long> findTopPopularThemes(List<UserAction> userActions) {

        Map<String, Long> themesByHashTag = userActions.stream()
                .flatMap(action -> getHashTags(action).stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return themesByHashTag.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<String, Long> findTopCommentersInLastMonth(List<UserAction> actions) {

        Map<Integer, Long> commentAmountByUsersIds = actions.stream().filter(action -> action.getActionType() == ActionType.COMMENT
                        && action.getActionDate().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(
                        UserAction::getUserId,
                        Collectors.counting()));

        Map<Integer, String> userNamesByUserId = actions.stream().collect(
                Collectors.toMap(UserAction::getUserId, UserAction::getUserName, (id1, id2) -> id1));

        return commentAmountByUsersIds.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toMap(e -> userNamesByUserId.get(e.getKey()), Map.Entry::getValue));
    }

    public Map<ActionType, Double> findActionPercentages(List<UserAction> userActions) {

        long totalActions = userActions.size();

        Map<ActionType, Long> actionCountsByType = userActions.stream().collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        return actionCountsByType.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (double) entry.getValue() / totalActions * 100.0
                ));
    }

    private List<String> getHashTags(UserAction action) {
        return Arrays.stream(action.getContent().split("\\s+"))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.toList());
    }
}

