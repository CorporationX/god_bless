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

    @Test
    void expectsException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new User("", 17, "", ""));
        assertEquals("Name cannot be empty", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new User("John", 17, "", ""));
        assertEquals("Age cannot be less than 18", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new User("John", 18, "Test", ""));
        assertEquals("Invalid place of working", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new User("John", 18, "Uber", "123 Main St"));
        assertEquals("Invalid address", exception.getMessage());
    }
}