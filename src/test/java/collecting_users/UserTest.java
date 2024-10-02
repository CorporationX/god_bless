package collecting_users;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void findHobbyLovers() {
        List<User> users = List.of(
                new User(UUID.randomUUID(), "John", 20, Set.of("hiking", "reading")),
                new User(UUID.randomUUID(), "Jane", 21, Set.of("hiking", "fishing", "reading")),
                new User(UUID.randomUUID(), "Mark", 22, Set.of("hiking", "fishing", "reading")),
                new User(UUID.randomUUID(), "Kate", 23, Set.of("hiking", "fishing", "reading")),
                new User(UUID.randomUUID(), "Sara", 24, Set.of("hiking", "fishing", "reading"))
        );

        Set<String> hobbies = Set.of("hiking", "fishing");

        User user = new User(UUID.randomUUID(), "John", 20, Set.of("hiking", "reading"));

        Map<User, String> result = user.findHobbyLovers(users, hobbies);
        assertEquals(5, result.size());
        assertEquals("hiking", result.get(users.get(0)));
    }
}