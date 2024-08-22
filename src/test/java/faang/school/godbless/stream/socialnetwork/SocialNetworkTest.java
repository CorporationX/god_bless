package faang.school.godbless.stream.socialnetwork;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SocialNetworkTest {

    @Test
    void testFindTopActiveUsers() {
        SocialNetwork socialNetwork = new SocialNetwork();

        UserAction userAction1_1 = new UserAction(1, "user1", ActionType.POST, LocalDate.now(), "post1");
        UserAction userAction1_2 = new UserAction(1, "user1", ActionType.POST, LocalDate.now().minusDays(2), "post2");
        UserAction userAction1_3 = new UserAction(1, "user1", ActionType.LIKE, LocalDate.now().minusDays(3), "like3");

        UserAction userAction2_1 = new UserAction(2, "user2", ActionType.COMMENT, LocalDate.now(), "comment1");
        UserAction userAction2_2 = new UserAction(2, "user2", ActionType.COMMENT, LocalDate.now().minusDays(2), "comment2");

        UserAction userAction3_1 = new UserAction(3, "user3", ActionType.LIKE, LocalDate.now(), "like1");
        UserAction userAction3_2 = new UserAction(3, "user3", ActionType.COMMENT, LocalDate.now(), "comment3");
        UserAction userAction4_1 = new UserAction(4, "user4", ActionType.LIKE, LocalDate.now(), "like1");
        UserAction userAction5_1 = new UserAction(5, "user5", ActionType.LIKE, LocalDate.now(), "like1");
        UserAction userAction6_1 = new UserAction(6, "user6", ActionType.LIKE, LocalDate.now(), "like1");
        UserAction userAction7_1 = new UserAction(7, "user7", ActionType.LIKE, LocalDate.now(), "like1");
        UserAction userAction8_1 = new UserAction(8, "user8", ActionType.LIKE, LocalDate.now(), "like1");
        UserAction userAction9_1 = new UserAction(9, "user9", ActionType.LIKE, LocalDate.now(), "like1");
        UserAction userAction10_1 = new UserAction(10, "user10", ActionType.LIKE, LocalDate.now(), "like1");
        UserAction userAction11_1 = new UserAction(11, "user11", ActionType.LIKE, LocalDate.now(), "like1");
        UserAction userAction12_1 = new UserAction(12, "user12", ActionType.LIKE, LocalDate.now(), "like1");
        UserAction userAction12_2 = new UserAction(12, "user12", ActionType.LIKE, LocalDate.now(), "like1");

        List<UserAction> actions = Arrays.asList(userAction1_1, userAction1_2, userAction1_3, userAction2_1, userAction2_2,
                userAction3_1, userAction3_2, userAction4_1, userAction5_1, userAction6_1, userAction7_1, userAction8_1,
                userAction9_1, userAction10_1, userAction11_1, userAction12_1, userAction12_2);

        Map<ActionType, List<String>> topActiveUsers = socialNetwork.findTopActiveUsers(actions);
        assertEquals(3, topActiveUsers.size());

        assertTrue(topActiveUsers.containsKey(ActionType.POST));
        List<String> usernamesWithTypePost = topActiveUsers.get(ActionType.POST);
        assertEquals(1, usernamesWithTypePost.size());

        assertTrue(topActiveUsers.containsKey(ActionType.LIKE));
        List<String> usernamesWithTypeLike = topActiveUsers.get(ActionType.LIKE);
        assertEquals(10, usernamesWithTypeLike.size());

        assertTrue(topActiveUsers.containsKey(ActionType.COMMENT));
        List<String> usernamesWithTypeComment = topActiveUsers.get(ActionType.COMMENT);
        assertEquals(2, usernamesWithTypeComment.size());
    }

    @Test
    void testFindTopPopularThemes() {
        SocialNetwork socialNetwork = new SocialNetwork();
        UserAction userAction1_1 = new UserAction(1, "user1", ActionType.POST, LocalDate.now(), "post1 #tag1");
        UserAction userAction1_2 = new UserAction(1, "user1", ActionType.POST, LocalDate.now().minusDays(2), "post2 #tag1 #tag3");
        UserAction userAction1_3 = new UserAction(1, "user1", ActionType.LIKE, LocalDate.now().minusDays(3), "like3 #tag2");
        UserAction userAction2_1 = new UserAction(2, "user2", ActionType.COMMENT, LocalDate.now(), "comment1");
        UserAction userAction2_2 = new UserAction(2, "user2", ActionType.COMMENT, LocalDate.now().minusDays(2), "comment2 #tag3 #tag1");

        List<UserAction> actions = Arrays.asList(userAction1_1, userAction1_2, userAction1_3, userAction2_1, userAction2_2);

        Map<String, Long> topPopularThemes = socialNetwork.findTopPopularThemes(actions);

        assertEquals(3, topPopularThemes.size());
        assertEquals(3, topPopularThemes.get("#tag1"));
        assertEquals(1, topPopularThemes.get("#tag2"));
        assertEquals(2, topPopularThemes.get("#tag3"));
    }

    @Test
    void testFindTopCommentersInLastMonth() {
        SocialNetwork socialNetwork = new SocialNetwork();
        UserAction userAction1_1 = new UserAction(1, "user1", ActionType.COMMENT, LocalDate.now().minusDays(15), "comment1");
        UserAction userAction1_2 = new UserAction(1, "user1", ActionType.COMMENT, LocalDate.now().minusDays(11), "comment2");
        UserAction userAction1_3 = new UserAction(1, "user1", ActionType.POST, LocalDate.now().minusDays(11), "post1");
        UserAction userAction2_1 = new UserAction(2, "user2", ActionType.COMMENT, LocalDate.now().minusDays(3), "comment3");
        UserAction userAction2_2 = new UserAction(2, "user2", ActionType.COMMENT, LocalDate.now().minusDays(35), "comment4");
        UserAction userAction3_1 = new UserAction(3, "user3", ActionType.COMMENT, LocalDate.now().minusDays(64), "comment5");
        UserAction userAction3_2 = new UserAction(3, "user3", ActionType.COMMENT, LocalDate.now().minusDays(5), "comment6");
        UserAction userAction4_1 = new UserAction(4, "user4", ActionType.COMMENT, LocalDate.now().minusDays(41), "comment7");
        UserAction userAction4_2 = new UserAction(4, "user4", ActionType.COMMENT, LocalDate.now().minusDays(6), "comment8");
        UserAction userAction4_3 = new UserAction(4, "user4", ActionType.LIKE, LocalDate.now().minusDays(6), "like1");
        UserAction userAction5_1 = new UserAction(5, "user5", ActionType.COMMENT, LocalDate.now().minusDays(87), "comment9");

        List<UserAction> actions = Arrays.asList(userAction1_1, userAction1_2, userAction1_3, userAction2_1, userAction2_2,
                userAction3_1, userAction3_2, userAction4_1, userAction4_2, userAction4_3, userAction5_1);

        Map<String, Long> topCommentersInLastMonth = socialNetwork.findTopCommentersInLastMonth(actions);

        assertEquals(3, topCommentersInLastMonth.size());

        assertTrue(topCommentersInLastMonth.containsKey("user1"));
        assertEquals(2, topCommentersInLastMonth.get("user1"));

        assertTrue(topCommentersInLastMonth.containsKey("user2"));
        assertEquals(1, topCommentersInLastMonth.get("user2"));

        assertTrue(topCommentersInLastMonth.containsKey("user3"));
        assertEquals(1, topCommentersInLastMonth.get("user3"));
    }

    @Test
    void testFindActionPercentages() {
        SocialNetwork socialNetwork = new SocialNetwork();
        UserAction userAction1_1 = new UserAction(1, "user1", ActionType.LIKE, LocalDate.now(), "like1");
        UserAction userAction1_2 = new UserAction(1, "user1", ActionType.COMMENT, LocalDate.now(), "comment1");
        UserAction userAction1_3 = new UserAction(1, "user1", ActionType.LIKE, LocalDate.now(), "like2");
        UserAction userAction2_1 = new UserAction(2, "user2", ActionType.LIKE, LocalDate.now(), "like1");
        UserAction userAction2_2 = new UserAction(2, "user2", ActionType.COMMENT, LocalDate.now(), "comment1");
        UserAction userAction2_3 = new UserAction(2, "user2", ActionType.SHARE, LocalDate.now(), "share1");
        UserAction userAction3_1 = new UserAction(3, "user3", ActionType.SHARE, LocalDate.now(), "share2");

        List<UserAction> actions = Arrays.asList(userAction1_1, userAction1_2, userAction1_3, userAction2_1, userAction2_2,
                userAction2_3, userAction3_1);

        Map<ActionType, Double> actionPercentages = socialNetwork.findActionPercentages(actions);

        assertEquals(3, actionPercentages.size());

        assertTrue(actionPercentages.containsKey(ActionType.LIKE));
        assertEquals(42.857142857142854, actionPercentages.get(ActionType.LIKE));

        assertTrue(actionPercentages.containsKey(ActionType.COMMENT));
        assertEquals(28.57142857142857, actionPercentages.get(ActionType.COMMENT));

        assertTrue(actionPercentages.containsKey(ActionType.SHARE));
        assertEquals(28.57142857142857, actionPercentages.get(ActionType.SHARE));
    }
}