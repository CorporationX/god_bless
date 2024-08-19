package faang.school.godbless.bjs2_22552;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    private List<UserAction> userActions;

    @BeforeEach
    void setup() {
        userActions = new ArrayList<>();

        userActions.add(new UserAction(5, "Ivan", ActionType.POST, LocalDate.of(2024, 8, 10), "#java#java java"));
        userActions.add(new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2024, 8, 10), "#java #java java"));
        userActions.add(new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2024, 8, 11), "#javarush"));
        userActions.add(new UserAction(1, "Alice", ActionType.LIKE, LocalDate.of(2024, 8, 12), null));
        userActions.add(new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2024, 8, 13), "comment"));
        userActions.add(new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2024, 8, 14), "hello#python"));
        userActions.add(new UserAction(3, "John", ActionType.POST, LocalDate.of(2024, 8, 14), " #python "));
        userActions.add(new UserAction(3, "John", ActionType.COMMENT, LocalDate.of(2024, 6, 14), "Hello, world!"));
        userActions.add(new UserAction(3, "John", ActionType.COMMENT, LocalDate.of(2024, 6, 14), "Hello, world!"));
        userActions.add(new UserAction(3, "John", ActionType.COMMENT, LocalDate.of(2024, 8, 14), "Hello, world!"));
    }

    @Test
    void testGetTopMostActiveUsers() {
        var result = Main.getTopMostActiveUsers(userActions);
        assertEquals(3, result.get(0));
        assertEquals(1, result.get(1));
        assertEquals(2, result.get(2));
        assertEquals(5, result.get(3));
    }

    @Test
    void testGetTopMostPopularTopics() {
        var result = Main.getTopMostPopularTopics(userActions);
        assertEquals(3, result.size());
        assertEquals("#java", result.get(0));
        assertEquals("#python", result.get(1));
        assertEquals("#javarush", result.get(2));
    }

    @Test
    void testGetTopUsersWithComments() {
        var result = Main.getTopUsersWithComments(userActions);
        assertEquals(2, result.size());
        assertEquals(2, result.get(0));
        assertEquals(3, result.get(1));
    }

    @Test
    void testCalculateActionsPercentage() {
        var result = Main.calculateActionsPercentage(userActions);
        assertEquals(3, result.size());
        assertEquals(40.0, result.get(ActionType.POST));
        assertEquals(50.0, result.get(ActionType.COMMENT));
        assertEquals(10.0, result.get(ActionType.LIKE));
    }
}