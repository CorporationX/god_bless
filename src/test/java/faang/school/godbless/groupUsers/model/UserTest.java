package faang.school.godbless.groupUsers.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    @Test
    public void testGroupUsersByAge() {
        List<User> users = new ArrayList<>();
        User user1 = new User("John", 23, "Amazon", "New York");
        User user2 = new User("Alice", 30, "Uber", "Washington");
        User user3 = new User("Bred", 23, "Apple", "Los Angeles");
        User user4 = new User("Aron", 18, "Meta", "New York");
        User user5 = new User("Justin", 30, "Google", "Los Angeles");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        Map<Integer, List<User>> resultGroupsMap = User.groupUsersByAge(users);
        assertEquals(3, resultGroupsMap.size());
        List<User> groupBy23 = resultGroupsMap.get(23);
        assertTrue(groupBy23.contains(user1));
        assertTrue(groupBy23.contains(user3));
        List<User> groupBy30 = resultGroupsMap.get(30);
        assertTrue(groupBy30.contains(user2));
        assertTrue(groupBy30.contains(user5));
        List<User> groupBy18 = resultGroupsMap.get(18);
        assertTrue(groupBy18.contains(user4));
    }
}
