import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private User user;

    @BeforeEach
    void setUp() {
        this.user = new User();
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
