package faang.school.godbless.stream.analysis;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityAnalyzerTest {

    private final ActivityAnalyzer activityAnalyzer = new ActivityAnalyzer();

    @Test
    void findTopTenActiveUsers() {
        var comments = List.of(
                new UserAction("7777777777777", "Henry", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("7777777777777", "Henry", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("7777777777777", "Henry", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("7777777777777", "Henry", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("dsfgxc", "Michael", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("dsfgxc", "Michael", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("dsfgxc", "Michael", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("dsfgxc", "Michael", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("dsfgxc", "Michael", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("1", "Paul", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("1", "Paul", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("1", "Paul", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("1", "Paul", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("2", "Ringo", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("2", "Ringo", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("2", "Ringo", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("2", "Ringo", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("2", "Ringo", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("3", "Mathew", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("3", "Mathew", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("3", "Mathew", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("3", "Mathew", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("3", "Mathew", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("3", "Mathew", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("3", "Mathew", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("3", "Mathew", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("3", "Mathew", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("4", "Nolan", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("5", "Gregory", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("6", "Logan", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("7", "Paul", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("d1ksa7yf", "Andrew", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("d1ksa7yf", "Andrew", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("d1ksa7yf", "Andrew", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("f2bia7sd", "Simon", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("f2bia7sd", "Simon", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("sdfnu232", "Henry", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("sdfnu232", "Henry", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("sdfnu232", "Henry", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("sdfnu232", "Henry", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("sdfnu232", "Henry", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("sdfnu232", "Henry", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("sdfnu232", "Henry", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("sdfnu232", "Henry", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("111111111111", "Mike", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("111111111111", "Mike", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("111111111111", "Mike", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("111111111111", "Mike", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("222222222", "Steve", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("222222222", "Steve", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("222222222", "Steve", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("222222222", "Steve", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("222222222", "Steve", ActionType.COMMENT, LocalDateTime.now(), "BS")
        );

        var mostActiveUsers = activityAnalyzer.findTopTenActiveUsers(comments);

        assertEquals(10, mostActiveUsers.size());
        assertEquals("3", mostActiveUsers.get(0));
        assertEquals("f2bia7sd", mostActiveUsers.get(mostActiveUsers.size() - 1));
    }

    @Test
    void findTopThreeCommentAuthorsLastMonth() {
        var actions = List.of(
                new UserAction("7777777777777", "Henry", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("7777777777777", "Henry", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("7777777777777", "Henry", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("7777777777777", "Henry", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("dsfgxc", "Michael", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("dsfgxc", "Michael", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("dsfgxc", "Michael", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("dsfgxc", "Michael", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("dsfgxc", "Michael", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("1", "Paul", ActionType.COMMENT, LocalDateTime.of(2023, 11, 22, 0, 0), "BS"),
                new UserAction("1", "Paul", ActionType.COMMENT, LocalDateTime.of(2023, 11, 22, 0, 0), "BS"),
                new UserAction("1", "Paul", ActionType.COMMENT, LocalDateTime.of(2023, 11, 22, 0, 0), "BS"),
                new UserAction("1", "Paul", ActionType.COMMENT, LocalDateTime.of(2023, 11, 22, 0, 0), "BS"),
                new UserAction("1", "Paul", ActionType.COMMENT, LocalDateTime.of(2023, 11, 22, 0, 0), "BS"),
                new UserAction("1", "Paul", ActionType.COMMENT, LocalDateTime.of(2023, 11, 22, 0, 0), "BS"),
                new UserAction("1", "Paul", ActionType.COMMENT, LocalDateTime.of(2023, 11, 22, 0, 0), "BS"),
                new UserAction("1", "Paul", ActionType.COMMENT, LocalDateTime.of(2023, 11, 22, 0, 0), "BS"),
                new UserAction("2", "Paul", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("2", "Paul", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("3", "Paul", ActionType.POST, LocalDateTime.now(), "BS"),
                new UserAction("4", "Paul", ActionType.POST, LocalDateTime.now(), "BS"),
                new UserAction("5", "Paul", ActionType.POST, LocalDateTime.now(), "BS")
        );

        var topCommentAuthorsLastMonth = activityAnalyzer.findTopThreeCommentAuthorsLastMonth(actions);

        assertEquals(3, topCommentAuthorsLastMonth.size());
        assertEquals("dsfgxc", topCommentAuthorsLastMonth.get(0));
        assertEquals("2", topCommentAuthorsLastMonth.get(topCommentAuthorsLastMonth.size() - 1));
    }

    @Test
    void findPercentageOfActionTypes() {
        var actions = List.of(
                new UserAction("1", "Henry", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("1", "Henry", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("1", "Henry", ActionType.COMMENT, LocalDateTime.now(), "BS"),
                new UserAction("2", "Michael", ActionType.POST, LocalDateTime.now(), "BS"),
                new UserAction("2", "Michael", ActionType.POST, LocalDateTime.now(), "BS"),
                new UserAction("2", "Michael", ActionType.POST, LocalDateTime.now(), "BS"),
                new UserAction("3", "Sam", ActionType.SHARE, LocalDateTime.now(), "BS"),
                new UserAction("3", "Sam", ActionType.SHARE, LocalDateTime.now(), "BS"),
                new UserAction("3", "Sam", ActionType.SHARE, LocalDateTime.now(), "BS")
        );

        var percentageOfActionTypes = activityAnalyzer.findPercentageOfActionTypes(actions);
        assertEquals(3, percentageOfActionTypes.size());
        assertEquals("33.3", new DecimalFormat("#.#").format(percentageOfActionTypes.get(ActionType.COMMENT)));
        assertEquals("33.3", new DecimalFormat("#.#").format(percentageOfActionTypes.get(ActionType.POST)));
        assertEquals("33.3", new DecimalFormat("#.#").format(percentageOfActionTypes.get(ActionType.SHARE)));
    }

    @Test
    void findTopFiveHotTopicsInPostsAndComments() {
        var actions = List.of(
                new UserAction("1", "Henry", ActionType.POST, LocalDateTime.now(), "#Euro2024 is starting today in Germany"),
                new UserAction("2", "Henry", ActionType.SHARE, LocalDateTime.now(), "#Euro2024 is starting today in Germany"),
                new UserAction("3", "Henry", ActionType.POST, LocalDateTime.now(), "Germany is claimed as potential winner on #Euro2024"),
                new UserAction("4", "Henry", ActionType.POST, LocalDateTime.now(), "#Oscars is a lame festival"),
                new UserAction("5", "Henry", ActionType.POST, LocalDateTime.now(), "Leonardo DiCaprio doesn't win #Oscars again"),
                new UserAction("6", "Henry", ActionType.POST, LocalDateTime.now(), "#Munich is a nice city"),
                new UserAction("7", "Henry", ActionType.POST, LocalDateTime.now(), "#Munich is the most popular destination in Germany"),
                new UserAction("8", "Henry", ActionType.POST, LocalDateTime.now(), "#Munich is the biggest city in Germany"),
                new UserAction("9", "Henry", ActionType.POST, LocalDateTime.now(), "#Munich has the best cars"),
                new UserAction("10", "Henry", ActionType.COMMENT, LocalDateTime.now(), "#Euro2024 is starting today in Germany"),
                new UserAction("10", "Henry", ActionType.COMMENT, LocalDateTime.now(), "#BMW producer too much cars"),
                new UserAction("10", "Henry", ActionType.COMMENT, LocalDateTime.now(), "#BMW is huge today"),
                new UserAction("10", "Henry", ActionType.COMMENT, LocalDateTime.now(), "#BMW hires the best people"),
                new UserAction("10", "Henry", ActionType.COMMENT, LocalDateTime.now(), "#BMW takes on Mercedes to be the best"),
                new UserAction("10", "Henry", ActionType.COMMENT, LocalDateTime.now(), "#BMW"),
                new UserAction("10", "Henry", ActionType.COMMENT, LocalDateTime.now(), "#2030 is soon"),
                new UserAction("10", "Henry", ActionType.COMMENT, LocalDateTime.now(), "#2030 doesn't look nice"),
                new UserAction("10", "Henry", ActionType.COMMENT, LocalDateTime.now(), "#2030 is future"),
                new UserAction("10", "Henry", ActionType.COMMENT, LocalDateTime.now(), "#2030"),
                new UserAction("10", "Henry", ActionType.COMMENT, LocalDateTime.now(), "#2030"),
                new UserAction("10", "Henry", ActionType.COMMENT, LocalDateTime.now(), "#2030"),
                new UserAction("10", "Henry", ActionType.COMMENT, LocalDateTime.now(), "#2031"),
                new UserAction("10", "Henry", ActionType.COMMENT, LocalDateTime.now(), "#2032"),
                new UserAction("10", "Henry", ActionType.COMMENT, LocalDateTime.now(), "#2033"),
                new UserAction("10", "Henry", ActionType.COMMENT, LocalDateTime.now(), "#2034"),
                new UserAction("10", "Henry", ActionType.COMMENT, LocalDateTime.now(), "#2035")
        );

        var topHotTopicsInPostsAndComments = activityAnalyzer.findTopFiveHotTopicsInPostsAndComments(actions);

        assertEquals(5, topHotTopicsInPostsAndComments.size());
        assertEquals("#2030", topHotTopicsInPostsAndComments.get(0));
        assertEquals("#Oscars", topHotTopicsInPostsAndComments.get(topHotTopicsInPostsAndComments.size() - 1));
    }
}