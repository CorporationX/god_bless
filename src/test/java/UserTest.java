import org.junit.jupiter.api.Test;
import school.faang.User;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class UserTest {

    @Test
    public void testGroupUsers() {
        // create user's list
        List<User> users = new ArrayList<>();
        users.add(new User("Alice", 30, "Engineer", "123 Main St"));
        users.add(new User("Bob", 25, "Designer", "456 Oak St"));
        users.add(new User("Charlie", 30, "Teacher", "789 Pine St"));
        users.add(new User("David", 25, "Doctor", "101 Maple St"));
        users.add(new User("Eve", 40, "Artist", "202 Birch St"));

        // call method groupUsers
        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        // Check uniq ages: 30, 25, 40
        assertEquals(3, groupedUsers.size());

        // check two user for age 30
        assertTrue(groupedUsers.containsKey(30));
        assertEquals(2, groupedUsers.get(30).size());
        assertEquals("Alice", groupedUsers.get(30).get(0).getName());
        assertEquals("Charlie", groupedUsers.get(30).get(1).getName());

        // check two user for age 25
        assertTrue(groupedUsers.containsKey(25));
        assertEquals(2, groupedUsers.get(25).size());
        assertEquals("Bob", groupedUsers.get(25).get(0).getName());
        assertEquals("David", groupedUsers.get(25).get(1).getName());

        // check one user for age 40
        assertTrue(groupedUsers.containsKey(40));
        assertEquals(1, groupedUsers.get(40).size());
        assertEquals("Eve", groupedUsers.get(40).get(0).getName());
    }

    @Test
    public void testGroupUsersEmptyList() {
        // Check if List is empty
        List<User> emptyList = new ArrayList<>();
        Map<Integer, List<User>> groupedUsers = User.groupUsers(emptyList);
        assertTrue(groupedUsers.isEmpty());
    }

    @Test
    public void testGroupUsersSingleUser() {
        // Check with one user
        List<User> singleUserList = new ArrayList<>();
        singleUserList.add(new User("Alice", 30, "Engineer", "123 Main St"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(singleUserList);
        assertEquals(1, groupedUsers.size());
        assertTrue(groupedUsers.containsKey(30));
        assertEquals(1, groupedUsers.get(30).size());
        assertEquals("Alice", groupedUsers.get(30).get(0).getName());
    }
}