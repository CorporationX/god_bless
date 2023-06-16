package faang.school.godbless.GroupUsers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    private String name;
    private int age;
    private String work;
    private String city;

    @BeforeEach
    void setUp() {
        name = "Pole";
        age = 30;
        work = "Amazon";
        city = "New York";
    }

    @Test
    void testCreateUser() {
        User user = assertDoesNotThrow(() -> new User(name, age, work, city));
        assertEquals(name, user.getName());
        assertEquals(age, user.getAge());
        assertEquals(work, user.getWork());
        assertEquals(city, user.getCity());
    }

    @Test
    void shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new User("", 30, work, city));
        assertThrows(IllegalArgumentException.class, () -> new User(name, -5, work, city));
        assertThrows(IllegalArgumentException.class, () -> new User(name, 20, "Yandex", city));
        assertThrows(IllegalArgumentException.class, () -> new User(name, 20, work, "NewYork"));
    }

    @Test
    void testGroupUsers() {
        User userFirst = new User("Jason", 39, work, city);
        User userSecond = new User("Will", 60, work, city);
        User userThird = new User("Arni", 60, work, city);
        User userFourth = new User("Pole", 39, work, city);
        List<User> users = Stream.of(userFirst, userSecond, userThird, userFourth).toList();

        Map<Integer, List<User>> expectedResult = new HashMap<>();
        expectedResult.put(39, Stream.of(userFirst, userFourth).toList());
        expectedResult.put(60, Stream.of(userSecond, userThird).toList());

        Map<Integer, List<User>> groupUsers = User.groupUsers(users);

        assertEquals(expectedResult, groupUsers);
    }
}