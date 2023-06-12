package faang.school.godbless;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class UserTest {
    @Test
    public void testAddUsersToMap() {
        List<User> users = getUsersForMap();

        Map<Integer, List<User>> usersMap = User.groupUsers(users);

        Assertions.assertEquals(users.get(0), usersMap.get(users.get(0).getAge()).get(0));
        Assertions.assertEquals(users.get(1), usersMap.get(users.get(1).getAge()).get(1));
        Assertions.assertEquals(users.get(2), usersMap.get(users.get(2).getAge()).get(0));
    }

    @Test
    public void testCreatingIncorrectUsers() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("Andrey", 17, "Google", "London"));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("Denis", 18, "PCBK", "New York"));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("Andrey", 22, "Amazon", "Perm"));
    }

    private List<User> getUsersForMap() {
        return List.of(
                new User("Andrey", 22, "Google", "London"),
                new User("Denis", 22, "Uber", "New York"),
                new User("Vlad", 21, "Amazon", "Amsterdam")
        );
    }
}
