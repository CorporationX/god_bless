package faang.school.godbless.users_by_age;

import faang.school.godbless.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestUser {
    @Test
    void testGroupUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(new User(Integer.toString(i), i % 3, Integer.toString(i), Integer.toString(i)));
        }
        Map<Integer, List<User>> sortedUsers = User.groupUsers(users);

        assertEquals(3, sortedUsers.size());
    }
}