package faang.school.godbless.activity_analysis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActionStatisticsTest {

    private ActionStatistics actionStatistics;
    private List<UserAction> actionList;

    @BeforeEach
    void setUp(){
        actionStatistics = new ActionStatistics();
        actionList = new ArrayList<>(List.of(
                new UserAction(1," ", ActionType.LIKE, LocalDateTime.now()),
                new UserAction(2,"#sport", ActionType.COMMENT, LocalDateTime.now()),
                new UserAction(3,"#sport #film", ActionType.POST, LocalDateTime.now()),
                new UserAction(1,"#sport ", ActionType.SHARE, LocalDateTime.now()),
                new UserAction(2,"#music ", ActionType.COMMENT, LocalDateTime.now()),
                new UserAction(3,"#music ", ActionType.COMMENT, LocalDateTime.now()),
                new UserAction(3,"#books ", ActionType.COMMENT, LocalDateTime.now()),
                new UserAction(1," ", ActionType.LIKE, LocalDateTime.now()),
                new UserAction(2," ", ActionType.COMMENT, LocalDateTime.now()),
                new UserAction(4,"#sport ", ActionType.SHARE, LocalDateTime.now()),
                new UserAction(5,"#music ", ActionType.POST, LocalDateTime.now()),
                new UserAction(6,"#music ", ActionType.POST, LocalDateTime.now()),
                new UserAction(7," ", ActionType.LIKE, LocalDateTime.now()),
                new UserAction(8,"#sport #film", ActionType.POST, LocalDateTime.now()),
                new UserAction(9,"#sport ", ActionType.SHARE, LocalDateTime.now()),
                new UserAction(10,"#music ", ActionType.POST, LocalDateTime.now()),
                new UserAction(11,"#sport ", ActionType.SHARE, LocalDateTime.now()),
                new UserAction(12,"#music ", ActionType.COMMENT, LocalDateTime.now()),
                new UserAction(3,"#music ", ActionType.COMMENT, LocalDateTime.now())
                ));
    }

    @Test
    void getTop10ActiveUsersTest(){
        int expectedListSize = 10;

        List<Integer> resultList = actionStatistics.getTop10ActiveUsers(actionList);

        assertEquals(expectedListSize, resultList.size());
        System.out.println(resultList.get(0));
        assertTrue(resultList.get(0) == 3);
    }

    @Test
    void getTop5HashtagsTest(){
        int expectedListSize = 3;
        List<String> expectedList = List.of("#sport", "#music", "#film");

        List<String> resultList = actionStatistics.getTop5Hashtags(actionList);

        assertEquals(expectedListSize, resultList.size());
        assertEquals(expectedList, resultList);
    }

    @Test
    void getTop3CommentersTest(){
        int expectedListSize = 3;
        List<Integer> expectedList = List.of(2, 3, 12);

        List<Integer> resultList = actionStatistics.getTop3Commenters(actionList);

        assertEquals(expectedListSize, resultList.size());
        assertEquals(expectedList, resultList);
    }

    @Test
    void getActionPercentageTest(){
        List<String> expectedList = List.of("POST: 27.8%", "SHARE: 22.2%", "COMMENT: 33.3%", "LIKE: 16.7%");
        List<String> resultList = actionStatistics.getActionPercentage(actionList);

        assertEquals(expectedList, resultList);
    }
}
