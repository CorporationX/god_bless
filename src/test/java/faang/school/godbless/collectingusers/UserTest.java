package faang.school.godbless.collectingusers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    User alice;
    User bob;
    User charlie;
    List<User> users;
    Set<String> activities;
    Map<User, String> expected;
    Map<User, String> result;

    @BeforeEach
    public void setUp() {
        alice = new User(1, "Alice", 25, new HashSet<>(Arrays.asList("Reading", "Cooking")));
        bob = new User(2, "Bob", 30, new HashSet<>(Arrays.asList("Swimming", "Running")));
        charlie = new User(3, "Charlie", 35, new HashSet<>(Arrays.asList("Coding", "Cycling")));
        users = List.of(alice, bob, charlie);
    }

    @AfterEach
    public void tearDown() {
        users = null;
    }

    @Test
    @DisplayName("Проверка для случая с пересекающимися активностями")
    public void testFindHobbyLoversWithMatchingActivities() {
        activities = Set.of("Cooking", "Running");

        expected = new HashMap<>();
        expected.put(alice, "Cooking");
        expected.put(bob, "Running");

        result = User.findHobbyLovers(users, activities);

        assertEquals(expected.size(), result.size(),
                "Размер результирующей мапы должен соответствовать размеру ожидаемой мапы.");
        for (Map.Entry<User, String> entry : expected.entrySet()) {
            assertTrue(result.containsKey(entry.getKey()), "Пользователь должен быть включён в мапу.");
            assertEquals(entry.getValue(), result.get(entry.getKey()),
                    "Активность должна соответствовать ожидаемому значению.");
        }
    }

    @Test
    @DisplayName("Проверка для случая с непересекающимися активностями")
    public void testFindHobbyLoversWithNoMatchingActivities() {
        activities = Set.of("Hiking", "Fishing");
        expected = new HashMap<>();
        result = User.findHobbyLovers(users, activities);

        assertEquals(expected, result,
                "Мапа должна быть пуста при отсутствии пересекающихся активностей.");
    }

    @Test
    @DisplayName("Проверка для случая с пустым списком пользователей и множеством активностей")
    public void testFindHobbyLoversWithEmptyUserListAndActivities() {
        users = new ArrayList<>();
        activities = new HashSet<>();
        expected = new HashMap<>();
        result = User.findHobbyLovers(users, activities);

        assertEquals(expected, result,
                "Мапа должна быть пуста при пустых списке пользователей и множестве активностей.");
    }
}
