import faang.school.godbless.analitic.ActionType;
import faang.school.godbless.analitic.UserAction;
import faang.school.godbless.analitic.UserActionManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UserActionManagerTest {
    List<UserAction> userActions = Arrays.asList(
            new UserAction(1, "1", ActionType.COMMENT, "#1 #1"),
            new UserAction(1, "1", ActionType.POST, "#1 #1"),
            new UserAction(1, "1", ActionType.COMMENT, "#1 #1"),//6
            new UserAction(2, "2", ActionType.COMMENT, "#2 #2  #2 #2"),
            new UserAction(2, "2", ActionType.POST, "#2 #2 #2  #2"),//8
            new UserAction(3, "3", ActionType.COMMENT, "#3  #3 #3 #3 #3"),
            new UserAction(3, "3", ActionType.COMMENT, "#3  #3 #3 #3 #3"),//10
            new UserAction(4, "4", ActionType.POST, "#4 #4 #4           #4"),
            new UserAction(4, "4", ActionType.COMMENT, "#4 #4 #4 #4"),//8
            new UserAction(5, "5", ActionType.COMMENT, "#5 #5 #5 #5 #5"),//5
            new UserAction(6, "6", ActionType.POST, "#6 #6 #6 #6 #6 #6"),
            new UserAction(6, "6", ActionType.COMMENT, "#6 #6 #6 #6 #6 #6 #6"),//13
            new UserAction(7, "7", ActionType.COMMENT, "#7 #7 #7 #7 #7 #7 #7 #7 #7"),
            new UserAction(7, "7", ActionType.POST, "#7 #7 #7 #7 #7 #7 #7"),//16
            new UserAction(8, "8", ActionType.COMMENT, "8 8 8 8 8 8 8 8 8 8"),//10
            new UserAction(9, "9", ActionType.COMMENT, "9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9"),//17
            new UserAction(10, "10", ActionType.POST, "10 10 10 10 10"),//5
            new UserAction(11, "11", ActionType.COMMENT, "11 11 11 11 11 11"),
            new UserAction(11, "11", ActionType.COMMENT, "11 11 11 11 11 11"),//12
            new UserAction(12, "12", ActionType.POST, "12 12 12 12 12 12 12 12 12 12"),
            new UserAction(12, "12", ActionType.COMMENT, "12 12 12 12 12"),
            new UserAction(12, "12", ActionType.COMMENT, "12 12 12 12 12 12 12"),//22
            new UserAction(13, "13", ActionType.POST, "13"),//1
            new UserAction(14, "14", ActionType.COMMENT, "14")//1
    );

    @Test
    public void top10ActiveUsersTest() {
        List<Integer> users = UserActionManager.top10ActiveUsers(userActions);

        Assertions.assertEquals(
                Arrays.asList(
                        1, 12, 2, 3, 4, 6, 7, 11, 5, 8
                )
                , users);
    }

    @Test
    public void top5PopularThemesTest() {
        List<String> popular = UserActionManager.top5PopularThemes(userActions);

        Assertions.assertEquals(
                Arrays.asList("#7", "#6", "#3", "#4", "#2")
                , popular);
    }

    @Test
    public void top3MonthActiveUsersTest() {
        List<Integer> users = UserActionManager.top3MonthActiveUsers(userActions);

        Assertions.assertEquals(
                Arrays.asList(
                        1, 3, 11
                )
                , users);
    }

    @Test
    public void percentsOfActionsTest() {
        Map<ActionType, Double> actionTypeDoubleMap = UserActionManager.percentsOfActions(userActions);

        Assertions.assertEquals(
                Map.of(
                        ActionType.COMMENT, 2d / 3d,
                        ActionType.POST, 1d / 3d
                )
                , actionTypeDoubleMap);
    }
}
