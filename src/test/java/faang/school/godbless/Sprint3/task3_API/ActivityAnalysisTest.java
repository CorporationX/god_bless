package faang.school.godbless.Sprint3.task3_API;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ActivityAnalysisTest {
    ActivityAnalysis activityAnalysis;
    List<UserAction> userAction;

    @BeforeEach
    void setUp() {
        activityAnalysis = new ActivityAnalysis();
        userAction = new ArrayList<>(List.of(
                new UserAction(1, "user1", "", ActionType.LIKE,
                        LocalDateTime.of(2023, 6, 23, 22, 00)),
                new UserAction(1, "user1", "#text1 #text2 #text3 #text4", ActionType.COMMENT,
                        LocalDateTime.of(2023, 6, 23, 22, 00)),
                new UserAction(1, "user1", "#text1 #text2 #text3", ActionType.COMMENT,
                        LocalDateTime.of(2023, 6, 23, 22, 00)),
                new UserAction(2, "user1", "#text1", ActionType.COMMENT,
                        LocalDateTime.of(2023, 5, 23, 22, 00)),
                new UserAction(2, "user1", "#text1 #text2 #text5", ActionType.POST,
                        LocalDateTime.of(2023, 5, 23, 22, 00)),
                new UserAction(2, "user1", "", ActionType.LIKE,
                        LocalDateTime.of(2023, 6, 23, 22, 00)),
                new UserAction(3, "user1", "#text1 #text2 #text3 #text4", ActionType.COMMENT,
                        LocalDateTime.of(2023, 5, 23, 22, 00)),
                new UserAction(3, "user1", "#text1 #text5", ActionType.COMMENT,
                        LocalDateTime.of(2023, 5, 23, 22, 00)),
                new UserAction(4, "user1", "", ActionType.SHARE,
                        LocalDateTime.of(2023, 5, 23, 22, 00)),
                new UserAction(4, "user1", "#text1# #text5", ActionType.COMMENT,
                        LocalDateTime.of(2023, 6, 23, 22, 00)),
                new UserAction(5, "user1", "#text1 #text2 #text3", ActionType.COMMENT,
                        LocalDateTime.of(2023, 6, 23, 22, 00)),
                new UserAction(6, "user1", "#text1", ActionType.COMMENT,
                        LocalDateTime.of(2023, 6, 23, 22, 00)),
                new UserAction(7, "user1", "#text1 #text2 #text3 #text4", ActionType.LIKE,
                        LocalDateTime.of(2023, 6, 23, 22, 00)),
                new UserAction(8, "user1", "#text1 #text6", ActionType.COMMENT,
                        LocalDateTime.of(2023, 6, 23, 22, 00)),
                new UserAction(9, "user1", "#text1", ActionType.COMMENT,
                        LocalDateTime.of(2023, 6, 23, 22, 00)),
                new UserAction(9, "user1", "#text1 #text5", ActionType.POST,
                        LocalDateTime.of(2023, 6, 23, 22, 00)),
                new UserAction(10, "user1", "#text1 #text2 #text3", ActionType.COMMENT,
                        LocalDateTime.of(2023, 6, 23, 22, 00)),
                new UserAction(11, "user1", "", ActionType.SHARE,
                        LocalDateTime.of(2023, 6, 23, 22, 00)),
                new UserAction(12, "user1", "#text1 #text2 #text6", ActionType.COMMENT,
                        LocalDateTime.of(2023, 6, 23, 22, 00)),
                new UserAction(12, "user1", "#text1 #text2 #text6", ActionType.COMMENT,
                        LocalDateTime.of(2023, 6, 23, 22, 00))
        ));
    }

    @Test
    void searchTopTenMostActiveUsersTest() {
        List<Integer> actual = activityAnalysis.searchTopTenMostActiveUsers(userAction);
        List<Integer> expected = List.of(1, 2, 3, 4, 9, 12, 5, 6, 7, 8);

        assertEquals(expected, actual);
    }

    @Test
    void searchTopFiveTopicsTest() {
        List<String> actual = activityAnalysis.searchTopFiveTopics(userAction);
        List<String> expected = List.of("#text1", "#text2", "#text3", "#text5", "#text6");

        assertEquals(expected, actual);
    }

    @Test
    void searchTopThreeCommentatorsLastMonthTest() {
        List<Integer> actual = activityAnalysis.searchTopThreeCommentatorsLastMonth(userAction);
        List<Integer> expected = List.of(1, 12, 4);

        assertEquals(expected, actual);
    }

    @Test
    void calculatePercentUserActionsTest() {
        Map<ActionType, Double> actual = activityAnalysis.calculatePercentUserActions(userAction);
        Map<ActionType, Double> expected =
                Map.of(ActionType.POST, 10.0, ActionType.COMMENT, 65.0, ActionType.SHARE, 10.0, ActionType.LIKE, 15.0);

        assertEquals(expected, actual);
    }
}