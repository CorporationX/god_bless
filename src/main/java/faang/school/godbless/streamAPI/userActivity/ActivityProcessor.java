package faang.school.godbless.streamAPI.userActivity;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ActivityProcessor {
    List<UserAction> userActions;

    public ActivityProcessor(List<UserAction> actions) {
        if (actions == null) {
            throw new IllegalArgumentException("List of users actions must be non-valued!");
        }

        userActions = actions;
    }

    public Optional<List<String>> getTop10ActiveUsersByActionType(ActionType actionType) {
        if (actionType == null) {
            return Optional.empty();
        }

        var userActionsGroupedByUser = userActions.stream()
                .filter(userAction -> userAction.actionType().equals(actionType))
                .collect(Collectors.groupingBy(UserAction::userName));

        var usersByActivityCount = userActionsGroupedByUser.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().size()
                ));

        return Optional.of(usersByActivityCount.entrySet().stream()
                .sorted((u1, u2) -> Integer.compare(u2.getValue(), u1.getValue()))
                .map(Map.Entry::getKey)
                .limit(10)
                .toList());
    }

    public List<String> getTop5MostPopularThemes() {
        var hashtags = userActions.stream()
                .map(UserAction::content)
                .map(content -> content.split("[\\s,.!?;:()]+"))
                .flatMap(Arrays::stream)
                .filter(word -> word.matches("#.*"))
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));

        return hashtags.entrySet().stream()
                .sorted((h1, h2) -> Long.compare(h2.getValue(), h1.getValue()))
                .map(Map.Entry::getKey)
                .limit(5)
                .toList();
    }

    public List<String> getTop3MostActiveCommentators() {
        var oneMonthAgo = LocalDateTime.now().minusMonths(1);

        var commentators = userActions.stream()
                .filter(userAction -> userAction.actionType().equals(ActionType.COMMENT))
                .filter(userAction -> userAction.actionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::userName));

        var commentatorsByNumberOfComments = commentators.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().size()
                ));

        return commentatorsByNumberOfComments.entrySet().stream()
                .sorted((c1, c2) -> Integer.compare(c2.getValue(), c1.getValue()))
                .map(Map.Entry::getKey)
                .limit(3)
                .toList();
    }


    /**
     * Returns the map, where key is action type and value is percentage from all actions of this type.
     */
    public Map<ActionType, Double> getAnalytics() {
        var totalActionsNumber = userActions.size();

        var actionsGroupedByType = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType));

        return actionsGroupedByType.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> Math.floor((double) entry.getValue().size() / totalActionsNumber * 10_000) / 100
                ));
    }
}
