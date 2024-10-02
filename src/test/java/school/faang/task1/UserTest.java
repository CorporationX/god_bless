package school.faang.task1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static school.faang.task1.User.addUserToList;
import static school.faang.task1.User.groupUsers;

public class UserTest {

    @Test
    public void testAddUserToList() {
        List<User> users = new ArrayList<>();
        User user = new User("User 1", 20, "Company 1", "Address 111");
        addUserToList(users, user);

        assertEquals(1, users.size());
        assertEquals(user, users.get(0));

        addUserToList(users, null);
        assertEquals(2, users.size());
    }

    @Test
    public void testGroupUsersSingleElement() {
        List<User> users = new ArrayList<>();
        User user = new User("User 1", 20, "Company 1", "Address 111");
        users.add(user);

        Map<Integer, List<User>> sortedUsers = groupUsers(users);

        assertEquals(1, sortedUsers.size());
        assertEquals(users, sortedUsers.get(20));
    }

    @Test
    public void testGroupUsersMultipleUsersDifferentAge() {
        List<User> users = new ArrayList<>();
        User user1 = new User("User 1", 30, "Company 1", "Address 111");
        User user2 = new User("User 2", 20, "Company 2", "Address 222");
        users.add(user1);
        users.add(user2);

        Map<Integer, List<User>> sortedUsers = groupUsers(users);

        assertEquals(2, sortedUsers.size());
        assertEquals(1, sortedUsers.get(20).size());
        assertEquals(List.of(user2), sortedUsers.get(20));
    }

    @Test
    public void testGroupUsersMultipleUsersSameAge() {
        List<User> users = new ArrayList<>();
        User user1 = new User("User 1", 30, "Company 1", "Address 111");
        User user2 = new User("User 2", 30, "Company 2", "Address 222");
        users.add(user1);
        users.add(user2);

        Map<Integer, List<User>> sortedUsers = groupUsers(users);

        assertEquals(1, sortedUsers.size());
        assertEquals(2, sortedUsers.get(30).size());
        assertEquals(List.of(user1, user2), sortedUsers.get(30));
    }

    @Test
    public void testGroupUsersEmptyList() {
        List<User> users = new ArrayList<>();
        Map<Integer, List<User>> integerListMap = groupUsers(users);

        assertEquals(0, integerListMap.size());
    }
}
