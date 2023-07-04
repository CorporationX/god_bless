package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActionsAnalyserTest {
    ActionsAnalyser analyser;
    List<UserAction> actions;

    @BeforeEach
    void setUp() {
        analyser = new ActionsAnalyser();
        actions = Arrays.asList(
                new UserAction(1, ActionType.POST, new Date(), "Post#it#dev"),
                new UserAction(2, ActionType.COMMENT, new Date(), "Comment #best"),
                new UserAction(2, ActionType.LIKE, new Date(), "Like"),
                new UserAction(3, ActionType.POST, new Date(), "Post #fear"),
                new UserAction(3, ActionType.SHARE, new Date(), "Share"),
                new UserAction(2, ActionType.POST, new Date(), "Post #it"),
                new UserAction(2, ActionType.COMMENT, new Date(), "Share"),
                new UserAction(3, ActionType.COMMENT, new Date(), "Post #it")
        );
    }

    @Test
    void testGetTop10Users() {
        var topUsers = analyser.getTop10Users(actions);
        assertEquals(Arrays.asList(2, 3, 1), topUsers);
    }

    @Test
    void testGetTop5Topics() {
        var topTopics = analyser.getTop5Topics(actions);
        System.out.println(topTopics);
        assertEquals(Arrays.asList("#it", "#dev", "#best", "#fear"), topTopics);
    }

    @Test
    void testGetTop3Users() {
        var topUsers = analyser.getTop3Users(actions);
        assertEquals(topUsers, Arrays.asList(2, 3));
    }

    @ParameterizedTest
    @CsvSource({
            "SHARE, 12.5",
            "LIKE, 12,5",
            "POST, 37.5",
            "COMMENT, 37.5"
    })
    void testCalculatePercents(ActionType type, double percent) {
        var percents = analyser.calculatePercents(actions);
        assertEquals(percents.get(type), percent, 1);
    }
}