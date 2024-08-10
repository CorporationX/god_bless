package faang.school.godbless.java_base;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    @Test
    public void testFindHobbyLovers() {

        User user1 = new User(1, "Alice", 25, new HashSet<>(Set.of("Reading", "Swimming")));
        User user2 = new User(2, "Bob", 30, new HashSet<>(Set.of("Running", "Cooking")));
        User user3 = new User(3, "Charlie", 22, new HashSet<>(Set.of("Reading", "Gaming")));

        List<User> users = List.of(user1, user2, user3);
        Set<String> activities = Set.of("Reading", "Cooking");

        Map<User, String> expectedResult = Map.of(
                user1, "Reading",
                user2, "Cooking",
                user3, "Reading"
        );

        Map<User, String> actualResult = User.findHobbyLovers(users, activities);

        assertEquals(expectedResult.size(), actualResult.size());
        for (Map.Entry<User, String> entry : expectedResult.entrySet()) {
            assertTrue(actualResult.containsKey(entry.getKey()));
            assertEquals(entry.getValue(), actualResult.get(entry.getKey()));
        }

    }
}
