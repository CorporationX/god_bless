package school.faang.task_43728;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void testSuccessCreateUser() {
        assertDoesNotThrow(() -> new User("Jo", 20, "Google", "New York"));
        assertDoesNotThrow(() -> new User("David", 40, "Uber", "London"));
    }

    @Test
    public void testCreateUserThrowException() {
        assertThrows(
            IllegalArgumentException.class, () -> new User("Oscar", 20, "Invalid job", "New York")
        );
        assertThrows(
            IllegalArgumentException.class, () -> new User("John", 12, "Google", "New York")
        );
        assertThrows(
            IllegalArgumentException.class, () -> new User("Mark", 20, "Amazon", "Invalid address")
        );
        assertThrows(
            IllegalArgumentException.class, () -> new User(null, 20, "Amazon", "Amsterdam")
        );
        assertThrows(
            IllegalArgumentException.class, () -> new User("    ", 20, "Amazon", "Amsterdam")
        );
        assertThrows(
            IllegalArgumentException.class, () -> new User("", 20, "Amazon", "Amsterdam")
        );
    }
}