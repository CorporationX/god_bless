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

    @BeforeEach
    void setUp() {
        analyzer = new UserActionAnalyzer();

        User userAlice = new User(1, "Alice");
        User userBob = new User(2, "Bob");
        User userCharlie = new User(3, "Charlie");
        User userDave = new User(4, "Dave");
        User userEve = new User(5, "Eve");
        userActions = Arrays.asList(
                new UserAction(userAlice, ActionType.POST, LocalDate.of(2024, 9, 1),
                        "Check out this amazing #newfeature!"),
                new UserAction(userBob, ActionType.COMMENT, LocalDate.of(2024, 9, 2),
                        "I totally agree with #newfeature."),
                new UserAction(userAlice, ActionType.LIKE, LocalDate.of(2024, 9, 3), ""),
                new UserAction(userCharlie, ActionType.SHARE, LocalDate.of(2024, 9, 4), ""),
                new UserAction(userDave, ActionType.POST, LocalDate.of(2024, 9, 5),
                        "#Java is awesome!"),
                new UserAction(userBob, ActionType.LIKE, LocalDate.of(2024, 9, 6), ""),
                new UserAction(userCharlie, ActionType.POST, LocalDate.of(2024, 9, 7),
                        "Check out this cool #project"),
                new UserAction(userAlice, ActionType.COMMENT, LocalDate.of(2024, 9, 8),
                        "Thanks for sharing #project!"),
                new UserAction(userDave, ActionType.LIKE, LocalDate.of(2024, 9, 9), ""),
                new UserAction(userBob, ActionType.COMMENT, LocalDate.of(2024, 9, 10),
                        "#Java is everywhere."),
                new UserAction(userEve, ActionType.POST, LocalDate.of(2024, 9, 11),
                        "Loving the new #feature release!"),
                new UserAction(userCharlie, ActionType.COMMENT, LocalDate.of(2024, 9, 12),
                        "#Java is indeed awesome."),
                new UserAction(userEve, ActionType.LIKE, LocalDate.of(2024, 9, 13), ""),
                new UserAction(userDave, ActionType.SHARE, LocalDate.of(2024, 9, 14), ""),
                new UserAction(userBob, ActionType.POST, LocalDate.of(2024, 9, 15),
                        "Introducing a new #update to the system."),
                new UserAction(userAlice, ActionType.SHARE, LocalDate.of(2024, 9, 16), ""),
                new UserAction(userEve, ActionType.COMMENT, LocalDate.of(2024, 9, 17),
                        "#update looks great!"),
                new UserAction(userCharlie, ActionType.LIKE, LocalDate.of(2024, 9, 18), ""),
                new UserAction(userDave, ActionType.COMMENT, LocalDate.of(2024, 9, 19),
                        "Really liking the new #feature."),
                new UserAction(userBob, ActionType.SHARE, LocalDate.of(2024, 9, 20), ""),
                new UserAction(userAlice, ActionType.POST, LocalDate.of(2024, 9, 21),
                        "Excited for the upcoming #conference!"),
                new UserAction(userCharlie, ActionType.COMMENT, LocalDate.of(2024, 9, 22),
                        "I'll be at the #conference too!"),
                new UserAction(userEve, ActionType.LIKE, LocalDate.of(2024, 9, 23), ""),
                new UserAction(userDave, ActionType.POST, LocalDate.of(2024, 9, 24),
                        "Had a great time at the #conference."),
                new UserAction(userBob, ActionType.COMMENT, LocalDate.of(2024, 9, 25),
                        "#conference was a blast!"),
                new UserAction(userAlice, ActionType.LIKE, LocalDate.of(2024, 9, 26), ""),
                new UserAction(userCharlie, ActionType.SHARE, LocalDate.of(2024, 9, 27), ""),
                new UserAction(userEve, ActionType.POST, LocalDate.of(2024, 9, 28),
                        "The new #update is rolling out today."),
                new UserAction(userDave, ActionType.LIKE, LocalDate.of(2024, 9, 29), ""),
                new UserAction(userAlice, ActionType.COMMENT, LocalDate.of(2024, 9, 30),
                        "Excited to to try out new #update!"),
                new UserAction(userBob, ActionType.SHARE, LocalDate.of(2024, 10, 1), ""),
                new UserAction(userCharlie, ActionType.COMMENT, LocalDate.of(2024, 10, 2),
                        "The #update has some great features."),
                new UserAction(userEve, ActionType.LIKE, LocalDate.of(2024, 10, 3), ""),
                new UserAction(userDave, ActionType.SHARE, LocalDate.of(2024, 10, 4), ""),
                new UserAction(userAlice, ActionType.POST, LocalDate.of(2024, 10, 5),
                        "Loving the new #update so far."),
                new UserAction(userBob, ActionType.LIKE, LocalDate.of(2024, 10, 6), ""),
                new UserAction(userCharlie, ActionType.POST, LocalDate.of(2024, 10, 7),
                        "Here's my review of the new #update."),
                new UserAction(userEve, ActionType.COMMENT, LocalDate.of(2024, 10, 8),
                        "Your #review was helpful!"),
                new UserAction(userDave, ActionType.LIKE, LocalDate.of(2024, 10, 9), ""),
                new UserAction(userAlice, ActionType.SHARE, LocalDate.of(2024, 10, 10), ""),
                new UserAction(userCharlie, ActionType.COMMENT, LocalDate.of(2024, 10, 11),
                        "Sharing my thoughts on the #update."),
                new UserAction(userEve, ActionType.POST, LocalDate.of(2024, 10, 12),
                        "What a great #feature this update brings!"),
                new UserAction(userBob, ActionType.LIKE, LocalDate.of(2024, 10, 13), ""),
                new UserAction(userDave, ActionType.COMMENT, LocalDate.of(2024, 10, 14),
                        "#feature works really well."),
                new UserAction(userAlice, ActionType.POST, LocalDate.of(2024, 10, 15),
                        "The #feature saved me a lot of time."),
                new UserAction(userCharlie, ActionType.LIKE, LocalDate.of(2024, 10, 16), ""),
                new UserAction(userEve, ActionType.SHARE, LocalDate.of(2024, 10, 17), ""),
                new UserAction(userBob, ActionType.POST, LocalDate.of(2024, 10, 18),
                        "Can't wait for the next #update."),
                new UserAction(userDave, ActionType.SHARE, LocalDate.of(2024, 10, 19), "")
        );
    }

    @Test
    public void testTopActiveUsers() {
        List<String> expectedList = List.of(
                "id=2 name=Bob 10",
                "id=4 name=Dave 10",
                "id=1 name=Alice 10",
                "id=3 name=Charlie 10",
                "id=5 name=Eve 9");

        List<String> actualList = analyzer.topActiveUsers(userActions, 10);

        assertEquals(expectedList, actualList);
    }

    @Test
    public void testTopPopularHashtags() {
        List<String> expectedList = List.of(
                "update 9",
                "feature 5",
                "conference 4",
                "Java 3",
                "project 2");

        List<String> actualList = analyzer.topPopularHashtags(userActions, 5);

        assertEquals(expectedList, actualList);
    }

    @Test
    public void testTopCommentersLastMonth() {
        List<String> expectedList = List.of(
                "id=3 name=Charlie 2",
                "id=4 name=Dave 1",
                "id=5 name=Eve 1");

        List<String> actualList = analyzer.topCommentersLastMonth(userActions, 3);

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