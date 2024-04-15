package faang.school.godbless.BJS2_5529;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<UserAction> userActions = new ArrayList<>();
        userActions.add(new UserAction(1, "Oleg", ActionType.POST, LocalDateTime.now(), "#foryourselfandforSashka!!!"));
        userActions.add(new UserAction(1, "Oleg", ActionType.COMMENT, LocalDateTime.now(), "I like #football)"));
        userActions.add(new UserAction(1, "Oleg", ActionType.COMMENT, LocalDateTime.now(), "And #coding!"));
        userActions.add(new UserAction(2, "Vasya", ActionType.SHARE, LocalDateTime.now(), "Somebody once told me..."));
        userActions.add(new UserAction(2, "Vasya", ActionType.COMMENT, LocalDateTime.now(), "... the #world is goonna roll me."));
        userActions.add(new UserAction(2, "Vasya", ActionType.COMMENT, LocalDateTime.now(), "To be #continued..."));
        userActions.add(new UserAction(2, "Vasya", ActionType.COMMENT, LocalDateTime.now(), "To be #continued..."));
        userActions.add(new UserAction(3, "Yarik", ActionType.POST, LocalDateTime.now(), "To be #continued..."));
        userActions.add(new UserAction(3, "Yarik", ActionType.POST, LocalDateTime.now(), "To be continued..."));
        userActions.add(new UserAction(3, "Yarik", ActionType.POST, LocalDateTime.now(), "To be continued..."));
        userActions.add(new UserAction(4, "Ruslan", ActionType.COMMENT, LocalDateTime.now().minusMonths(2), "#Zenit forever!"));
        userActions.add(new UserAction(4, "Ruslan", ActionType.COMMENT, LocalDateTime.now().minusMonths(2), "#Zenit forever!"));
        userActions.add(new UserAction(4, "Ruslan", ActionType.COMMENT, LocalDateTime.now().minusMonths(2), "#Zenit forever!"));
        userActions.add(new UserAction(4, "Ruslan", ActionType.COMMENT, LocalDateTime.now().minusMonths(2), "#Zenit forever!"));
        userActions.add(new UserAction(5, "Alex", ActionType.POST, LocalDateTime.now(), "Omae wa mou shindeiru"));
        userActions.add(new UserAction(6, "Danil", ActionType.POST, LocalDateTime.now(), "NANI????"));
        userActions.add(new UserAction(6, "Danil", ActionType.LIKE, LocalDateTime.now(), ""));
        userActions.add(new UserAction(7, "Luffy", ActionType.POST, LocalDateTime.now(), "I'm gonna be #thepirateking!"));
        userActions.add(new UserAction(8, "Chel", ActionType.POST, LocalDateTime.now(), "I'm tired. I leave."));
        userActions.add(new UserAction(9, "Guy", ActionType.POST, LocalDateTime.now(), "What a beautiful #day!"));
        userActions.add(new UserAction(10, "Somebody", ActionType.COMMENT, LocalDateTime.now(), "I told him."));
        userActions.add(new UserAction(10, "Somebody", ActionType.COMMENT, LocalDateTime.now(), "I told him."));
        userActions.add(new UserAction(10, "Somebody", ActionType.COMMENT, LocalDateTime.now(), "I told him."));
        userActions.add(new UserAction(10, "Somebody", ActionType.COMMENT, LocalDateTime.now(), "I told him."));
        userActions.add(new UserAction(10, "Somebody", ActionType.COMMENT, LocalDateTime.now(), "I told him."));
        userActions.add(new UserAction(10, "Somebody", ActionType.COMMENT, LocalDateTime.now(), "I told him."));
        userActions.add(new UserAction(10, "Somebody", ActionType.COMMENT, LocalDateTime.now(), "I told him."));
        userActions.add(new UserAction(10, "Somebody", ActionType.COMMENT, LocalDateTime.now(), "I told him."));
        userActions.add(new UserAction(11, "Denis", ActionType.POST, LocalDateTime.now(), "It's time to #code"));

        System.out.println(UserAction.getTopTenActiveUsers(userActions));
        System.out.println(UserAction.getTopFivePopularThemes(userActions));
        System.out.println(UserAction.getTopThreeUsersByPostingComments(userActions));
        System.out.println(UserAction.getAnalyseActivities(userActions));
    }
}
