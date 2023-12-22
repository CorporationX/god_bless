package faang.school.godbless.stream_api.task3activ_user;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<UserAction> testUserActions = Arrays.asList(
                new UserAction("User4", "like", "#Test post #Java #Programming"),
                new UserAction("User2", "comment", "#Nice post!"),
                new UserAction("User4", "post", null),
                new UserAction("User4", "post", "Another post #Programming #java"),
                new UserAction("User2", "comment", "Great topic #Java"),
                new UserAction("User6", "share", null),
                new UserAction("User1", "comment", "Great topic #Java!")
        );

        PopularApp.top10ActiveUsers(testUserActions);
        System.out.println();
        PopularApp.top5Topics(testUserActions);
        System.out.println();
        PopularApp.top3ActiveCommentedUsers(testUserActions);
        System.out.println();
        PopularApp.info(testUserActions);
    }

}
