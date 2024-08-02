import BJS2_18441.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    public void testUser1() {
        List<User> users = Arrays.asList(
                new User("Alice", 25, "Company A", "123 Main St"),
                new User("Bob", 30, "Company B", "456 Elm St"),
                new User("Charlie", 25, "Company C", "789 Maple St"),
                new User("David", 35, "Company D", "101 Oak St"),
                new User("Eve", 30, "Company E", "202 Pine St")
        );

        Map<Integer, List<User>> expected = new HashMap<>();

        expected.put(25, Arrays.asList(
                new User("Alice", 25, "Company A", "123 Main St"),
                new User("Charlie", 25, "Company C", "789 Maple St")
        ));
        expected.put(30, Arrays.asList(
                new User("Bob", 30, "Company B", "456 Elm St"),
                new User("Eve", 30, "Company E", "202 Pine St")
        ));
        expected.put(35, Arrays.asList(
                new User("David", 35, "Company D", "101 Oak St")
        ));

        Map<Integer, List<User>> result = User.groupUsers(users);

        assertEquals(expected, result);
    }
}
