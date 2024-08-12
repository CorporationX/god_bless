import faang.school.godbless.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @Test
    void creationIncorrectAgeUserTest() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("BOB", 10, "Uber", "Amsterdam"),
                "Age couldn't be less than 18");
    }

    @Test
    void creationIncorrectNameUserTest() {
        assertThrows(IllegalArgumentException.class,
                () -> new User(null, 18, "Uber", "Amsterdam"),
                "Name couldn't be empty");

        assertThrows(IllegalArgumentException.class,
                () -> new User("               ", 18, "Uber", "Amsterdam"),
                "Name couldn't be empty");
    }

    @Test
    void creationIncorrectJobUserTest() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("BOB", 18, "Unknown", "Amsterdam"),
                "Job should be from [Amazon, Uber, Google]");
    }

    @Test
    void creationIncorrectAddressUserTest() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("BOB", 18, "Amazon", "Russia"),
                "Address should be from [New York, London, Amsterdam]");
    }

    @Test
    void creationCorrectUserTest() {
        User user = new User("BOB", 18, "Amazon", "London");
        assertEquals(user, new User("BOB", 18, "Amazon", "London"));
    }
}
