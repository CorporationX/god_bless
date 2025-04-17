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
        UserAction userNNAction1PostWork =
                new UserAction(1, "NN", ActionType.POST, LocalDate.now(), "#Work");
        UserAction userNNAction2CommentRun =
                new UserAction(1, "NN", ActionType.COMMENT, LocalDate.now(), "#Run");
        UserAction userNNAction3CommentSleep =
                new UserAction(1, "NN", ActionType.COMMENT, LocalDate.now(), "#Sleep");
        UserAction userNNAction4ShareWake =
                new UserAction(1, "NN", ActionType.SHARE, LocalDate.of(1998, 11, 1), "#Wake");
        UserAction userMAAction4PostWork =
                new UserAction(2, "MA", ActionType.POST, LocalDate.now(), "#Work");
        UserAction userMAAction1CommentSleep =
                new UserAction(2, "MA", ActionType.COMMENT, LocalDate.now(), "#Sleep");
        UserAction userMAAction2PostWake =
                new UserAction(2, "MA", ActionType.POST, LocalDate.now(), "#Wake");
        UserAction userMAAction3ShareWake =
                new UserAction(2, "MA", ActionType.SHARE, LocalDate.of(1998, 11, 1), "#Wake");
        UserAction userVKAction1PostWork =
                new UserAction(3, "VK", ActionType.POST, LocalDate.now(), "#Work");
        UserAction userVKAction2LikeF22 =
                new UserAction(3, "VK", ActionType.LIKE, LocalDate.now(), "#F22");
        UserAction userVKAction3CommentF22 =
                new UserAction(3, "VK", ActionType.COMMENT, LocalDate.now(), "#F22");
        UserAction userVKAction4ShareWake =
                new UserAction(3, "VK", ActionType.SHARE, LocalDate.of(1998, 11, 1), "#Wake");
        UserAction userTAAction4PostWork =
                new UserAction(4, "TA", ActionType.POST, LocalDate.now(), "#Work");
        UserAction userTAAction1CommentSleep =
                new UserAction(4, "TA", ActionType.COMMENT, LocalDate.now(), "#Sleep");
        UserAction userTAAction2PostWork =
                new UserAction(4, "TA", ActionType.POST, LocalDate.now(), "#Work");
        UserAction userTAAction3ShareWake =
                new UserAction(4, "TA", ActionType.SHARE, LocalDate.of(1998, 11, 1), "#Wake");

        userActions.add(userNNAction1PostWork);
        userActions.add(userNNAction2CommentRun);
        userActions.add(userNNAction3CommentSleep);
        userActions.add(userNNAction4ShareWake);
        userActions.add(userNNAction1PostWork);
        userActions.add(userNNAction2CommentRun);
        userActions.add(userNNAction3CommentSleep);
        userActions.add(userNNAction4ShareWake);

        userActions.add(userMAAction4PostWork);
        userActions.add(userMAAction2PostWake);
        userActions.add(userMAAction3ShareWake);
        userActions.add(userMAAction4PostWork);
        userActions.add(userMAAction3ShareWake);
        userActions.add(userMAAction1CommentSleep);

        userActions.add(userVKAction1PostWork);
        userActions.add(userVKAction2LikeF22);
        userActions.add(userVKAction3CommentF22);
        userActions.add(userVKAction1PostWork);
        userActions.add(userVKAction2LikeF22);
        userActions.add(userVKAction3CommentF22);
        userActions.add(userVKAction4ShareWake);


        userActions.add(userTAAction1CommentSleep);
        userActions.add(userTAAction2PostWork);
        userActions.add(userTAAction3ShareWake);
        userActions.add(userTAAction4PostWork);
    }

    @Test
    public void countStuff() {
        int work = 0, sleep = 0, comment = 0, share = 0, like = 0, post = 0, wake = 0, run = 0, f22 = 0;

        for (UserAction userAction : userActions) {
            switch (userAction.getActionType()) {
                case POST:
                    post++;
                    break;
                case COMMENT:
                    comment++;
                    break;
                case SHARE:
                    share++;
                    break;
                case LIKE:
                    like++;
                    break;
            }
            switch (userAction.getContent()) {
                case "#Work":
                    work++;
                    break;
                case "#Sleep":
                    sleep++;
                    break;
                case "#Run":
                    run++;
                    break;
                case "#Wake":
                    wake++;
                    break;
                case "#F22":
                    f22++;
                    break;
            }
        }

        Map<String, Integer> counts = new HashMap<>();
        counts.put("#WORK", work);
        counts.put("#SLEEP", sleep);
        counts.put("COMMENT", comment);
        counts.put("SHARE", share);
        counts.put("LIKE", like);
        counts.put("POST", post);
        counts.put("#WAKE", wake);
        counts.put("#RUN", run);

        System.out.println(counts);
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
