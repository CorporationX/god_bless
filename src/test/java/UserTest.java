import faang.school.godbless.User;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    void groupUsers() {

        List<User> users = new ArrayList<>();
        User user = new User("BOB", 10, "Test", "Test");
        User user1 = new User("TOM", 10, "Test", "Test");
        User user2 = new User("TEST", 20, "Test", "Test");
        users.add(user);
        users.add(user1);
        users.add(user2);

        Map<Integer, List<User>> res = User.groupUsers(users);
        assertEquals(2, res.size());
    }
}
