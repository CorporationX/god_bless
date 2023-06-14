package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class UserTest {
    @Test
    public void shouldReturnSortedMapByAge() {
        List<User> usersGroup = getUsers();
        Map<Integer, List<User>> receivedSortUsers = User.groupUsers(usersGroup);

        Assertions.assertEquals(usersGroup.get(0), receivedSortUsers.get(23).get(0));
        Assertions.assertEquals(usersGroup.get(1), receivedSortUsers.get(23).get(1));
        Assertions.assertEquals(usersGroup.get(2), receivedSortUsers.get(19).get(0));
        Assertions.assertEquals(usersGroup.get(3), receivedSortUsers.get(19).get(1));
        Assertions.assertEquals(usersGroup.get(4), receivedSortUsers.get(25).get(0));
        Assertions.assertEquals(usersGroup.get(5), receivedSortUsers.get(29).get(0));
    }

    @Test
    public void shouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new User("Sasha", 23, "Dark Project", "Berlin"));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new User("Mark", 19, "Amazon", "Chili"));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new User("Arman", 16, "Google", "New York"));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new User(null, 23, "Google", "Moscow"));
    }

    @Test
    public void shouldNotThrowException() {
        Assertions.assertDoesNotThrow(() ->
                new User("Sasha", 23, "Google", "New York"));
        Assertions.assertDoesNotThrow(() ->
                new User("Mark", 19, "Amazon", "Amsterdam"));
        Assertions.assertDoesNotThrow(() ->
                new User("Arman", 19, "Google", "New York"));
        Assertions.assertDoesNotThrow(() ->
                new User("Oleg", 23, "Google", "London"));
    }

    private static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Arman", 23, "Google", "Amsterdam"));
        users.add(new User("Oleg", 23, "Google", "New York"));
        users.add(new User("Gold", 19, "Amazon", "Amsterdam"));
        users.add(new User("Mark", 19, "Google", "Amsterdam"));
        users.add(new User("Sasha", 25, "Uber", "New York"));
        users.add(new User("Olga", 29, "Google", "Amsterdam"));

        return users;
    }
}
