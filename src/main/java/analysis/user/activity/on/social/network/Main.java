package analysis.user.activity.on.social.network;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<UserAction> userActions = makeUserActions();

        System.out.println(UserAction.getTop10ActiveUsers(userActions));
        System.out.println(UserAction.getTop5Topic(userActions));
        System.out.println(UserAction.getTop3ActiveCommentators(userActions));
        System.out.println(UserAction.getPercentActionsByType(userActions));
    }

    private static List<UserAction> makeUserActions() {
        return Arrays.asList(
                new UserAction(1, ActionType.COMMENT, LocalDateTime.now(), "Content"),
                new UserAction(1, ActionType.LIKE, LocalDateTime.now(), "Content #Java"),
                new UserAction(1, ActionType.SHARE, LocalDateTime.now(), "Content #Java"),
                new UserAction(1, ActionType.COMMENT, LocalDateTime.now(), "Content #Java"),
                new UserAction(1, ActionType.COMMENT, LocalDateTime.now(), "Content"),
                new UserAction(2, ActionType.COMMENT, LocalDateTime.now(), "Content #Java"),
                new UserAction(2, ActionType.COMMENT, LocalDateTime.now(), "Content #qwe"),
                new UserAction(2, ActionType.COMMENT, LocalDateTime.now(), "Content"),
                new UserAction(2, ActionType.COMMENT, LocalDateTime.now(), "Content #Java"),
                new UserAction(3, ActionType.POST, LocalDateTime.now(), "Content"),
                new UserAction(3, ActionType.POST, LocalDateTime.now(), "Content"),
                new UserAction(4, ActionType.POST, LocalDateTime.now(), "Content #qwe"),
                new UserAction(5, ActionType.POST, LocalDateTime.now(), "Content"),
                new UserAction(5, ActionType.POST, LocalDateTime.now(), "Content #qwe"),
                new UserAction(5, ActionType.POST, LocalDateTime.now(), "Content"),
                new UserAction(5, ActionType.POST, LocalDateTime.now(), "Content"),
                new UserAction(5, ActionType.POST, LocalDateTime.now(), "Content"),
                new UserAction(5, ActionType.POST, LocalDateTime.now(), "Content"),
                new UserAction(6, ActionType.POST, LocalDateTime.now(), "Content #Java"),
                new UserAction(7, ActionType.POST, LocalDateTime.now(), "Content"),
                new UserAction(8, ActionType.POST, LocalDateTime.now(), "Content"),
                new UserAction(9, ActionType.POST, LocalDateTime.now(), "Content #Java"),
                new UserAction(10, ActionType.POST, LocalDateTime.now(), "Content #Java"),
                new UserAction(11, ActionType.POST, LocalDateTime.now(), "Content"),
                new UserAction(11, ActionType.COMMENT, LocalDateTime.now().minusMonths(2), "Content")
        );
    }
}
