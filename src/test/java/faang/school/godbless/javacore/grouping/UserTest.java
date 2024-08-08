package faang.school.godbless.javacore.grouping;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {

    @Test
    void testGroupUsers() {
        int age25 = 25;
        int age30 = 30;
        int age28 = 28;

        User user1 = new User("Alice", age25, "Google", "London");
        User user2 = new User("Bob", age30, "Google", "New York");
        User user3 = new User("Charlie", age28, "Uber", "Amsterdam");
        User user4 = new User("David", age25, "Amazon", "London");
        List<User> users = Arrays.asList(user1, user2, user3, user4);

        Map<Integer, List<User>> result = User.groupUsers(users);

        assertEquals(3, result.size());

        assertEquals(2, result.get(age25).size());
        assertEquals(user1, result.get(age25).get(0));
        assertEquals(user4, result.get(age25).get(1));

        assertEquals(1, result.get(age30).size());
        assertEquals(user2, result.get(age30).get(0));

        assertEquals(1, result.get(age28).size());
        assertEquals(user2, result.get(age30).get(0));
    }

    @Test
    void testGroupUsers_NameNotValid() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new User("", 25, "Google", "London"),
                "Expected IllegalArgumentException to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contains("Имя не может быть пустым"));
    }

    @Test
    void testGroupUsers_AgeNotValid() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new User("Alice", 16, "Google", "London"),
                "Expected IllegalArgumentException to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contains("Возраст не может быть меньше 18"));
    }

    @Test
    void testGroupUsers_JobNotValid() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new User("Alice", 25, "KGB", "London"),
                "Expected IllegalArgumentException to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contains("Место работы должно быть \"Google\", \"Uber\" или \"Amazon\""));
    }

    @Test
    void testGroupUsers_AddressNotValid() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new User("Alice", 25, "Google", "Moscow"),
                "Expected IllegalArgumentException to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contains("Адрес должен быть \"London\", \"New York\" или \"Amsterdam\""));
    }
}