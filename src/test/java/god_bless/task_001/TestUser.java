package god_bless.task_001;

import faang.school.godbless.task_001.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestUser {
    @Test
    void testGroupUsers() {
        User user1 = new User("User1", 18, "placeWork1", "address1");
        User user2 = new User("User2", 19, "placeWork2", "address2");
        User user3 = new User("User3", 20, "placeWork3", "address3");
        User user4 = new User("User4", 20, "placeWork4", "address4");
        List<User> users = Arrays.asList(user1, user2, user3, user4);

        Map<Integer, List<User>> groupUsers = User.groupUsers(users);

        assertEquals(3, groupUsers.size(), "there should be 3 user groups");
        assertTrue(groupUsers.containsKey(18), "there should be a group of 18 year olds");
        assertEquals(2, groupUsers.get(20).size(),
                "there must be two users in the group of twenty-somethings");
    }
}
