package faang.school.godbless.task2;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {

    private final List<User> users = new ArrayList<>();

    @Test
    void constructorTest() {
        assertThrows(IllegalArgumentException.class, () -> new User("Vova", 23, "", "London"));
    }

    @Test
    void groupUser() {
        User user1 = new User("Vova", 23, "Google", "London");
        User user2 = new User("Boba", 23, "Uber", "New York");
        User user3 = new User("Biba", 22, "Amazon", "Amsterdam");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        Map<Integer, List<User>> usersMap = User.groupUser(users);
        assertTrue(usersMap.keySet().containsAll(List.of(22, 23)));
        assertEquals(usersMap.get(22).size(), 1);
        assertEquals(usersMap.get(23).size(), 2);
    }
}