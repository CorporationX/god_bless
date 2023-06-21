package faang.school.godbless.sprint3.streamAPI.task1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UserActionTest {

    @ParameterizedTest
    @MethodSource("listProvider")
    void testFindTopTenUserAction(List<UserAction> userActions) {
        List<Integer> expected = List.of(1, 20, 2, 4, 15, 16, 17, 18, 19, 3);

        List<Integer> actual = UserAction.findTopTenUserAction(userActions);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("listProvider")
    void testFindTopFiveContent(List<UserAction> userActions) {
        List<String> expected = List.of("#java", "#top", "#spring", "#python", "#javascript");

        List<String> actual = UserAction.findTopFiveContent(userActions);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("listProvider")
    void testFindTopThreeUserComment(List<UserAction> userActions) {
        List<Integer> expected = List.of(20, 1, 4);

        List<Integer> actual = UserAction.findTopThreeUserComment(userActions);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("listProvider")
    void testCalculatePercentageActionsTyp(List<UserAction> userActions) {
        Map<ActionType, Double> expected = Map.of(
                ActionType.POST, 38.63636363636363,
                ActionType.COMMENT, 54.54545454545454,
                ActionType.LIKE, 2.272727272727273,
                ActionType.SHARE, 4.545454545454546
        );

        Map<ActionType, Double> actual = UserAction.calculatePercentageActionsType(userActions);

        assertEquals(expected.get(ActionType.POST), actual.get(ActionType.POST));
        assertEquals(expected.get(ActionType.COMMENT), actual.get(ActionType.COMMENT));
        assertEquals(expected.get(ActionType.LIKE), actual.get(ActionType.LIKE));
        assertEquals(expected.get(ActionType.SHARE), actual.get(ActionType.SHARE));
    }

    @Test
    void testValidation() {
        List<UserAction> listEmpty = new ArrayList<>();
        List<UserAction> listNull = null;
        assertThrows(IllegalArgumentException.class, () -> UserAction.findTopTenUserAction(listEmpty));
        assertThrows(IllegalArgumentException.class, () -> UserAction.findTopTenUserAction(listNull));
    }


    static Stream<Arguments> listProvider() {
        List<UserAction> userActions = List.of(
                new UserAction(1, "Александр", ActionType.POST, LocalDate.of(2023, 1, 30), "#java"),
                new UserAction(1, "Александр", ActionType.COMMENT, LocalDate.of(2023, 5, 30), "#top"),
                new UserAction(1, "Александр", ActionType.COMMENT, LocalDate.of(2023, 5, 30), "#top"),
                new UserAction(1, "Александр", ActionType.COMMENT, LocalDate.of(2023, 5, 30), "#top"),
                new UserAction(1, "Александр", ActionType.COMMENT, LocalDate.of(2023, 5, 30), "#top"),
                new UserAction(1, "Александр", ActionType.COMMENT, LocalDate.of(2023, 5, 30), "#top"),
                new UserAction(1, "Александр", ActionType.SHARE, LocalDate.of(2023, 5, 30), "#go"),
                new UserAction(1, "Александр", ActionType.POST, LocalDate.of(2023, 4, 30), "#stream"),
                new UserAction(2, "Михаил", ActionType.POST, LocalDate.of(2023, 3, 30), "#java"),
                new UserAction(2, "Михаил", ActionType.COMMENT, LocalDate.of(2023, 5, 30), "#javascript"),
                new UserAction(2, "Михаил", ActionType.LIKE, LocalDate.of(2023, 6, 10), "#javascript"),
                new UserAction(2, "Михаил", ActionType.SHARE, LocalDate.of(2023, 6, 15), "#java"),
                new UserAction(3, "Максим", ActionType.POST, LocalDate.of(2023, 6, 15), "#python"),
                new UserAction(4, "Лев", ActionType.POST, LocalDate.of(2023, 6, 15), "#summer"),
                new UserAction(4, "Лев", ActionType.COMMENT, LocalDate.of(2023, 6, 19), "#java"),
                new UserAction(4, "Лев", ActionType.COMMENT, LocalDate.of(2023, 5, 27), "#stream"),
                new UserAction(4, "Лев", ActionType.POST, LocalDate.of(2023, 5, 5), "#spring"),
                new UserAction(5, "Марк", ActionType.COMMENT, LocalDate.of(2023, 6, 10), "#java"),
                new UserAction(6, "Артем", ActionType.POST, LocalDate.of(2023, 5, 30), "#spring"),
                new UserAction(7, "Иван", ActionType.COMMENT, LocalDate.of(2023, 5, 30), "#spring"),
                new UserAction(8, "Матвей", ActionType.POST, LocalDate.of(2023, 5, 27), "#java"),
                new UserAction(9, "Дмитрий", ActionType.COMMENT, LocalDate.of(2023, 6, 6), "#python"),
                new UserAction(10, "Даниил", ActionType.POST, LocalDate.of(2023, 6, 10), "#java"),
                new UserAction(11, "София", ActionType.COMMENT, LocalDate.of(2023, 6, 5), "#go"),
                new UserAction(12, "Мария", ActionType.POST, LocalDate.of(2023, 6, 14), "#java"),
                new UserAction(13, "Анна", ActionType.COMMENT, LocalDate.of(2023, 6, 18), "#javascript"),
                new UserAction(14, "Алиса", ActionType.POST, LocalDate.of(2023, 6, 10), "#job"),
                new UserAction(15, "Виктория", ActionType.COMMENT, LocalDate.of(2023, 6, 15), "#java"),
                new UserAction(15, "Виктория", ActionType.POST, LocalDate.of(2023, 5, 30), "#go"),
                new UserAction(16, "Ева", ActionType.COMMENT, LocalDate.of(2023, 6, 11), "#stream"),
                new UserAction(16, "Ева", ActionType.POST, LocalDate.of(2023, 5, 22), "#spring"),
                new UserAction(17, "Полина", ActionType.COMMENT, LocalDate.of(2023, 6, 15), "#go"),
                new UserAction(17, "Полина", ActionType.POST, LocalDate.of(2023, 6, 17), "#job"),
                new UserAction(18, "Александра", ActionType.COMMENT, LocalDate.of(2023, 6, 11), "#job"),
                new UserAction(18, "Александра", ActionType.POST, LocalDate.of(2023, 6, 5), "#java"),
                new UserAction(19, "Василиса", ActionType.COMMENT, LocalDate.of(2023, 1, 30), "#python"),
                new UserAction(19, "Василиса", ActionType.POST, LocalDate.of(2023, 6, 11), "#spring"),
                new UserAction(20, "Варвара", ActionType.COMMENT, LocalDate.of(2023, 6, 2), "#java"),
                new UserAction(20, "Варвара", ActionType.COMMENT, LocalDate.of(2023, 6, 2), "#java"),
                new UserAction(20, "Варвара", ActionType.COMMENT, LocalDate.of(2023, 6, 2), "#java"),
                new UserAction(20, "Варвара", ActionType.COMMENT, LocalDate.of(2023, 6, 2), "#python"),
                new UserAction(20, "Варвара", ActionType.COMMENT, LocalDate.of(2023, 6, 2), "#python"),
                new UserAction(20, "Варвара", ActionType.COMMENT, LocalDate.of(2023, 6, 2), "#java"),
                new UserAction(20, "Варвара", ActionType.POST, LocalDate.of(2023, 6, 11), "#javascript")
                );
        return Stream.of(
                Arguments.of(userActions)
        );
    }

}