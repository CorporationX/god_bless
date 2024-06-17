package faang.school.godbless.UserActivityAnalysis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<UserAction> usersActions = List.of(
                new UserAction(1, "Ivan", "post", "12.04", "dsadsd"),
                new UserAction(1, "Ivan", "message", "12.06", "dsa"),
                new UserAction(2, "Ivan", "post", "12.04", "dsadsd")
        );

        UserActivityAnalyser.findingTheMostActiveUser(usersActions);
    }
}
