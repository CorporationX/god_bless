package faang.school.godbless;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static faang.school.godbless.User.groupUsers;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void groupUsersTest() {
        User user1 = new User("first", 20, Jobs.GOOGLE, Addresses.LONDON);
        User user2 = new User("second", 25, Jobs.GOOGLE, Addresses.LONDON);
        User user3 = new User("third", 20, Jobs.GOOGLE, Addresses.LONDON);
        List<User> userList = List.of(user1, user2, user3);

        Map<Integer, List<User>> map = groupUsers(userList);

        assertNotNull(map);
        assertEquals(2, map.size());
        assertEquals(2, map.get(20).size());
        assertEquals(1, map.get(25).size());
    }

    @Test
    void fieldsValidation() {
        assertThrows(IllegalArgumentException.class, () -> new User("", 20, Jobs.GOOGLE, Addresses.LONDON));
        assertThrows(IllegalArgumentException.class, () -> new User("Tim", 17, Jobs.GOOGLE, Addresses.LONDON));
    }
}