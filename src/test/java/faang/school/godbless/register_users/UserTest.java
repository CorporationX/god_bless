package faang.school.godbless.register_users;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testValidArgs() {
        assertDoesNotThrow(() ->  new User("Jacob", 19, "Apple", "London"));
    }

    @Test
    public void testInvalidArgs() {
        assertThrows(IllegalArgumentException.class, () -> new User("", 19, "Microsoft", "London"));
        assertThrows(IllegalArgumentException.class, () -> new User("Walter", 17, "Uber", "Amsterdam"));
        assertThrows(IllegalArgumentException.class, () -> new User("Michael", 25, "EPAM", "Amsterdam"));
        assertThrows(IllegalArgumentException.class, () -> new User("James", 23, "Uber", "Beijing"));
    }
}
