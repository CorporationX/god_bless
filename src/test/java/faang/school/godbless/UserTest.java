package faang.school.godbless;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserTest {

    private List<User> users;

    @BeforeEach
    void setUp(){
        users = getUsers();
    }

    @Test
    void testGroupUsers(){
        Map<Integer, List<User>> resultGroupUsers = User.groupUsers(users);

        Assertions.assertEquals(users.get(0), resultGroupUsers.get(26).get(0));
        Assertions.assertEquals(users.get(1), resultGroupUsers.get(28).get(0));
        Assertions.assertEquals(users.get(2), resultGroupUsers.get(28).get(1));
        Assertions.assertEquals(users.get(3), resultGroupUsers.get(26).get(1));
        Assertions.assertEquals(users.get(4), resultGroupUsers.get(24).get(0));
        Assertions.assertEquals(users.get(5), resultGroupUsers.get(24).get(1));
    }
    private static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Alex", 26, "Google", "Los-Angeles"));
        users.add(new User("Andrey", 28, "FAANG-School", "Amsterdam"));
        users.add(new User("Misha", 28, "Corporation-X", "Berlin"));
        users.add(new User("Lui", 26, "MTC", "Saratov"));
        users.add(new User("Olga", 24, "Yandex", "Moscow"));
        users.add(new User("Kristina", 24, "Uber", "Keln"));
        return users;
    }
}
