package faang.school.godbless.sprint3.user_activity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest {
    private Application application;

    @BeforeEach
    void setUp() {
        application = new Application();
    }

    @Test
    void getTopTenPopularUsers() {
        List<UserAction> userActions = List.of(
                new UserAction(1, "user-1", ActionType.LIKE, LocalDate.now(), "like"),
                new UserAction(2, "user-2", ActionType.LIKE, LocalDate.now(), "like"),
                new UserAction(2, "user-2", ActionType.LIKE, LocalDate.now(), "like"),
                new UserAction(3, "user-3", ActionType.LIKE, LocalDate.now(), "like"),
                new UserAction(3, "user-3", ActionType.LIKE, LocalDate.now(), "like")
        );

        List<Integer> expected = List.of(2, 3, 1);
        assertEquals(expected, application.getTopTenPopularUsers(userActions));
    }

    @Test
    void getTopFivePopularHashTags() {
        List<UserAction> userActions = List.of(
                new UserAction(1, "user-1", ActionType.POST, LocalDate.now(), "#python"),
                new UserAction(1, "user-1", ActionType.POST, LocalDate.now(), "#python"),
                new UserAction(3, "user-3", ActionType.POST, LocalDate.now(), "#java"),
                new UserAction(3, "user-3", ActionType.POST, LocalDate.now(), "#java"),
                new UserAction(3, "user-3", ActionType.POST, LocalDate.now(), "#java"),
                new UserAction(3, "user-2", ActionType.LIKE, LocalDate.now(), "#C++")
        );

        List<String> expected = List.of("#java", "#python");

        assertEquals(expected, application.getTopFivePopularHashTags(userActions));
    }

    @Test
    void getTopThreeUserWitMostComments() {
        List<UserAction> userActions = List.of(
                new UserAction(
                        1,
                        "user-1",
                        ActionType.COMMENT,
                        LocalDate.of(2023, 4, 30),
                        "#like"),
                new UserAction(
                        2,
                        "user-2",
                        ActionType.COMMENT,
                        LocalDate.of(2023, 5, 30),
                        "#comment"),
                new UserAction(
                        2,
                        "user-2",
                        ActionType.COMMENT,
                        LocalDate.of(2023, 5, 30),
                        "#comment"),
                new UserAction(
                        3,
                        "user-3",
                        ActionType.COMMENT,
                        LocalDate.of(2023, 5, 30),
                        "#comment")
        );

        List<Integer> expected = List.of(2, 3);

        assertEquals(expected, application.getTopThreeUserWitMostComments(userActions));
    }
    @Test
    void getAveragePercentageForAction() {
        List<UserAction> userActions = List.of(
                new UserAction(1, "user-1", ActionType.LIKE, LocalDate.now(), "#java"),
                new UserAction(1, "user-1", ActionType.LIKE, LocalDate.now(), "#java"),
                new UserAction(1, "user-1", ActionType.LIKE, LocalDate.now(), "#java"),
                new UserAction(1, "user-1", ActionType.COMMENT, LocalDate.now(), "#java"),
                new UserAction(1, "user-1", ActionType.COMMENT, LocalDate.now(), "#java"),
                new UserAction(1, "user-1", ActionType.SHARE, LocalDate.now(), "#java"),
                new UserAction(2, "user-2", ActionType.POST, LocalDate.now(), "#java")
        );

        BigDecimal likeExpected = BigDecimal.valueOf(42.9);
        BigDecimal commentExpected = BigDecimal.valueOf(28.6);
        BigDecimal postExpected = BigDecimal.valueOf(14.3);
        BigDecimal shareExpected = BigDecimal.valueOf(14.3);

        Map<ActionType, Double> result = application.getAveragePercentageForAction(userActions);

        assertAll(() -> {
            assertEquals(
                    likeExpected,
                    BigDecimal.valueOf(result.get(ActionType.LIKE)).setScale(1, RoundingMode.HALF_UP)
            );
            assertEquals(
                    commentExpected,
                    BigDecimal.valueOf(result.get(ActionType.COMMENT)).setScale(1, RoundingMode.HALF_UP)
            );
            assertEquals(
                    postExpected,
                    BigDecimal.valueOf(result.get(ActionType.POST)).setScale(1, RoundingMode.HALF_UP)
            );
            assertEquals(
                    shareExpected,
                    BigDecimal.valueOf(result.get(ActionType.SHARE)).setScale(1, RoundingMode.HALF_UP)
            );
        });
    }
}