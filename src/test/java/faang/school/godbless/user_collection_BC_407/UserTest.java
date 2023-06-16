package faang.school.godbless.user_collection_BC_407;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserTest {

    @Test
    public void testGetCorrectMapOfHobbyLovers() {
        User user = new User();
        user.setId(1);
        user.setAge(45);
        user.setName("name");
        user.getActivities().addAll(List.of("act1", "act2", "act3"));

        User user2 = new User();
        user2.setId(2);
        user2.setAge(45);
        user2.setName("name2");
        user2.getActivities().addAll(List.of("act4", "act2", "act6"));

        User user3 = new User();
        user3.setId(3);
        user3.setAge(45);
        user3.setName("name3");
        user3.getActivities().addAll(List.of("act1", "act5", "act3"));

        Map<User, String> expected = new HashMap<>();
        expected.put(user, "act3");
        expected.put(user2, "act6");
        expected.put(user3, "act3");

        Map<User, String> actual = User.findHobbyLovers(List.of(user, user2, user3), Set.of("act3", "act5", "act7", "act6"));

        Assertions.assertEquals(actual, expected);
    }
}
