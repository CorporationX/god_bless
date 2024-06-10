package faang.school.godbless.task1;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {

    private final List<User> users = new ArrayList<>();

    @BeforeEach
    void setUp() {
        User user1 = new User("Vova1", 23, "smth1", "smth1");
        User user2 = new User("Vova2", 23, "smth2", "smth2");
        User user3 = new User("Vova3", 22, "smth3", "smth3");
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    @Test
    void groupUser() {
        Map<Integer, List<User>> usersMap = User.groupUser(users);
        assertTrue(usersMap.keySet().containsAll(List.of(22, 23)));
        assertEquals(usersMap.get(22).size(), 1);
        assertEquals(usersMap.get(23).size(), 2);
    }
}