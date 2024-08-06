import faang.school.godbless.BJS2_18414.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTests {
    private User user;

    @Test
    void testUserCreationThrowsException(){
        assertThrows(IllegalArgumentException.class, () -> new User("", 22, "Google", "London"));
        assertThrows(IllegalArgumentException.class, () -> new User("asd", 2, "Google", "London"));
        assertThrows(IllegalArgumentException.class, () -> new User("asd", 22, "Wrong", "London"));
        assertThrows(IllegalArgumentException.class, () -> new User("asd", 22, "Google", "Berlin"));
    }
}
