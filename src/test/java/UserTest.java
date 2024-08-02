import faang.school.godbless.BJS2_18381.User;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    public void testUser1() {
        Set<String> activities1 = new HashSet<>(Arrays.asList("Hiking", "Reading"));
        Set<String> activities2 = new HashSet<>(Arrays.asList("Swimming", "Gaming"));
        Set<String> activities3 = new HashSet<>(Arrays.asList("Cooking", "Reading"));

        List<User> users = new ArrayList<>();
        users.add(new User(1, "Alice", activities1));
        users.add(new User(2, "Bob", activities2));
        users.add(new User(3, "Charlie", activities3));

        Set<String> searchActivities = new HashSet<>(Arrays.asList("Reading", "Gaming"));

        Map<User, String> expected = new HashMap<>();
        expected.put(new User(1, "Alice", activities1), "Reading");
        expected.put(new User(2, "Bob", activities2), "Gaming");
        expected.put(new User(3, "Charlie", activities3), "Reading");

        assertEquals(expected, User.findHobbyLovers(users, searchActivities));
    }
}
