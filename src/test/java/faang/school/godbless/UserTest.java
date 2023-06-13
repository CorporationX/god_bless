package faang.school.godbless;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static faang.school.godbless.User.groupUsers;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void groupUsersTest() {
        User user1 = new User("Ivan", 18, "none", "house");
        User user2 = new User("Vlas", 5, "none2", "house1");
        User user3 = new User("Dima", 18, "none3", "house3");
        List<User> listOfUsers = List.of(user1, user2, user3);

        Map<Integer, List<User>> res = groupUsers(listOfUsers);

        assertNotNull(res);
        assertEquals(2, res.size());
        assertEquals(2, res.get(18).size());
    }
}