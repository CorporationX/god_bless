import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.ActionType;
import school.faang.UserAction;
import school.faang.UserActionAnalyzer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserActionAnalyzerTest {
    List<UserAction> actions = new ArrayList<>();

    @BeforeEach
    void setUp() {
        actions = Arrays.asList(
                new UserAction(1, "Alice", ActionType.POST, LocalDate.of(
                        2025, 1, 1), "#newfeature"),
                new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(
                        2025, 2, 2), "#newfeature"),
                new UserAction(1, "Alice", ActionType.LIKE, LocalDate.of(
                        2025, 2, 3), ""),
                new UserAction(3, "Charlie", ActionType.SHARE, LocalDate.of(
                        2025, 1, 4), "#Exploring AI and tech"),
                new UserAction(1, "Alice", ActionType.POST, LocalDate.of(
                        2025, 3, 1), "Another post!"),
                new UserAction(2, "Bob", ActionType.LIKE, LocalDate.of(
                        2025, 3, 2), ""),
                new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.of(
                        2025, 3, 3), "Nice!"),
                new UserAction(2, "Bob", ActionType.POST, LocalDate.of(
                        2025, 3, 4), "#AI is awesome tech"),
                new UserAction(3, "Alice", ActionType.LIKE, LocalDate.of(
                        2025, 3, 5), "")
        );
    }

    @Test
    void testGetTopActiveUsers_withValidActions() {
        assertEquals(List.of("Alice", "Bob"), UserActionAnalyzer.getTopActiveUsers(actions, 2));
    }

    @Test
    void testGetTopActiveUsers_singleUser() {
        List<UserAction> singleAction = List.of(new UserAction(1, "Alice", ActionType.POST, LocalDate.of(
                2025, 3, 1), "Another post!"));
        assertEquals(List.of("Alice"), UserActionAnalyzer.getTopActiveUsers(singleAction, 1));
    }

    @Test
    void testGetTopActiveUsers_tiedUsers() {
        List<UserAction> tiedActions = Arrays.asList(
                new UserAction(1, "Alice", ActionType.POST, LocalDate.of(
                        2025, 1, 1), "Alice post"),
                new UserAction(2, "Bob", ActionType.POST, LocalDate.of(
                        2025, 1, 2), "Bob post")
        );
        assertEquals(List.of("Bob", "Alice"), UserActionAnalyzer.getTopActiveUsers(tiedActions, 2));
    }

    @Test
    void testGetTopActiveUsers_noActions() {
        assertTrue(UserActionAnalyzer.getTopActiveUsers(new ArrayList<>(), 1).isEmpty());
    }

    @Test
    void testGetTopActiveUsers_moreTopnThanUsers() {
        Set<String> users = actions.stream()
                .map(UserAction::getName)
                .collect(Collectors.toSet());
        List<String> result = UserActionAnalyzer.getTopActiveUsers(actions, 1000);
        assertEquals(users.size(), result.size());
    }

    @Test
    void testGetTopActiveUsers_nullActions() {
        assertThrows(IllegalArgumentException.class, () -> UserActionAnalyzer.getTopActiveUsers(null, 2));
    }

    @Test
    void testGetTopActiveUsers_negativeTopN() {
        assertThrows(IllegalArgumentException.class, () -> UserActionAnalyzer.getTopActiveUsers(actions, -1));
    }

    @Test
    void testGetTopHashtags_basicCase() {
        System.out.println(UserActionAnalyzer.getTopHashtags(actions, 3));
        assertEquals(List.of("#newfeature", "#AI is awesome tech"), UserActionAnalyzer.getTopHashtags(actions, 3));
    }

    @Test
    void testGetTopHashtags_noHashtags() {
        List<UserAction> noHashtagsActions = Arrays.asList(
                new UserAction(1, "Alice", ActionType.POST, LocalDate.of(
                        2025, 1, 1), "Just a regular post"),
                new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(
                        2025, 2, 2), "No hashtags here")
        );
        assertTrue(UserActionAnalyzer.getTopHashtags(noHashtagsActions, 3).isEmpty());
    }

    @Test
    void testGetTopHashtags_moreTopnThanHashtags() {
        assertEquals(List.of("#newfeature", "#AI is awesome tech"),
                UserActionAnalyzer.getTopHashtags(actions, 100));
    }

    @Test
    void testGetTopHashtags_nullActions() {
        assertThrows(IllegalArgumentException.class, () -> UserActionAnalyzer.getTopHashtags(null, 3));
    }

    @Test
    void testGetTopHashtags_negativeTopN() {
        assertThrows(IllegalArgumentException.class, () -> UserActionAnalyzer.getTopHashtags(actions, -1));
    }

    @Test
    void testGetTopCommentersLastMonth_basicCase() {
        assertEquals(List.of("Bob", "Charlie"), UserActionAnalyzer.getTopCommentersLastMonth(actions, 3));
    }

    @Test
    void testGetTopCommentersLastMonth_withEmptyList() {
        assertTrue(UserActionAnalyzer.getTopCommentersLastMonth(Collections.emptyList(), 1).isEmpty());
    }

    @Test
    void testGetTopCommentersLastMonth_nullActions() {
        assertThrows(IllegalArgumentException.class, () -> UserActionAnalyzer.getTopCommentersLastMonth(null, 2));
    }

    @Test
    void testGetTopCommentersLastMonth_noComments() {
        List<UserAction> actionsWithoutComments = List.of(
                new UserAction(1, "Alice", ActionType.POST, LocalDate.of(
                        2025, 1, 1), "#newfeature"),
                new UserAction(1, "Alice", ActionType.LIKE, LocalDate.of(
                        2025, 2, 3), "")
        );
        assertTrue(UserActionAnalyzer.getTopCommentersLastMonth(actionsWithoutComments, 2).isEmpty());
    }

    @Test
    void testGetActionTypePercentages_NormalCase() {
        List<UserAction> actions = List.of(
                new UserAction(1, "Alice", ActionType.POST, LocalDate.of(
                        2025, 1, 1), "#newfeature"),
                new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(
                        2025, 2, 2), "#newfeature"),
                new UserAction(4, "Alice", ActionType.LIKE, LocalDate.of(
                        2025, 2, 3), ""),
                new UserAction(5, "Jane", ActionType.POST, LocalDate.of(
                        2025, 1, 1), "#java")
        );
        Map<String, Double> result = UserActionAnalyzer.getActionTypePercentages(actions);
        assertEquals(50.0, result.get("POST"));
        assertEquals(25.0, result.get("COMMENT"));
        assertEquals(25.0, result.get("LIKE"));
    }

    @Test
    void testGetActionTypePercentages_withEmptyList() {
        assertTrue(UserActionAnalyzer.getActionTypePercentages(Collections.emptyList()).isEmpty());
    }

    @Test
    void testGetActionTypePercentages_allSameAction() {
        List<UserAction> actions = List.of(
                new UserAction(1, "Alice", ActionType.POST, LocalDate.of(
                        2025, 1, 1), "#newfeature"),
                new UserAction(2, "Bob", ActionType.POST, LocalDate.of(
                        2025, 2, 2), "#newfeature"),
                new UserAction(4, "Alice", ActionType.POST, LocalDate.of(
                        2025, 2, 3), ""),
                new UserAction(5, "Jane", ActionType.POST, LocalDate.of(
                        2025, 1, 1), "#java")
        );
        Map<String, Double> result = UserActionAnalyzer.getActionTypePercentages(actions);
        assertEquals(100.0, result.get("POST"));
    }

    @Test
    void testGetActionTypePercentages_nullActions() {
        assertThrows(IllegalArgumentException.class, () -> UserActionAnalyzer.getActionTypePercentages(null));
    }

}
