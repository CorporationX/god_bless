package faang.school.godbless;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.User.groupUsers;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void groupUsersTest() {
        User user1 = new User("first", 1, "s", "s");
        User user2 = new User("second", 2, "s", "s");
        User user3 = new User("third", 1, "s", "s");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        Map<Integer, List<User>> map = groupUsers(userList);
        assertNotNull(map);
        assertEquals(2, map.size());
        assertEquals(2, map.get(1).size());
        assertEquals(1, map.get(2).size());
    }

    @Test
    void fieldsValidation() {
        assertThrows(IllegalArgumentException.class, () -> new User("", 20, "Google", "London"));
        assertThrows(IllegalArgumentException.class, () -> new User("Tim", 17, "Google", "London"));
        assertThrows(IllegalArgumentException.class, () -> new User("Tim", 20, "Meta", "London"));
        assertThrows(IllegalArgumentException.class, () -> new User("Tim", 20, "Google", "Moscow"));
    }
}