package faang.school.godbless.GroupUsers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    @Test
    void shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new User("", 30, "", ""));
        assertThrows(IllegalArgumentException.class, () -> new User("Name", -5, "", ""));
    }

    @Test
    void testGroupUsers() {
        User userFirst = new User("Jason", 39, "Umbrella", "London");
        User userSecond = new User("Will", 60, "Umbrella", "NY");
        User userThird = new User("Arni", 60, "Umbrella", "NY");
        User userFourth = new User("Pole", 39, "Umbrella", "NY");
        List<User> users = Stream.of(userFirst, userSecond, userThird, userFourth).toList();

        Map<Integer, List<User>> expectedResult = new HashMap<>();
        expectedResult.put(39, Stream.of(userFirst, userFourth).toList());
        expectedResult.put(60, Stream.of(userSecond, userThird).toList());

        Map<Integer, List<User>> groupUsers = User.groupUsers(users);

        assertEquals(expectedResult, groupUsers);
    }
}