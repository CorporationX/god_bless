package school.faang.task_47258;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserActionAnalyzerTest {
    private List<UserAction> userActions;
    private List<UserAction> mockActions;
    private List<UserAction> emptyUserActionList;

    @BeforeEach
    void setUp() {
        mockActions = new ArrayList<>();
        userActions = Arrays.asList(
                new UserAction(1L, "Alice", ActionType.POST, LocalDate.of(2024, 9, 1),
                        "Check out this amazing #newfeature!"),
                new UserAction(2L, "Bob", ActionType.COMMENT, LocalDate.of(2024, 9, 2),
                        "I totally agree with #newfeature."),
                new UserAction(1L, "Alice", ActionType.LIKE, LocalDate.of(2024, 9, 3), ""),
                new UserAction(3L, "Charlie", ActionType.SHARE, LocalDate.of(2024, 9, 4), ""),
                new UserAction(4L, "Dave", ActionType.POST, LocalDate.of(2024, 9, 5),
                        "#Java is awesome!"),
                new UserAction(2L, "Bob", ActionType.LIKE, LocalDate.of(2024, 9, 6), ""),
                new UserAction(3L, "Charlie", ActionType.POST, LocalDate.of(2024, 9, 7),
                        "Check out this cool #project"),
                new UserAction(1L, "Alice", ActionType.COMMENT, LocalDate.of(2024, 9, 8),
                        "Thanks for sharing #project!"),
                new UserAction(4L, "Dave", ActionType.LIKE, LocalDate.of(2024, 9, 9), ""),
                new UserAction(2L, "Bob", ActionType.COMMENT, LocalDate.of(2024, 9, 10),
                        "#Java is everywhere."),
                new UserAction(5L, "Eve", ActionType.POST, LocalDate.of(2024, 9, 11),
                        "Loving the new #feature release!"),
                new UserAction(3L, "Charlie", ActionType.COMMENT, LocalDate.of(2024, 9, 12),
                        "#Java is indeed awesome."),
                new UserAction(5L, "Eve", ActionType.LIKE, LocalDate.of(2024, 9, 13), ""),
                new UserAction(4L, "Dave", ActionType.SHARE, LocalDate.of(2024, 9, 14), ""),
                new UserAction(2L, "Bob", ActionType.POST, LocalDate.of(2024, 9, 15),
                        "Introducing a new #update to the system."),
                new UserAction(1L, "Alice", ActionType.SHARE, LocalDate.of(2024, 9, 16), ""),
                new UserAction(5L, "Eve", ActionType.COMMENT, LocalDate.of(2024, 9, 17),
                        "#update looks great!"),
                new UserAction(3L, "Charlie", ActionType.LIKE, LocalDate.of(2024, 9, 18), ""),
                new UserAction(4L, "Dave", ActionType.COMMENT, LocalDate.of(2024, 9, 19),
                        "Really liking the new #feature."),
                new UserAction(2L, "Bob", ActionType.SHARE, LocalDate.of(2024, 10, 20), ""),
                new UserAction(1L, "Alice", ActionType.POST, LocalDate.of(2024, 10, 21),
                        "Excited for the upcoming #conference!"),
                new UserAction(3L, "Charlie", ActionType.COMMENT, LocalDate.of(2024, 10, 22),
                        "I'll be at the #conference too!"),
                new UserAction(5L, "Eve", ActionType.LIKE, LocalDate.of(2024, 10, 23), ""),
                new UserAction(4L, "Dave", ActionType.POST, LocalDate.of(2024, 10, 24),
                        "Had a great time at the #conference."),
                new UserAction(2L, "Bob", ActionType.COMMENT, LocalDate.of(2024, 10, 25),
                        "#conference was a blast!"),
                new UserAction(1L, "Alice", ActionType.LIKE, LocalDate.of(2024, 10, 26), ""),
                new UserAction(3L, "Charlie", ActionType.SHARE, LocalDate.of(2024, 10, 27), ""),
                new UserAction(5L, "Eve", ActionType.POST, LocalDate.of(2024, 10, 28),
                        "The new #update is rolling out today."),
                new UserAction(4L, "Dave", ActionType.LIKE, LocalDate.of(2024, 10, 21), ""),
                new UserAction(1L, "Alice", ActionType.COMMENT, LocalDate.of(2024, 10, 30),
                        "Excited to try out the new #update!"),
                new UserAction(2L, "Bob", ActionType.SHARE, LocalDate.of(2024, 11, 1), ""),
                new UserAction(3L, "Charlie", ActionType.COMMENT, LocalDate.of(2024, 11, 24),
                        "The #update has some great features."),
                new UserAction(5L, "Eve", ActionType.LIKE, LocalDate.of(2024, 11, 3), ""),
                new UserAction(4L, "Dave", ActionType.SHARE, LocalDate.of(2024, 11, 4), ""),
                new UserAction(1L, "Alice", ActionType.POST, LocalDate.of(2024, 11, 5),
                        "Loving the new #update so far."),
                new UserAction(2L, "Bob", ActionType.LIKE, LocalDate.of(2024, 11, 6), ""),
                new UserAction(3L, "Charlie", ActionType.POST, LocalDate.of(2024, 11, 7),
                        "Here's my review of the new #update."),
                new UserAction(5L, "Eve", ActionType.COMMENT, LocalDate.of(2024, 12, 1),
                        "Your #review was helpful!"),
                new UserAction(4L, "Dave", ActionType.LIKE, LocalDate.of(2024, 11, 9), ""),
                new UserAction(1L, "Alice", ActionType.SHARE, LocalDate.of(2024, 11, 11), ""),
                new UserAction(3L, "Charlie", ActionType.COMMENT, LocalDate.of(2024, 11, 11),
                        "Sharing my thoughts on the #update."),
                new UserAction(5L, "Eve", ActionType.POST, LocalDate.of(2024, 11, 12),
                        "What a great #feature this update brings!"),
                new UserAction(2L, "Bob", ActionType.LIKE, LocalDate.of(2024, 11, 13), ""),
                new UserAction(4L, "Dave", ActionType.COMMENT, LocalDate.of(2024, 11, 19),
                        "#feature works really well."),
                new UserAction(1L, "Alice", ActionType.POST, LocalDate.of(2024, 11, 15),
                        "The #feature saved me a lot of time."),
                new UserAction(3L, "Charlie", ActionType.LIKE, LocalDate.of(2024, 11, 16), ""),
                new UserAction(5L, "Eve", ActionType.SHARE, LocalDate.of(2024, 11, 17), ""),
                new UserAction(2L, "Bob", ActionType.POST, LocalDate.of(2024, 11, 18),
                        "Can't wait for the next #update."),
                new UserAction(4L, "Dave", ActionType.SHARE, LocalDate.of(2024, 11, 19), ""),
                new UserAction(6L, "John", ActionType.COMMENT, LocalDate.of(2024, 12, 11), "")
        );
    }

    @Test
    void testTopActiveUsers() {
        assertEquals(List.of("Bob", "Alice", "Charlie", "Dave", "Eve", "John"),
                UserActionAnalyzer.topActiveUsers(userActions));

        assertThrows(IllegalArgumentException.class,
                () -> UserActionAnalyzer.topActiveUsers(emptyUserActionList));
        assertThrows(IllegalArgumentException.class,
                () -> UserActionAnalyzer.topActiveUsers(null));
    }

    @Test
    void testTopPopularHashtags() {
        assertEquals(List.of("#update", "#feature", "#update.", "#Java", "#conference"),
                UserActionAnalyzer.topPopularHashtags(userActions));

        assertThrows(IllegalArgumentException.class,
                () -> UserActionAnalyzer.topPopularHashtags(emptyUserActionList));
        assertThrows(IllegalArgumentException.class,
                () -> UserActionAnalyzer.topPopularHashtags(null));
    }

    @Test
    void testTopCommentersLastMonth() {
        mockActions.add(createMockAction(1L, "Eve", ActionType.COMMENT, LocalDate.now()));
        mockActions.add(createMockAction(1L, "Eve", ActionType.COMMENT, LocalDate.now().minusDays(10)));
        mockActions.add(createMockAction(2L, "Bob", ActionType.COMMENT, LocalDate.now().minusDays(15)));
        mockActions.add(createMockAction(2L, "Bob", ActionType.COMMENT, LocalDate.now().minusDays(20)));
        mockActions.add(createMockAction(2L, "Bob", ActionType.COMMENT, LocalDate.now().minusDays(25)));
        mockActions.add(createMockAction(3L, "Charlie", ActionType.COMMENT, LocalDate.now().minusDays(16)));
        mockActions.add(createMockAction(4L, "John", ActionType.COMMENT, LocalDate.now().minusDays(29)));
        mockActions.add(createMockAction(5L, "Alice", ActionType.POST, LocalDate.now()));
        mockActions.add(createMockAction(6L, "Rianna", ActionType.LIKE, LocalDate.now().minusDays(30)));
        assertEquals(List.of("Bob", "Eve", "Charlie"),
                UserActionAnalyzer.topCommentersLastMonth(mockActions));

        assertThrows(IllegalArgumentException.class,
                () -> UserActionAnalyzer.topCommentersLastMonth(emptyUserActionList));
        assertThrows(IllegalArgumentException.class,
                () -> UserActionAnalyzer.topCommentersLastMonth(null));
    }

    @Test
    void testActionPercentages() {
        assertEquals(Map.of(ActionType.SHARE, "20%",
                        ActionType.POST, "26%",
                        ActionType.COMMENT, "28%",
                        ActionType.LIKE, "26%"),
                UserActionAnalyzer.actionPercentages(userActions));

        assertThrows(IllegalArgumentException.class,
                () -> UserActionAnalyzer.actionPercentages(emptyUserActionList));
        assertThrows(IllegalArgumentException.class,
                () -> UserActionAnalyzer.actionPercentages(null));
    }

    private UserAction createMockAction(Long userId, String name, ActionType actionType, LocalDate actionDate) {
        UserAction action = mock(UserAction.class);
        when(action.getId()).thenReturn(userId);
        when(action.getName()).thenReturn(name);
        when(action.getActionType()).thenReturn(actionType);
        when(action.getActionDate()).thenReturn(actionDate);
        return action;
    }
}