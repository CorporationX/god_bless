package school.faang.bjs2_70826;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserActionAnalyzerTest {
    private List<UserAction> userActions = new ArrayList<>();

    @BeforeEach
    void setUp() {
        UserAction userNaction1PostWork =
                new UserAction(1, "NN", ActionType.POST, LocalDate.now(), "#Work");
        UserAction userNaction2CommentRun =
                new UserAction(1, "NN", ActionType.COMMENT, LocalDate.now(), "#Run");
        UserAction userNaction3CommentSleep =
                new UserAction(1, "NN", ActionType.COMMENT, LocalDate.now(), "#Sleep");
        UserAction userNaction4ShareWake =
                new UserAction(1, "NN", ActionType.SHARE, LocalDate.of(1998, 11, 1), "#Wake");
        UserAction userMaction4PostWork =
                new UserAction(2, "MA", ActionType.POST, LocalDate.now(), "#Work");
        UserAction userMaction1CommentSleep =
                new UserAction(2, "MA", ActionType.COMMENT, LocalDate.now(), "#Sleep");
        UserAction userMaction2PostWake =
                new UserAction(2, "MA", ActionType.POST, LocalDate.now(), "#Wake");
        UserAction userMaction3ShareWake =
                new UserAction(2, "MA", ActionType.SHARE, LocalDate.of(1998, 11, 1), "#Wake");
        UserAction userVaction1PostWork =
                new UserAction(3, "VK", ActionType.POST, LocalDate.now(), "#Work");
        UserAction userVaction2LikeF22 =
                new UserAction(3, "VK", ActionType.LIKE, LocalDate.now(), "#F22");
        UserAction userVaction3CommentF22 =
                new UserAction(3, "VK", ActionType.COMMENT, LocalDate.now(), "#F22");
        UserAction userVaction4ShareWake =
                new UserAction(3, "VK", ActionType.SHARE, LocalDate.of(1998, 11, 1), "#Wake");
        UserAction userTaction4PostWork =
                new UserAction(4, "TA", ActionType.POST, LocalDate.now(), "#Work");
        UserAction userTaction1CommentSleep =
                new UserAction(4, "TA", ActionType.COMMENT, LocalDate.now(), "#Sleep");
        UserAction userTaction2PostWork =
                new UserAction(4, "TA", ActionType.POST, LocalDate.now(), "#Work");
        UserAction userTaction3ShareWake =
                new UserAction(4, "TA", ActionType.SHARE, LocalDate.of(1998, 11, 1), "#Wake");

        userActions.add(userNaction1PostWork);
        userActions.add(userNaction2CommentRun);
        userActions.add(userNaction3CommentSleep);
        userActions.add(userNaction4ShareWake);
        userActions.add(userNaction1PostWork);
        userActions.add(userNaction2CommentRun);
        userActions.add(userNaction3CommentSleep);
        userActions.add(userNaction4ShareWake);

        userActions.add(userMaction4PostWork);
        userActions.add(userMaction2PostWake);
        userActions.add(userMaction3ShareWake);
        userActions.add(userMaction4PostWork);
        userActions.add(userMaction3ShareWake);
        userActions.add(userMaction1CommentSleep);

        userActions.add(userVaction1PostWork);
        userActions.add(userVaction2LikeF22);
        userActions.add(userVaction3CommentF22);
        userActions.add(userVaction1PostWork);
        userActions.add(userVaction2LikeF22);
        userActions.add(userVaction3CommentF22);
        userActions.add(userVaction4ShareWake);


        userActions.add(userTaction1CommentSleep);
        userActions.add(userTaction2PostWork);
        userActions.add(userTaction3ShareWake);
        userActions.add(userTaction4PostWork);
    }

    @Test
    public void getMostActiveList() {
        List<String> result = UserActionAnalyzer.getMostActiveList(userActions);
        List<String> expected = List.of("NN", "VK", "MA");
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void getMostPopularHashTag() {
        List<String> result = UserActionAnalyzer.getMostPopularHashTag(userActions);
        List<String> expected = List.of("#Work", "#F22", "#Sleep");
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void getUsersWithMostComments() {
        List<String> result = UserActionAnalyzer.getUsersWithMostComments(userActions);
        List<String> expected = List.of("NN", "VK", "MA");
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void calculatePercentage() {
        System.out.println(UserActionAnalyzer.calculatePercentage(userActions));
        Assertions.assertEquals(100, UserActionAnalyzer.calculatePercentage(userActions)
                .values().stream().reduce((double) 0, Double::sum));
    }
}
