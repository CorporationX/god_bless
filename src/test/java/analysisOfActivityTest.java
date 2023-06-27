import faang.school.godbless.analysisOfUserActivity.AnalysisOfActivity;
import faang.school.godbless.analysisOfUserActivity.User;
import faang.school.godbless.analysisOfUserActivity.actionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class analysisOfActivityTest {
    AnalysisOfActivity analysisOfActivity;
    List<User> actionList;

    @BeforeEach
    public void init() {
        analysisOfActivity = new AnalysisOfActivity();
        actionList = List.of(
                new User(1, "Misha", actionType.COMMENT, LocalDateTime.now(), "#coding"),
                new User(2, "Sania", actionType.POST, LocalDateTime.now(), "#bloging"),
                new User(3, "Pavel", actionType.SHARE, LocalDateTime.now(), "#sport"),
                new User(4, "Anton", actionType.POST, LocalDateTime.now(), "#money"),
                new User(5, "Mario", actionType.LIKE, LocalDateTime.now(), "#coding"),
                new User(6, "Fedor", actionType.SHARE, LocalDateTime.now(), "#chymistry"),
                new User(7, "Anna", actionType.COMMENT, LocalDateTime.now(), "#school"),
                new User(8, "Igor", actionType.LIKE, LocalDateTime.now(), "#sport"),
                new User(9, "Elizaveta", actionType.SHARE, LocalDateTime.now(), "#freelance"),
                new User(10, "Nikolai", actionType.COMMENT, LocalDateTime.now(), "#coding"),
                new User(11, "Mark", actionType.LIKE, LocalDateTime.now(), "#coding"),
                new User(12, "Misha", actionType.SHARE, LocalDateTime.now(), "#money"),
                new User(13, "Pavel", actionType.POST, LocalDateTime.now(), "#sport"),
                new User(14, "Mario", actionType.COMMENT, LocalDateTime.now(), "#sport"),
                new User(15, "Igor", actionType.LIKE, LocalDateTime.now(), "#cars"),
                new User(16, "Max", actionType.SHARE, LocalDateTime.now(), "#bloging"),
                new User(18, "Anna", actionType.LIKE, LocalDateTime.now(), "#chymistry"),
                new User(19, "Ivan", actionType.SHARE, LocalDateTime.now(), "#coding"),
                new User(20, "Irina", actionType.COMMENT, LocalDateTime.now(), "#school")
        ); // share6 like5 comment5 post3 // coding4 sport3 money2
    }

    @Test
    public void top10ActiveUsersTest() {
        int expectedListSize = 10;
        List<Integer> test = analysisOfActivity.top10ActiveUsers(actionList);
        assertEquals(expectedListSize, test.size());
        assertEquals(2, (int) test.get(1));
    }

    @Test
    public void top5MostPopularTopicsTest() {
        int expectedListSize = 5;
        List<String> expected = List.of("#coding", "#sport", "#money", "#school", "#chymistry");
        List<String> testMethod = analysisOfActivity.top5MostPopularTopics(actionList);
        assertEquals(expectedListSize, testMethod.size());
        assertEquals(expected, testMethod);
    }

    @Test
    public void top3UsersLeftMostCommentsTest() {
        int expectedListSize = 3;
        List<Integer> expected = List.of(1, 20, 7);
        List<Integer> testMethod = analysisOfActivity.top3UsersLeftMostComments(actionList);
        assertEquals(expectedListSize, expected.size());
        assertEquals(expected, testMethod);

    }
    @Test
    public void percentageOfActionsTest() {
        List<String> expected =  List.of("LIKE: 26,3%", "POST: 15,8%", "SHARE: 31,6%", "COMMENT: 26,3%");
        List<String> testMethod = analysisOfActivity.percentageOfActions(actionList);
        assertEquals(expected, testMethod);
    }
}
