package faang.school.godbless;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserTest {

    private List<User> users;

    @Test
    void testGroupUsers(){
        List<User> users = getUsers();
        Map<Integer, List<User>> resultGroupUsers = User.groupUsers(users);

        Assertions.assertEquals(users.get(0), resultGroupUsers.get(26).get(0));
        Assertions.assertEquals(users.get(1), resultGroupUsers.get(28).get(0));
        Assertions.assertEquals(users.get(2), resultGroupUsers.get(28).get(1));
    }
    private static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Alex", 26, "Google", "London"));
        users.add(new User("Andrey", 28, "Amazon", "Amsterdam"));
        users.add(new User("Misha", 28, "Amazon", "NewYork"));
        return users;
    }
}
