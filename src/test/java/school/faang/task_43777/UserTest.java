package school.faang.task_43777;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {

    @Test
    @DisplayName("Constructor: should create user with valid data")
    void constructor_shouldCreateUserWithValidData() {
        User user = new User("Alice", 25, "Google", "London");

        assertAll("User fields should be correct",
                () -> assertEquals("Alice", user.name()),
                () -> assertEquals(25, user.age()),
                () -> assertEquals("Google", user.job()),
                () -> assertEquals("London", user.address())
        );
    }

    @Test
    @DisplayName("Constructor: should throw exception for invalid name")
    void constructor_shouldThrowExceptionForInvalidName() {
        assertAll("Invalid name should throw IllegalArgumentException",
                () -> assertThrows(IllegalArgumentException.class, () -> new User(null, 25, "Google", "London")),
                () -> assertThrows(IllegalArgumentException.class, () -> new User("", 25, "Google", "London"))
        );
    }

    @Test
    @DisplayName("Constructor: should throw exception for invalid age")
    void constructor_shouldThrowExceptionForInvalidAge() {
        assertThrows(IllegalArgumentException.class, () -> new User("Alice", -1, "Google", "London"));
    }

    @Test
    @DisplayName("Constructor: should throw exception for invalid job")
    void constructor_shouldThrowExceptionForInvalidJob() {
        assertAll("Invalid job should throw IllegalArgumentException",
                () -> assertThrows(IllegalArgumentException.class, () -> new User("Alice", 25, null, "London")),
                () -> assertThrows(IllegalArgumentException.class, () -> new User("Alice", 25, "", "London")),
                () -> assertThrows(IllegalArgumentException.class, () -> new User("Alice", 25, "job", "London"))
        );
    }

    @Test
    @DisplayName("Constructor: should throw exception for invalid address")
    void constructor_shouldThrowExceptionForInvalidAddress() {
        assertAll("Invalid address should throw IllegalArgumentException",
                () -> assertThrows(IllegalArgumentException.class, () -> new User("Alice", 25, "Google", null)),
                () -> assertThrows(IllegalArgumentException.class, () -> new User("Alice", 25, "Google", "")),
                () -> assertThrows(IllegalArgumentException.class, () -> new User("Alice", 25, "Google", "address"))
        );
    }
}