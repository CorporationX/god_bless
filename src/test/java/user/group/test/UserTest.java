package user.group.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import user.group.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    @Test
    @DisplayName("Testing group method with null list of users")
    void userTest_groupUsersIfListOfUsersIsNull() {
        List<User> users = null;

        var result = User.groupUsers(users);

        assertNull(result);
    }

    @Test
    @DisplayName("Testing group method for correct result")
    void userTest_groupUsersCorrectResult() {
        List<User> users = List.of(
                new User("Petya", 18, "Somewhere", "Elsewhere"),
                new User("Vasya", 20, "Somewhere", "Elsewhere"),
                new User("Katya", 19, "Somewhere", "Elsewhere"),
                new User("Dimas", 19, "Somewhere", "Elsewhere"),
                new User("Vika", 20, "Somewhere", "Elsewhere")
        );

        var result = User.groupUsers(users);

        assertAll(
                () -> assertEquals(3, result.size()),
                () -> assertTrue(result.containsKey(18)),
                () -> assertTrue(result.containsKey(19)),
                () -> assertTrue(result.containsKey(20))
        );
    }
}
