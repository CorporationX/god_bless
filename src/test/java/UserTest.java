import faang.school.godbless.BJS2_18474.User;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private User user;

    @Test
    void testUsersAreSorted(){
        List<User> users = List.of(
                new User("A", 19, "Yandex", "Pupsnaya"),
                new User("F", 19, "Pandex", "Pupsnaya"));

        Map<Integer, List<User>> sortedUsers = User.groupUsers(users);

        assertEquals(1, sortedUsers.size());
    }
}
