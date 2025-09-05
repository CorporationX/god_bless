package school.faang.group_by_age;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class UserTest {

    @Test
    void testGroupUsers() {
        User user1 = new User("Миша", 32, "Amazon", "SPB");
        User user2 = new User("Влад", 28, "Uber", "Amsterdam");
        User user3 = new User("Петя", 32, "Yandex", "Moscow");
        User user4 = new User("Оля", 28, "Apple", "Paris");
        User user5 = new User("Маша", 23, "Netflix", "San-Francisco");
        User user6 = new User("Катя", 26, "Google", "Yakutsk");

        List<User> users = List.of(user1, user2, user3, user4, user5, user6);

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        Assertions.assertIterableEquals(groupedUsers.get(28), List.of(user2, user4));
        Assertions.assertIterableEquals(groupedUsers.get(32), List.of(user1, user3));
        Assertions.assertIterableEquals(groupedUsers.get(23), List.of(user5));
        Assertions.assertIterableEquals(groupedUsers.get(26), List.of(user6));
        Assertions.assertEquals(4, groupedUsers.size());
    }
}