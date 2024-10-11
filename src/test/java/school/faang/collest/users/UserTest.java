package school.faang.collest.users;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void findHobbyLoversTest() {
        User user1 = new User(1, "Name1", 1, new HashSet<>(Arrays.asList("Hobby1", "Hobby4")));
        User user2 = new User(2, "Name1", 2, new HashSet<>(Arrays.asList("Hobby2", "Hobby4")));
        User user3 = new User(3, "Name1", 3, new HashSet<>(Arrays.asList("Hobby3", "Hobby4")));
        List<User> users = List.of(user1, user2, user3);

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, Set.of("Hobby4"));

        assertEquals(3, hobbyLovers.size());
    }
}