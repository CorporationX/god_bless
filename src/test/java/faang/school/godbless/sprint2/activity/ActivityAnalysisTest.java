package faang.school.godbless.sprint2.activity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActivityAnalysisTest {


    private ActivityAnalysis activityAnalysis;
    private List<User> actionList;

    @BeforeEach
    void init() {
        activityAnalysis = new ActivityAnalysis();
        actionList = (List.of(
                new User(1, "Pavel", ActionType.SHARE, LocalDateTime.now(), "#running"),
                new User(2, "Antony", ActionType.COMMENT, LocalDateTime.now(), "#coding"),
                new User(3, "Ivan", ActionType.COMMENT, LocalDateTime.now(), "#music"),
                new User(4, "Vlad", ActionType.POST, LocalDateTime.now(), "#music"),
                new User(5, "Viktor", ActionType.COMMENT, LocalDateTime.now(), "coding"),
                new User(6, "Mark", ActionType.LIKE, LocalDateTime.now(), ""),
                new User(7, "Raf", ActionType.POST, LocalDateTime.now(), "#running"),
                new User(8, "Mike", ActionType.SHARE, LocalDateTime.now(), "#music"),
                new User(9, "Stepan", ActionType.POST, LocalDateTime.now(), "#coding"),
                new User(10, "Artem", ActionType.POST, LocalDateTime.now(), "#coding"),

                new User(7, "Raf", ActionType.COMMENT, LocalDateTime.now(), "#eating"),
                new User(5, "Viktor", ActionType.POST, LocalDateTime.now(), "#eating"),
                new User(3, "Ivan", ActionType.COMMENT, LocalDateTime.now(), "#swiming"),
                new User(4, "Vlad", ActionType.COMMENT, LocalDateTime.now(), "#music"),
                new User(6, "Mark", ActionType.COMMENT, LocalDateTime.now(), "#coding"),
                new User(7, "Raf", ActionType.LIKE, LocalDateTime.now(), ""),
                new User(9, "Stepan", ActionType.SHARE, LocalDateTime.now(), "#coding")
        ));
    }

    @Test
    void findTop10ActiveUsersTest() {
        int expectedListSize = 10;

        List<Integer> result = activityAnalysis.findTop10ActiveUsers(actionList);

        assertEquals(expectedListSize, result.size());
        assertEquals(7, (int) result.get(0));
    }

    @Test
    void findTop5HashtagsTest() {
        int expectedListSize = 5;

        List<String> expected = List.of("#coding", "#music", "#running", "#eating", "#swiming");
        List<String> result = activityAnalysis.findTop5Theme(actionList);

        assertEquals(expectedListSize, result.size());
        assertEquals(expected, result);
    }

    @Test
    void findTop3CommentersTest() {
        int expectedListSize = 3;

        List<Integer> expected = List.of(3, 2, 4);
        List<Integer> result = activityAnalysis.findTop3Commenters(actionList);

        assertEquals(expectedListSize, result.size());
        assertEquals(expected, result);
    }

    @Test
    void findActionPercentageTest() {
        List<String> expected = List.of("SHARE: 17,6%", "LIKE: 11,8%", "POST: 29,4%", "COMMENT: 41,2%");
        List<String> result = activityAnalysis.findActionPercentage(actionList);

        assertEquals(expected, result);
    }

}