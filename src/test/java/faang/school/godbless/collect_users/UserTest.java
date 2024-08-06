package faang.school.godbless.collect_users;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void shouldGetAllUsersWithActivity() {
        List<String> activities = List.of("painting", "dancing");
        List<User> users = new ArrayList<>();
        User user1 = new User(1, "a", 1, List.of("painting"));
        User user2 = new User(2, "b", 1, List.of("skating", "dancing"));
        User user3 = new User(3, "c", 1, List.of("pottery", "painting", "dancing"));
        User user4 = new User(4, "d", 1, List.of());
        User user5 = new User(5, "d", 1, List.of("pottery"));
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        var expected = Map.of(user1, "painting", user2, "dancing", user3, "painting");

        assertEquals(expected, User.findHobbyLovers(users, activities));
    }
}