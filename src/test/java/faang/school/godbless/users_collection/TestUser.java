package faang.school.godbless.users_collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static faang.school.godbless.users_collection.User.findHobbyLovers;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUser {
    @Test
    public void testUserCollection() {
        User user1 = new User(1, "TestName1", 22, Set.of("Swim", "Run", "Play"));
        User user2 = new User(12, "TestName2", 27, Set.of("PLay", "Swim"));
        User user3 = new User(13, "TestName3", 21, Set.of("Swim", "Run"));
        User user4 = new User(4, "TestName4", 44, Set.of("Play"));
        User user5 = new User(5, "TestName5", 12, new HashSet<>());

        List<User> users = new ArrayList<>(List.of(user1, user2, user3, user4, user5));
        Set<String> set = new HashSet<>(Set.of("Run", "Swim"));

        Map<User, String> testMap = findHobbyLovers(users, set);

        assertTrue(testMap.containsKey(user1));
        assertTrue(testMap.containsKey(user2));
        assertTrue(testMap.containsKey(user3));
        assertFalse(testMap.containsKey(user5));
        assertEquals("Run", testMap.get(user1));
    }
}
