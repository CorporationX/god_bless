package GroupUsers;

import faang.school.godbless.GroupUsers.User;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static faang.school.godbless.GroupUsers.User.groupUsers;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void groupUsersTest() {
        User user1 = new User("first", 1, "s", "s");
        User user2 = new User("second", 2, "s", "s");
        User user3 = new User("third", 1, "s", "s");
        List<User> userList = List.of(user1, user2, user3);

        Map<Integer, List<User>> map = groupUsers(userList);

        assertNotNull(map);
        assertEquals(2, map.size());
        assertEquals(2, map.get(1).size());
        assertEquals(1, map.get(2).size());
    }
}