package faang.school.godbless.social_media;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserAnalyticsServiceTest {
    private static List<UserAction> userActions;

    @BeforeAll
    public static void init(){
        userActions = new ArrayList<>();
        userActions.add(new UserAction(1,"u1","post","abc #life"));
        userActions.add(new UserAction(1,"u1","post","abc #life"));
        userActions.add(new UserAction(1,"u2","comment","abc #life"));
        userActions.add(new UserAction(1,"u2","post","abc #cats"));
        userActions.add(new UserAction(1,"u3","post","abc #cats"));
        userActions.add(new UserAction(1,"u3","post","abc #coffee"));
        userActions.add(new UserAction(1,"u3","comment","abc #coffee"));
        userActions.add(new UserAction(1,"u3","comment","abc #cofee"));
        userActions.add(new UserAction(1,"u4","post","abc #tea"));
        userActions.add(new UserAction(1,"u5","like","abc #travel"));
        userActions.add(new UserAction(1,"u6","share","abc #work"));


    }

    @Test
    void testGetTopActiveUsers() {
        var expected = List.of("u1","u2","u3");
        assertEquals(expected,UserAnalyticsService.getTopActiveUsers(userActions,3));
    }

    @Test
    void testGetTopTopics() {
        var expected = List.of("life","cats","coffee");
        assertEquals(expected,UserAnalyticsService.getTopTopics(userActions,3));
    }

    @Test
    void testGetTopCommenters() {
        var expected = List.of("u3");
        assertEquals(expected,UserAnalyticsService.getTopCommenters(userActions,1));
    }

    @Test
    void testGetActionsPercentage() {
        var expected = Map.of("post",1,"comment",1,"like",1,"share",1);
        assertEquals(expected,UserAnalyticsService.getActionsPercentage(userActions));
    }
}
