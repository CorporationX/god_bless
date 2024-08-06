package faang.school.godbless.by_age;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void shouldGroupByAge() {
        List<User> users = new ArrayList<>();
        User user1 = new User("a", 1, "", "");
        User user2 = new User("b", 1, "", "");
        User user3 = new User("c", 2, "", "");
        User user4 = new User("d", 3, "", "");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        var expected = Map.of(1, List.of(user1, user2), 2, List.of(user3), 3, List.of(user4));
        
        assertEquals(expected, User.groupUsers(users));
    }
}