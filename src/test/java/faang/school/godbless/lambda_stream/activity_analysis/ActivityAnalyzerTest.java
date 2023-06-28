package faang.school.godbless.lambda_stream.activity_analysis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ActivityAnalyzerTest {
    List<UserAction> userActions;

    @BeforeEach
    void setUp() {
        userActions = Arrays.asList(
                new UserAction(1, "post",
                        LocalDateTime.now().minus(10, ChronoUnit.DAYS), "#content1"),
                new UserAction(1, "comment",
                        LocalDateTime.now().minus(20, ChronoUnit.DAYS), "#content1"),
                new UserAction(1, "like",
                        LocalDateTime.now().minus(30, ChronoUnit.DAYS), ""),
                new UserAction(1, "post",
                        LocalDateTime.now().minus(40, ChronoUnit.DAYS), "#content1"),
                new UserAction(1, "comment",
                        LocalDateTime.now().minus(5, ChronoUnit.DAYS), "#content1"),
                new UserAction(2, "like",
                        LocalDateTime.now().minus(6, ChronoUnit.DAYS), ""),
                new UserAction(2, "post",
                        LocalDateTime.now().minus(70, ChronoUnit.DAYS), "Try it #content2"),
                new UserAction(2, "comment",
                        LocalDateTime.now().minus(8, ChronoUnit.DAYS), "#content2"),
                new UserAction(3, "post",
                        LocalDateTime.now().minus(90, ChronoUnit.DAYS), "Tuturu"),
                new UserAction(3, "post",
                        LocalDateTime.now().minus(10, ChronoUnit.DAYS), "Hello #content3"),
                new UserAction(4, "comment",
                        LocalDateTime.now().minus(11, ChronoUnit.DAYS), "#content4"),
                new UserAction(4, "comment",
                        LocalDateTime.now().minus(12, ChronoUnit.DAYS), "hi"),
                new UserAction(5, "post",
                        LocalDateTime.now().minus(13, ChronoUnit.DAYS), "#content4"),
                new UserAction(6, "comment",
                        LocalDateTime.now().minus(14, ChronoUnit.DAYS), "#content4"),
                new UserAction(7, "like",
                        LocalDateTime.now().minus(15, ChronoUnit.DAYS), ""));
    }

    @Test
    void testGetTop10ActiveUsers() {
        List<Integer> exceptedTopUsers = List.of(1, 2, 3, 4, 5, 6, 7);
        List<Integer> actualTopUsers = ActivityAnalyzer.getTop10ActiveUsers(userActions);
        assertEquals(exceptedTopUsers, actualTopUsers);
    }


    @Test
    void testGetTop5PopularHashtags() {
        List<String> exceptedHashtags = List.of("#content1", "#content4", "#content2", "#content3");
        List<String> actualHashtags = ActivityAnalyzer.getTop5PopularHashtags(userActions);
        assertEquals(exceptedHashtags, actualHashtags);
    }

    @Test
    void testGetTop3UsersByComment() {
        List<Integer> exceptedUsers = List.of(1, 4, 2);
        List<Integer> actualUsers = ActivityAnalyzer.getTop3UsersByCommentInLastMonth(userActions);
        assertEquals(exceptedUsers, actualUsers);
    }

    @Test
    void testGetPercentageOfActions() {
        Map<String, Double> exceptedPercentage =
                Map.of("post", 40.0, "comment", 40.0, "like", 20.0);
        Map<String, Double> actualPercentage = ActivityAnalyzer.getPercentageOfActions(userActions);
        assertEquals(exceptedPercentage, actualPercentage);
    }
}
