package faang.school.godbless.BJS2_22580;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Getter
@ToString
public class UserAction {

    private User user;
    private ActionType actionType;
    private LocalDateTime actionDate;
    private String content;

    public UserAction(User user, ActionType actionType, String content) {
        this.user = user;
        this.actionType = actionType;
        this.actionDate = LocalDateTime.now();
        this.content = content;
    }

    public static List<User> findTop10MostActiveUser(List<UserAction> userActions) {
        Map<User, Long> userByUserActionCount = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getUser, Collectors.counting()));

        return userByUserActionCount.entrySet().stream()
                .sorted(Map.Entry.<User, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> findTop5MostPopularTopics(List<UserAction> userActions) {
        Map<String, Long> hashtagByHashtagCount = userActions.stream()
                .flatMap(userAction -> Arrays.stream(userAction.getContent().split(" "))
                        .filter(word -> word.startsWith("#"))
                ).collect(Collectors.groupingBy(hashtag -> hashtag, Collectors.counting()));

        return hashtagByHashtagCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<User> findTop3UsersWithMostCommentsLastMonth(List<UserAction> userActions) {
        Map<User, Long> userByUserActionCount = userActions.stream()
                .filter(isValidUserAction())
                .collect(Collectors.groupingBy(UserAction::getUser, Collectors.counting()));

        return userByUserActionCount.entrySet().stream()
                .sorted(Map.Entry.<User, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    private static Predicate<UserAction> isValidUserAction() {
        LocalDateTime oneMonthAgo = LocalDateTime.now().minusMonths(1);
        return userAction -> userAction.getActionDate().isAfter(oneMonthAgo)
                && userAction.getActionType() == ActionType.COMMENT;
    }

    public static Map<ActionType, Integer> calculatePercentageActions(List<UserAction> userActions) {
        Map<ActionType, Long> actionTypeByActionCount = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        return actionTypeByActionCount.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (int) (Math.round(entry.getValue() * 100.0 / userActions.size())))
                );
    }
}
