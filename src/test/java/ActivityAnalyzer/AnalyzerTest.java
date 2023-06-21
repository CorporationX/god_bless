package ActivityAnalyzer;

import faang.school.godbless.ActivityAnalyzer.ActionType;
import faang.school.godbless.ActivityAnalyzer.ActivityAnalyzer;
import faang.school.godbless.ActivityAnalyzer.UserAction;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnalyzerTest {
    ActivityAnalyzer activityAnalyzer = new ActivityAnalyzer();
    UserAction userAction = new UserAction(1, "Jon", ActionType.POST, LocalDate.of(2023, 5, 5), "#Bye");
    UserAction userAction1 = new UserAction(2, "Alex", ActionType.LIKE, LocalDate.of(2023, 5, 5), "#Bye sds");
    UserAction userAction2 = new UserAction(2, "Alex", ActionType.SHARE, LocalDate.of(2023, 5, 5), "sd #My sd");
    UserAction userAction3 = new UserAction(3, "Mathew", ActionType.SHARE, LocalDate.now(), "#Bye sds");
    UserAction userAction4 = new UserAction(3, "Mathew", ActionType.COMMENT, LocalDate.now(), "#Bye sds");
    UserAction userAction5 = new UserAction(3, "Mathew", ActionType.SHARE, LocalDate.now(), "sd #My sd");
    UserAction userAction6 = new UserAction(4, "Christian", ActionType.COMMENT, LocalDate.now(), "sd #My sd");
    UserAction userAction7 = new UserAction(4, "Christian", ActionType.LIKE, LocalDate.now(), "sd #My sd");
    UserAction userAction8 = new UserAction(4, "Christian", ActionType.COMMENT, LocalDate.now(), "sd #My sd");
    UserAction userAction9 = new UserAction(4, "Christian", ActionType.COMMENT, LocalDate.now(), "sd #Time sd");
    List<UserAction> userActions = List.of(userAction, userAction1, userAction2, userAction3, userAction4, userAction5, userAction6, userAction7, userAction8, userAction9);

    @Test
    void mostActiveTest() {
        Map<Integer, Long> mostActive = activityAnalyzer.mostActive(userActions);

        System.out.println(mostActive);
        assertEquals(4, mostActive.size());
    }

    @Test
    void mostPopularContentTest() {
        Map<String, Long> mostPopular = activityAnalyzer.mostPopularContent(userActions);

        System.out.println(mostPopular);
        assertEquals(5, mostPopular.get("#My"));
    }

    @Test
    void mostCommentInLastMonthTest() {
        Map<Integer, Long> mostComment = activityAnalyzer.mostCommentInLastMonth(userActions);

        System.out.println(mostComment);
        assertEquals(2, mostComment.size());
        assertEquals(3, mostComment.get(4));
    }

    @Test
    void pieOfActionsTest() {
        Map<ActionType, String> expected = Map.of(ActionType.SHARE, "30%",
                ActionType.COMMENT, "40%",
                ActionType.LIKE, "20%",
                ActionType.POST, "10%");

        Map<ActionType, String> pie = activityAnalyzer.pieOfActions(userActions);

        System.out.println(pie);
        assertEquals(expected,pie);
    }
}
