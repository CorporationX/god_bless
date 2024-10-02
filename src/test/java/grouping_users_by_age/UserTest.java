package grouping_users_by_age;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void groupUsers() {
        List<User> users = List.of(
                new User("John", 30, "Software Engineer", "123 Main St"),
                new User("Jane", 30, "Product Manager", "456 Oak Ave"),
                new User("Mark", 40, "VP of Engineering", "789 Elm St")
        );

        Map<Integer, List<User>> usersByAge = User.groupUsers(users);

        assertEquals(2, usersByAge.size());
        assertEquals(2, usersByAge.get(30).size());
        assertEquals(1, usersByAge.get(40).size());
    }
}