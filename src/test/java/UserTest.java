import BJS2_18401.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    @Test
    public void testInvalidUserName() {
        assertThrows(IllegalArgumentException.class, () -> new User("", 19, "Google", "London"));
    }

    @Test
    public void testInvalidUserAge() {
        assertThrows(IllegalArgumentException.class, () -> new User("Andrew", 17, "Google", "London"));
    }

    @Test
    public void testInvalidUserPlaceOfWork() {
        assertThrows(IllegalArgumentException.class, () -> new User("Andrew", 19, "InvalidCompany", "London"));
    }

    @Test
    public void testInvalidUserAddress() {
        assertThrows(IllegalArgumentException.class, () -> new User("Andrew", 19, "Google", "InvalidAddress"));
    }
}
