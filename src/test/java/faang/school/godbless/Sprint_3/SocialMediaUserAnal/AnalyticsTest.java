package faang.school.godbless.Sprint_3.SocialMediaUserAnal;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnalyticsTest {
    List<UserAction> actionList = (List.of(
            new UserAction(111, "John", "share", LocalDateTime.now(), "#coding"),
            new UserAction(111, "John", "post", LocalDateTime.now(), "#coding"),
            new UserAction(111, "John", "like", LocalDateTime.now(), "#coding"),
            new UserAction(1, "John", "post", LocalDateTime.now(), "#coding"),
            new UserAction(2, "Hoby", "comment", LocalDateTime.now(), "#coding"),
            new UserAction(3, "Ivan", "comment", LocalDateTime.now(), "#games"),
            new UserAction(4, "Vlad", "like", LocalDateTime.now(), "#music"),
            new UserAction(5, "Kriper2004", "comment", LocalDateTime.now(), "coding"),
            new UserAction(6, "retardus", "like", LocalDateTime.now(), "#running"),
            new UserAction(7, "Coffee", "post", LocalDateTime.now(), "#coding"),
            new UserAction(8, "Mikkey", "share", LocalDateTime.now(), "#music"),
            new UserAction(9, "Dima", "post", LocalDateTime.now(), "#games"),
            new UserAction(10, "Dima K", "post", LocalDateTime.now(), "#games"),
            new UserAction(10, "Dima K", "like", LocalDateTime.now(), "#games"),
            new UserAction(10, "Dima K", "post", LocalDateTime.now(), "#games"),
            new UserAction(11, "Dima Z", "post", LocalDateTime.now(), "#games")
    ));

    @Test
    public void mostActiveTest() {

        assertEquals(Analytics.mostActive(actionList).get(0), 10);
    }

    @Test
    public void mostPopularTopicsTest() {

        assertEquals(Analytics.mostPopularTopics(actionList).get(0), "#coding");
    }

    @Test
    public void lastCommentsTest() {

        assertEquals(Analytics.lastComments(actionList).get(0), 2);
    }

    @Test
    public void getPersentTest() {

        assertEquals(Analytics.getPersent(actionList).get("like"), 25.0);
    }

}