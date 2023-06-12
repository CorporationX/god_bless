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

    private static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Arman", 23, "Google", "1212"));
        users.add(new User("Oleg", 23, "Google", "1212"));
        users.add(new User("Gold", 19, "Amazon", "1212"));
        users.add(new User("Mark", 19, "Google", "1212"));
        users.add(new User("Sasha", 25, "Uber", "1212"));
        users.add(new User("Olga", 29, "Google", "1212"));

        return users;
    }
}
