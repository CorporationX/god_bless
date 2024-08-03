package faang.school.godbless.BJS2_18388;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class UserTest {

    @Test
    void findHobbyLoversTest() {
        User user1 = new User(1, "Ivan", 20, Set.of("Formula1", "Hockey"));
        User user2 = new User(2, "Sergey", 30, Set.of("Football", "Hockey", "Formula1"));
        User user3 = new User(3, "Ilia", 25, Set.of("Formula1", "Basketball"));
        User user4 = new User(4, "Igor", 36, Set.of("Volleyball", "Basketball"));
        User user5 = new User(5, "Elena", 46, Set.of("TV", "Cooking"));
        User user6 = new User(6, "Stepan", 16, Set.of("Jumping", "Swimming"));

        List<User> users = List.of(user1, user2, user3, user4, user5, user6);

        Set<String> testSet = Set.of("Football", "Volleyball", "Basketball", "Hockey", "Formula1");
        Set<User> expected = Set.of(user1, user2, user3, user4);

        Set<User> actual = User.findHobbyLovers(users, testSet).keySet();

        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
        assertFalse(actual.contains(user5));
        assertFalse(actual.contains(user6));
    }
}