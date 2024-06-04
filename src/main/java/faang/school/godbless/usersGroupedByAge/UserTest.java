package faang.school.godbless.usersGroupedByAge;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    void groupUsers() {
        User user1 = new User("Dima", 29, "Engineer", "Dubai");
        User user2 = new User("Vasya", 29, "Engineer", "Saint-Petersburg");
        User user3 = new User("Petya", 24, "PM", "Moscow");
        User user4 = new User("Kolya", 21, "PM", "Belgrade");
        User user5 = new User("Oleg", 21, "Designer", "Berlin");
        List<User> input = Arrays.asList(user1, user2, user3, user4, user5);

        Map<Integer, List<User>> expected = new HashMap<>();
        expected.put(29, Arrays.asList(user1, user2));
        expected.put(24, Arrays.asList(user3));
        expected.put(21, Arrays.asList(user4, user5));

        Map<Integer, List<User>> actual = User.groupUsers(input);

        assertEquals(expected, actual);
    }
}