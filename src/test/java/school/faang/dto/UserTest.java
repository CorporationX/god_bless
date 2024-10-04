package school.faang.dto;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class UserTest {

    @Test
    void groupUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Alice", 30, "Developer", "123 Main St"));
        users.add(new User("Bob", 25, "Designer", "456 Maple Ave"));
        users.add(new User("Charlie", 28, "Manager", "789 Oak Dr"));
        users.add(new User("Diana", 32, "Analyst", "101 Pine Ln"));
        users.add(new User("Eve", 27, "Tester", "202 Birch Rd"));
        users.add(new User("Carl", 25, "Manager", "123 Maple Ave"));

        Map<Integer, List<User>>resultMap = User.groupUsers(users);
        assertNotNull(resultMap);
        System.out.println(resultMap);
    }
}