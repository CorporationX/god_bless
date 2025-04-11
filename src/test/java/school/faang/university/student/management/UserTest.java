package school.faang.university.student.management;

import org.junit.jupiter.api.Test;
import school.faang.user_collection.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    @Test
    void findHobbyLovers_shouldFindUsersWithMatchingActivities() {
        User user1 = new User(1, "user1", 25, Set.of("A", "B"));
        User user2 = new User(2, "user2", 30, Set.of("E", "D"));
        User user3 = new User(3, "user3", 3, Set.of("F"));
        List<User> users = Arrays.asList(user1, user2, user3);
        Set<String> targetActivities = Set.of("A", "D", "E");

        Map<User, String> result = user1.findHobbyLovers(users, targetActivities);

        assertAll(
                () -> assertEquals(2, result.size(), "Должно быть найдено 2 пользователя"),
                () -> assertTrue(result.containsKey(user1), "user1 должен быть найден"),
                () -> assertEquals("A", result.get(user1), "user1 должен иметь активность A"),
                () -> assertTrue(result.containsKey(user2), "user2 должен быть найден"),
                () -> assertTrue(result.get(user2).equals("D") || result.get(user2).equals("E"),
                        "user2 должен иметь активность D или E"),
                () -> assertFalse(result.containsKey(user3), "user3 не должен быть найден")
        );
    }
}
