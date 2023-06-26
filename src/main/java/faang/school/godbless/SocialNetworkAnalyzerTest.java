package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SocialNetworkAnalyzerTest {
    List<UserAction> userActions;
    SocialNetworkAnalyzer analyzer;

    @BeforeEach
    public void seyUp() {
        userActions = new ArrayList<>();
        userActions.add(new UserAction("1", "John", "I love #programming and #coding", ActionType.POST, LocalDateTime.now()));
        userActions.add(new UserAction("2", "Jane", "I love #programming and #coding", ActionType.POST, LocalDateTime.now()));
        userActions.add(new UserAction("1", "John", "I love #programming and #coding", ActionType.COMMENT, LocalDateTime.now()));
        userActions.add(new UserAction("3", "Bob", "#webinar", ActionType.POST, LocalDateTime.now()));
        userActions.add(new UserAction("2", "Jane", "#webinar", ActionType.LIKE, LocalDateTime.now()));
        userActions.add(new UserAction("4", "Alice", "#webinar", ActionType.COMMENT, LocalDateTime.now()));
        userActions.add(new UserAction("3", "Bob", "#python", ActionType.COMMENT, LocalDateTime.now()));
        userActions.add(new UserAction("5", "Eve", "#python", ActionType.POST, LocalDateTime.now()));
        userActions.add(new UserAction("4", "Alice", "#machinelearning", ActionType.COMMENT, LocalDateTime.now()));
        userActions.add(new UserAction("5", "Eve", "#AI", ActionType.LIKE, LocalDateTime.now()));
        userActions.add(new UserAction("5", "Eve", "#downshifting", ActionType.SHARE, LocalDateTime.now()));
        userActions.add(new UserAction("5", "Eve", "I love #programming and #coding", ActionType.SHARE, LocalDateTime.now()));
        userActions.add(new UserAction("1", "John", "I love #programming", ActionType.LIKE, LocalDateTime.now()));


        analyzer = new SocialNetworkAnalyzer();
    }

    @Test
    void testGetTop10ActiveUsers() {
        List<UserAction> topUsers = analyzer.getTop10ActiveUsers(userActions);
        assertEquals(5, topUsers.size());

        assertEquals("5", topUsers.get(0).getId());
        assertEquals("Eve", topUsers.get(0).getName());

        assertEquals("1", topUsers.get(1).getId());
        assertEquals("John", topUsers.get(1).getName());

        assertEquals("2", topUsers.get(2).getId());
        assertEquals("Jane", topUsers.get(2).getName());

    }
    @Test
    void testGetTop5PopularTopics() {
        List<String> topTopics = analyzer.getTop5PopularTopics(userActions);
        assertEquals(5, topTopics.size());

        assertEquals("#programming", topTopics.get(0));
        assertEquals("#coding", topTopics.get(1));
        assertEquals("#webinar", topTopics.get(2));
        assertEquals("#python", topTopics.get(3));
        assertEquals("#downshifting", topTopics.get(4));
    }

    @Test
    void testGetTop3UsersWithMostCommentsLastMonth() {
        List<UserAction> topUsers  = analyzer.getTop3UsersWithMostCommentsLastMonth(userActions);
        assertEquals(3, topUsers.size());

        assertEquals("4", topUsers.get(0).getId());
        assertEquals("1", topUsers.get(1).getId());
        assertEquals("3", topUsers.get(2).getId());

    }
    @Test
    void testGetActionTypePercentages() {
        Map<ActionType, Double> actionTypePercentages = analyzer.getActionTypePercentages(userActions);

        // Проверяем ожидаемые значения процентного соотношения типов действий
        assertEquals(0.3076923076923077, actionTypePercentages.get(ActionType.POST));
        assertEquals(0.3076923076923077, actionTypePercentages.get(ActionType.COMMENT));
        assertEquals(0.23076923076923078, actionTypePercentages.get(ActionType.LIKE));
        assertEquals(0.15384615384615385, actionTypePercentages.get(ActionType.SHARE));
    }

}


