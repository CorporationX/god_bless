package faang.school.godbless.collecting_users;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    @Test
    void getHobbiesTest(){
        List <User> userList = List.of(
                new User(1, "name", 15, List.of("Games", "Books", "Movies")),
                new User(2, "name", 15, List.of("Gardening", "Music", "Movies")),
                new User(3, "name", 15, List.of("Hiking", "Books", "Diving")),
                new User(4, "name", 15, List.of("Yoga", "Traveling", "Movies")));
        List<String> hobbyList = List.of("Books", "Yoga", "Diving");
        Map<User,String> map = User.findHobbyLovers(userList, hobbyList);
        int expectedMapSize = 3;

        assertEquals(expectedMapSize, map.size());
        assertTrue(map.containsValue("Books"));
        assertTrue(map.containsValue("Yoga"));
    }
}
