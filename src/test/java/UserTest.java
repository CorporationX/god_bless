import faang.school.godbless.user.User;
import faang.school.godbless.User;
import org.junit.jupiter.api.Test;

import java.util.*;

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
    
    @Test
    void groupUsers() {

      List<User> users = new ArrayList<>();
      User user = new User("BOB", 10, "Test", "Test");
      User user1 = new User("TOM", 10, "Test", "Test");
      User user2 = new User("TEST", 20, "Test", "Test");
      users.add(user);
      users.add(user1);
      users.add(user2);

      Map<Integer, List<User>> res = User.groupUsers(users);
      assertEquals(2, res.size());
    }
}
