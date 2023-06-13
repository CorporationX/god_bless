package faang.school.godbless.task1;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testGroupUsers() {
        User user1 = new User("Петя", 18, "ЯНДЕКС", "Москва");
        User user2 = new User("Антон", 19, "ЯНДЕКС", "Москва");
        User user3 = new User("Вася", 19, "ЯНДЕКС", "Москва");
        User user4 = new User("Борис", 20, "ЯНДЕКС", "Москва");
        User user5 = new User("Алеша", 20, "ЯНДЕКС", "Москва");

        List<User> users = List.of(user1, user2, user3, user4, user5);

        Map<Integer, List<User>> actual = User.groupUsers(users);

        assertIterableEquals(actual.get(20), List.of(user4, user5));
    }
}