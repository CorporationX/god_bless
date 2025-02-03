package registeringusers;

import org.junit.jupiter.api.Test;
import school.faang.registeringusers.User;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class UserTest {

    @Test
    public void testUserPositive() {
        assertDoesNotThrow(() ->
                new User("Maxim", 26, "Google", "New York"));
    }

    @Test
    public void testUserNameException() {
        assertThrows(IllegalArgumentException.class, () ->
                new User("   ", 26, "Google", "New York"));
    }

    @Test
    public void testUserAgeException() {
        assertThrows(IllegalArgumentException.class, () ->
                new User("Maxim", 17, "Google", "New York"));
    }

    @Test
    public void testUserJobException() {
        assertThrows(IllegalArgumentException.class, () ->
                new User("Maxim", 26, "Sberbank", "New York"));
    }

    @Test
    public void testUserAddressException() {
        assertThrows(IllegalArgumentException.class, () ->
                new User("Maxim", 26, "Google", "Moscow"));
    }
}
