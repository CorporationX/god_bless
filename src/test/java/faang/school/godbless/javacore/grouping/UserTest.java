package faang.school.godbless.javacore.grouping;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    void testGroupUsers() {
        int age25 = 25;
        int age30 = 30;
        int age28 = 28;

        User user1 = new User("Alice", age25, "ABC Corp", "123 Main St");
        User user2 = new User("Bob", age30, "XYZ Corp", "456 Elm St");
        User user3 = new User("Charlie", age28, "ABC Corp", "789 Oak St");
        User user4 = new User("David", age25, "ABC Corp", "123 Main St");
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
}