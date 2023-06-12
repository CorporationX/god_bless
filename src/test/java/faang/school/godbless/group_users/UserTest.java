package faang.school.godbless.group_users;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class UserTest {

    @Test
    void testGroupUsers() {
        User user1 = new User("Alice", 25, "Google", "London");
        User user2 = new User("Bob", 25, "Uber", "New York");
        User user3 = new User("Charlie", 25, "Amazon", "Amsterdam");
        User user4 = new User("David", 27, "Google", "London");
        User user5 = new User("Eve", 27, "Uber", "New York");
        User user6 = new User("Frank", 27, "Amazon", "Amsterdam");
        User user7 = new User("Grace", 30, "Google", "London");
        User user8 = new User("Henry", 30, "Uber", "New York");
        User user9 = new User("Ivy", 30, "Amazon", "Amsterdam");
        User user10 = new User("Jack", 32, "Google", "London");
        List<User> users = Arrays.asList(user1, user2, user3, user4, null, user5, user6, user7, user8, user9, user10);

        Map<Integer, List<User>> testMap = User.groupUsers(users);

        assertEquals(4, testMap.size());
        assertTrue(testMap.containsKey(25));
        assertTrue(testMap.containsKey(27));
        assertTrue(testMap.containsKey(30));
        assertTrue(testMap.containsKey(32));
        assertFalse(testMap.containsKey(null));
        assertEquals(Arrays.asList(user1, user2, user3), testMap.get(25));
        assertEquals(Arrays.asList(user4, user5, user6), testMap.get(27));
        assertEquals(Arrays.asList(user7, user8, user9), testMap.get(30));
        assertEquals(Arrays.asList(user10), testMap.get(32));
    }
}