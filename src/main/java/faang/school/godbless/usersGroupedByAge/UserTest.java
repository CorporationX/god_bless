package faang.school.godbless.usersGroupedByAge;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    @Test void createUserValidation() {
        Exception exception;

        exception = assertThrows(IllegalArgumentException.class, () -> new User("", 29, "Uber", "New York"));
        assertEquals("Name cannot be null or empty", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new User("Dima", 17, "Amazon", "Amsterdam"));
        assertEquals("Age must be at least 18", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new User("Dima", 29, "Engineer", "London"));
        assertEquals("Invalid job", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new User("Dima", 29, "Google", "Dubai"));
        assertEquals("Invalid address", exception.getMessage());
    }

    @Test
    void createUserSuccessfully() {
        User user = new User("Dima", 29, "Google", "London");
        assertEquals("Dima", user.getName());
        assertEquals(29, user.getAge());
        assertEquals("Google", user.getJob());
        assertEquals("London", user.getAddress());
    }

    @Test
    void groupUsers() {
        User user1 = new User("Dima", 29, "Google", "London");
        User user2 = new User("Vasya", 29, "Uber", "New York");
        User user3 = new User("Petya", 24, "Amazon", "Amsterdam");
        User user4 = new User("Kolya", 21, "Google", "London");
        User user5 = new User("Oleg", 21, "Amazon", "Amsterdam");
        List<User> input = Arrays.asList(user1, user2, user3, user4, user5);

        Map<Integer, List<User>> expected = new HashMap<>();
        expected.put(29, Arrays.asList(user1, user2));
        expected.put(24, Arrays.asList(user3));
        expected.put(21, Arrays.asList(user4, user5));

        Map<Integer, List<User>> actual = User.groupUsers(input);

        assertEquals(expected, actual);
    }
}