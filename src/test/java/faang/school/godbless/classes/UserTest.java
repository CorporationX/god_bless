package faang.school.godbless.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class UserTest {
    private static final List<String> ACTIVITIES = List.of("Games", "Movie", "Sport", "Anime");
    private static List<User> allUsers;
    private static User firstUser;
    private static User secondUser;
    private static User thirdUser;
    private static User fourthUser;
    private static User fifthUser;

    @BeforeAll
    public static void setUp(){
        firstUser = new User(0, "Rustam", 21, List.of("Games", "Anime"));
        secondUser = new User(1, "Ruby", 20, List.of("Anime", "Games"));
        thirdUser = new User(2, "Andrew", 21, List.of("Movie", "Sport", "Anime"));
        fourthUser = new User(3, "Sasha", 26, List.of("Sport", "Anime"));
        fifthUser = new User(4, "Artem", 19, List.of("Cook"));
        allUsers = List.of(firstUser, secondUser, thirdUser, fourthUser, fifthUser);
    }

    @Test
    @DisplayName("find Hobby Lovers Test")
    public void findHobbyLoverTest(){
        Map<User, String> map = User.findHobbyLovers(allUsers, ACTIVITIES);
        Assertions.assertEquals("Games", map.get(firstUser));
        Assertions.assertEquals("Games", map.get(secondUser));
        Assertions.assertEquals("Movie", map.get(thirdUser));
        Assertions.assertEquals("Sport", map.get(fourthUser));
        Assertions.assertNull(map.get(fifthUser));
    }
}
