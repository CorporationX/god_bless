package faang.school.godbless.sprint2.task1;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testGroupUsers() {
        User user1 = new User("Петя", 18, "Google", "London");
        User user2 = new User("Антон", 19, "Uber", "Amsterdam");
        User user3 = new User("Вася", 19, "Amazon", "New York");
        User user4 = new User("Борис", 20, "Google", "London");
        User user5 = new User("Алеша", 20, "Amazon", "New York");

        List<User> users = List.of(user1, user2, user3, user4, user5);

        Map<Integer, List<User>> actual = User.groupUsers(users);

        assertIterableEquals(actual.get(20), List.of(user4, user5));
    }

    @Test
    void testValidationUsers() {

        assertThrows(IllegalArgumentException.class, () -> new User("Петя", 18, "ИП Иваное", "London"));
        assertThrows(IllegalArgumentException.class, () -> new User("Петя", 17, "Google", "London"));
        assertThrows(IllegalArgumentException.class, () -> new User(" ", 18, "Google", "London"));
        assertThrows(IllegalArgumentException.class, () -> new User("Петя", 18, "Google", "Окленд"));
    }
}