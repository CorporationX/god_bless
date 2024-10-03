import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class UserTest {
    private User user;

    @Test
    @DisplayName("registration users(positive)")
    void positiveTestRegistrationUsers(){
        User user1 = new User("Name1" ,18, "Amazon", "London");
        User user2 = new User("Name2" ,19, "Uber", "Amsterdam");
        User user3 = new User("Name3" ,20, "Google", "New York");

        assertNotNull(user1);
        assertNotNull(user2);
        assertNotNull(user3);
    }

    @Test
    @DisplayName("registration users(negative)")
    void negativeTestRegistrationUsers() {
        assertThrows(IllegalArgumentException.class, () -> new User("", 18, "Amazon", "London"));
        assertThrows(IllegalArgumentException.class, () -> new User("Name", 17, "Amazon", "London"));
        assertThrows(IllegalArgumentException.class, () -> new User("Name", 18, "Apple", "London"));
        assertThrows(IllegalArgumentException.class, () -> new User("Name", 18, "Amazon", "Barcelona"));
    }
}
