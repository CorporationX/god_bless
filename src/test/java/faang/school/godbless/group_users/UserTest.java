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
        User user1 = new User("Alice", 25, "Company A", "123 Main St");
        User user2 = new User("Bob", 25, "Company B", "456 Elm St");
        User user3 = new User("Charlie", 25, "Company C", "789 Oak St");
        User user4 = new User("David", 27, "Company A", "321 Pine St");
        User user5 = new User("Eve", 27, "Company B", "654 Cedar St");
        User user6 = new User("Frank", 27, "Company C", "987 Birch St");
        User user7 = new User("Grace", 30, "Company A", "135 Walnut St");
        User user8 = new User("Henry", 30, "Company B", "468 Maple St");
        User user9 = new User("Ivy", 30, "Company C", "791 Cherry St");
        User user10 = new User("Jack", 32, "Company A", "246 Spruce St");
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