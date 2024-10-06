import org.example.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    @DisplayName("test to group users by age")
    void testGroupUsersByAge() {
        List<User> users = new ArrayList<>(Arrays.asList(
                new User("Zhubanysh", 19, "Apple", "Almaty"),
                new User("Artur", 18, "Microsoft", "Almaty"),
                new User("Nurzhan", 19, "Amozon", "Almaty"),
                new User("Nurbek", 20, "Netflix", "Almaty")
        ));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        assertEquals(2, groupedUsers.get(19).size());
        assertEquals(1, groupedUsers.get(20).size());
        assertEquals(1, groupedUsers.get(18).size());
    }
}
