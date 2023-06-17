package faang.school.godbless.first;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    public void testWhenAdd2ElementsWithSameAgeValueSizeEquals2() {
        List<User> users = List.of(
                new User("a", 2, "a", "a"),
                new User("c", 2, "c", "c"),
                new User("a", 3, "c", "s")
        );

        Map<Integer, List<User>> result = User.groupUsers(users);

        assertEquals(2, result.size());
        assertTrue(result.containsKey(2));
        assertTrue(result.containsKey(3));
        assertFalse(result.containsKey(1));
    }
}