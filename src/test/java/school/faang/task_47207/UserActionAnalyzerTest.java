package school.faang.task_47207;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserActionAnalyzerTest {
    private UserActionAnalyzer analyzer;
    private List<UserAction> userActions;
    private List<User> userList;

    @BeforeEach
    void setUp() {
        analyzer = new UserActionAnalyzer();
        userList = List.of(
                new User(1, "Alice"),
                new User(2, "Bob"),
                new User(3, "Charlie"),
                new User(4, "Dave"),
                new User(5, "Eve")
        );
        userActions = Arrays.asList(
                new UserAction(userList.get(0), ActionType.POST, LocalDate.of(2024, 9, 1),
                        "Check out this amazing #newfeature!"),
                new UserAction(userList.get(1), ActionType.COMMENT, LocalDate.of(2024, 9, 2),
                        "I totally agree with #newfeature."),
                new UserAction(userList.get(0), ActionType.LIKE, LocalDate.of(2024, 9, 3), ""),
                new UserAction(userList.get(2), ActionType.SHARE, LocalDate.of(2024, 9, 4), ""),
                new UserAction(userList.get(3), ActionType.POST, LocalDate.of(2024, 9, 5),
                        "#Java is awesome!"),
                new UserAction(userList.get(1), ActionType.LIKE, LocalDate.of(2024, 9, 6), ""),
                new UserAction(userList.get(2), ActionType.POST, LocalDate.of(2024, 9, 7),
                        "Check out this cool #project"),
                new UserAction(userList.get(0), ActionType.COMMENT, LocalDate.of(2024, 9, 8),
                        "Thanks for sharing #project!"),
                new UserAction(userList.get(3), ActionType.LIKE, LocalDate.of(2024, 9, 9), ""),
                new UserAction(userList.get(1), ActionType.COMMENT, LocalDate.of(2024, 9, 10),
                        "#Java is everywhere."),
                new UserAction(userList.get(4), ActionType.POST, LocalDate.of(2024, 9, 11),
                        "Loving the new #feature release!"),
                new UserAction(userList.get(2), ActionType.COMMENT, LocalDate.of(2024, 9, 12),
                        "#Java is indeed awesome."),
                new UserAction(userList.get(4), ActionType.LIKE, LocalDate.of(2024, 9, 13), ""),
                new UserAction(userList.get(3), ActionType.SHARE, LocalDate.of(2024, 9, 14), ""),
                new UserAction(userList.get(1), ActionType.POST, LocalDate.of(2024, 9, 15),
                        "Introducing a new #update to the system."),
                new UserAction(userList.get(0), ActionType.SHARE, LocalDate.of(2024, 9, 16), ""),
                new UserAction(userList.get(4), ActionType.COMMENT, LocalDate.of(2024, 9, 17),
                        "#update looks great!"),
                new UserAction(userList.get(2), ActionType.LIKE, LocalDate.of(2024, 9, 18), ""),
                new UserAction(userList.get(3), ActionType.COMMENT, LocalDate.of(2024, 9, 19),
                        "Really liking the new #feature."),
                new UserAction(userList.get(1), ActionType.SHARE, LocalDate.of(2024, 9, 20), ""),
                new UserAction(userList.get(0), ActionType.POST, LocalDate.of(2024, 9, 21),
                        "Excited for the upcoming #conference!"),
                new UserAction(userList.get(2), ActionType.COMMENT, LocalDate.of(2024, 9, 22),
                        "I'll be at the #conference too!"),
                new UserAction(userList.get(4), ActionType.LIKE, LocalDate.of(2024, 9, 23), ""),
                new UserAction(userList.get(3), ActionType.POST, LocalDate.of(2024, 9, 24),
                        "Had a great time at the #conference."),
                new UserAction(userList.get(1), ActionType.COMMENT, LocalDate.of(2024, 12, 25),
                        "#conference was a blast!"),
                new UserAction(userList.get(0), ActionType.LIKE, LocalDate.of(2024, 9, 26), ""),
                new UserAction(userList.get(2), ActionType.SHARE, LocalDate.of(2024, 9, 27), ""),
                new UserAction(userList.get(4), ActionType.POST, LocalDate.of(2024, 9, 28),
                        "The new #update is rolling out today."),
                new UserAction(userList.get(3), ActionType.LIKE, LocalDate.of(2024, 9, 29), ""),
                new UserAction(userList.get(0), ActionType.COMMENT, LocalDate.of(2024, 9, 30),
                        "Excited to to try out new #update!"),
                new UserAction(userList.get(1), ActionType.SHARE, LocalDate.of(2024, 10, 1), ""),
                new UserAction(userList.get(2), ActionType.COMMENT, LocalDate.of(2024, 10, 2),
                        "The #update has some great features."),
                new UserAction(userList.get(4), ActionType.LIKE, LocalDate.of(2024, 10, 3), ""),
                new UserAction(userList.get(3), ActionType.SHARE, LocalDate.of(2024, 10, 4), ""),
                new UserAction(userList.get(0), ActionType.POST, LocalDate.of(2024, 10, 5),
                        "Loving the new #update so far."),
                new UserAction(userList.get(1), ActionType.LIKE, LocalDate.of(2024, 10, 6), ""),
                new UserAction(userList.get(2), ActionType.POST, LocalDate.of(2024, 10, 7),
                        "Here's my review of the new #update."),
                new UserAction(userList.get(4), ActionType.COMMENT, LocalDate.of(2024, 12, 8),
                        "Your #review was helpful!"),
                new UserAction(userList.get(3), ActionType.LIKE, LocalDate.of(2024, 10, 9), ""),
                new UserAction(userList.get(0), ActionType.SHARE, LocalDate.of(2024, 10, 10), ""),
                new UserAction(userList.get(2), ActionType.COMMENT, LocalDate.of(2024, 12, 11),
                        "Sharing my thoughts on the #update."),
                new UserAction(userList.get(4), ActionType.POST, LocalDate.of(2024, 12, 12),
                        "What a great #feature this update brings!"),
                new UserAction(userList.get(1), ActionType.LIKE, LocalDate.of(2024, 10, 13), ""),
                new UserAction(userList.get(3), ActionType.COMMENT, LocalDate.of(2024, 12, 6),
                        "#feature works really well."),
                new UserAction(userList.get(0), ActionType.POST, LocalDate.of(2024, 12, 3),
                        "The #feature saved me a lot of time."),
                new UserAction(userList.get(2), ActionType.LIKE, LocalDate.of(2024, 10, 16), ""),
                new UserAction(userList.get(4), ActionType.SHARE, LocalDate.of(2024, 10, 17), ""),
                new UserAction(userList.get(1), ActionType.POST, LocalDate.of(2024, 12, 12),
                        "Can't wait for the next #update."),
                new UserAction(userList.get(3), ActionType.SHARE, LocalDate.of(2024, 12, 13), "")
        );
    }

    @Test
    public void testTopActiveUsers() {
        List<String> expectedList = List.of(
                userList.get(0).toString(),
                userList.get(1).toString(),
                userList.get(2).toString(),
                userList.get(3).toString(),
                userList.get(4).toString());

        List<String> actualList = analyzer.topActiveUsers(userActions, 10);

        assertEquals(expectedList, actualList);
    }

    @Test
    public void testTopPopularHashtags() {
        List<String> expectedList = List.of(
                "update",
                "feature",
                "conference",
                "Java",
                "project");

        List<String> actualList = analyzer.topPopularHashtags(userActions, 5);

        assertEquals(expectedList, actualList);
    }

    @Test
    public void testActionTypePercentages() {
        Map<String, Double> expectedMap = Map.of(
                "POST", 13.0 / 49,
                "COMMENT", 13.0 / 49,
                "LIKE", 13.0 / 49,
                "SHARE", 10.0 / 49
        );

        Map<String, Double> actualMap = analyzer.actionTypePercentages(userActions);

        assertEquals(expectedMap, actualMap);
    }
}