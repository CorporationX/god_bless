package faang.school.godbless.sprint2.analysisOfUserActivity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnalysisOfUserActivityTest {
    private AnalysisOfUserActivity userActivity;
    private final User user1 = new User(1, "Имя 1");
    private final User user2 = new User(2, "Имя 2");
    private final User user3 = new User(3, "Имя 3");
    private final User user4 = new User(4, "Имя 4");
    private final User user5 = new User(5, "Имя 5");
    private final User user6 = new User(6, "Имя 6");
    private final User user7 = new User(7, "Имя 7");
    private final User user8 = new User(8, "Имя 8");
    private final User user9 = new User(9, "Имя 9");
    private final User user10 = new User(10, "Имя 10");
    private final User user11 = new User(11, "Имя 11");
    private final User user12 = new User(12, "Имя 12");

    @BeforeEach
    void setUp() {
        UserAction userAction1 = new UserAction(user1, ActionType.LIKE, LocalDateTime.now());
        UserAction userAction2 = new UserAction(user1, ActionType.SHARE, LocalDateTime.now());
        UserAction userAction3 = new UserAction(user1, ActionType.COMMENT, LocalDateTime.now().minusMonths(2),
                "#Сегодня в городе #Москва");
        UserAction userAction4 = new UserAction(user1, ActionType.COMMENT, LocalDateTime.now().minusMonths(2),
                "#Cool #perfect");
        UserAction userAction5 = new UserAction(user1, ActionType.COMMENT, LocalDateTime.now().minusMonths(2),
                "#Cool #perfect");

        UserAction userAction6 = new UserAction(user2, ActionType.POST, LocalDateTime.now(),
                "#Москва #Москва #Москва");
        UserAction userAction7 = new UserAction(user2, ActionType.SHARE, LocalDateTime.now());
        UserAction userAction8 = new UserAction(user2, ActionType.SHARE, LocalDateTime.now());
        UserAction userAction9 = new UserAction(user2, ActionType.COMMENT, LocalDateTime.now(),
                "#Сегодня в городе #Москва");
        UserAction userAction10 = new UserAction(user2, ActionType.COMMENT, LocalDateTime.now(),
                "Комментрарий");
        UserAction userAction11 = new UserAction(user2, ActionType.COMMENT, LocalDateTime.now(),
                "#Сегодня в городе #Москва");
        UserAction userAction12 = new UserAction(user2, ActionType.COMMENT, LocalDateTime.now(),
                "#Сегодня #Москва #perfect");
        UserAction userAction13 = new UserAction(user2, ActionType.SHARE, LocalDateTime.now());

        UserAction userAction14 = new UserAction(user3, ActionType.LIKE, LocalDateTime.now());
        UserAction userAction15 = new UserAction(user4, ActionType.LIKE, LocalDateTime.now());
        UserAction userAction16 = new UserAction(user5, ActionType.SHARE, LocalDateTime.now());
        UserAction userAction17 = new UserAction(user5, ActionType.LIKE, LocalDateTime.now());
        UserAction userAction18 = new UserAction(user5, ActionType.SHARE, LocalDateTime.now());
        UserAction userAction19 = new UserAction(user6, ActionType.SHARE, LocalDateTime.now());
        UserAction userAction20 = new UserAction(user6, ActionType.SHARE, LocalDateTime.now());
        UserAction userAction21 = new UserAction(user7, ActionType.SHARE, LocalDateTime.now());
        UserAction userAction22 = new UserAction(user8, ActionType.SHARE, LocalDateTime.now());
        UserAction userAction23 = new UserAction(user9, ActionType.COMMENT, LocalDateTime.now(),
                "Комментарий");
        UserAction userAction24 = new UserAction(user10, ActionType.SHARE, LocalDateTime.now());
        UserAction userAction25 = new UserAction(user10, ActionType.SHARE, LocalDateTime.now());
        UserAction userAction26 = new UserAction(user10, ActionType.SHARE, LocalDateTime.now());
        UserAction userAction27 = new UserAction(user11, ActionType.SHARE, LocalDateTime.now());
        UserAction userAction28 = new UserAction(user11, ActionType.SHARE, LocalDateTime.now());
        UserAction userAction29 = new UserAction(user12, ActionType.COMMENT, LocalDateTime.now(),
                "Комментарий");
        UserAction userAction30 = new UserAction(user12, ActionType.COMMENT, LocalDateTime.now(),
                "Комментарий");


        userActivity = new AnalysisOfUserActivity(List.of(userAction1, userAction2, userAction3,
                userAction4, userAction5, userAction6, userAction7, userAction8, userAction9, userAction10,
                userAction11, userAction12, userAction13, userAction14, userAction15, userAction16, userAction17,
                userAction18, userAction19, userAction20, userAction21, userAction22, userAction23, userAction24,
                userAction25, userAction26, userAction27, userAction28, userAction29, userAction30));
    }

    @Test
    void topTenMostActiveUsers() {
        List<User> result = userActivity.topTenMostActiveUsers();
        assertEquals(10, result.size());
        List<User> expected = List.of(user2, user1, user5, user10, user6, user11, user12, user3, user4, user7);
        assertEquals(expected, result);
    }

    @Test
    void topicsForDiscussion() {
        List<String> result = userActivity.topicsForDiscussion();
        List<String> expected = List.of("#Москва", "#Сегодня", "#perfect", "#Cool");
        assertEquals(expected, result);
    }

    @Test
    void topThreeMostActiveUsersByComments() {
        List<User> result = userActivity.topThreeMostActiveUsersByComments();
        assertEquals(3, result.size());
        List<User> expected = List.of(user2, user12, user9);
        assertEquals(expected, result);
    }

    @Test
    void percentOfEachActionType() {
        Map<ActionType, Double> result = userActivity.percentOfEachActionType();
        Map<ActionType, Double> expected = Map.of(
                ActionType.SHARE, 50.0,
                ActionType.COMMENT, 33.33,
                ActionType.LIKE, 13.33,
                ActionType.POST, 3.33);
        assertEquals(expected, result);
    }
}