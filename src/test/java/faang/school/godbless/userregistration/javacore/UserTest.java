package faang.school.godbless.userregistration.javacore;

import faang.school.godbless.javacore.userregistration.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testValidUserCreation() {
        assertDoesNotThrow(() -> new User("John Doe", 25, "Google", "London"));
    }

    @Test
    void testInvalidAge() {
        IllegalArgumentException exp = assertThrows(IllegalArgumentException.class,
                () -> new User("John Doe", 17, "Google", "London"));
        assertEquals("User age can not be less than 18", exp.getMessage());
    }

    @Test
    void testInvalidJob() {
        IllegalArgumentException exp = assertThrows(IllegalArgumentException.class,
                () -> new User("John Doe", 25, "Unknown Company", "London"));
        assertEquals("User job is invalid", exp.getMessage());
    }

    @Test
    void testInvalidAddress() {
        IllegalArgumentException exp = assertThrows(IllegalArgumentException.class,
                () -> new User("John Doe", 25, "Google", "Unknown City"));
        assertEquals("User address is invalid", exp.getMessage());
    }

    @Test
    void testEmptyName() {
        IllegalArgumentException exp = assertThrows(IllegalArgumentException.class,
                () -> new User("", 25, "Google", "London"));
        assertEquals("User name can not be empty", exp.getMessage());
    }

}