package faang.school.godbless;

import faang.school.godbless.task1.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserTest {
    @Test
    public void testAddUsersToMap() {
        List<User> users = getUsers();
        Map<Integer, List<User>> usersMap = User.groupUsers(getUsers());
        Assertions.assertEquals(users.get(0), usersMap.get(users.get(0).getAge()).get(0));
        Assertions.assertEquals(users.get(1), usersMap.get(users.get(1).getAge()).get(1));
        Assertions.assertEquals(users.get(2), usersMap.get(users.get(2).getAge()).get(0));
    }

    public static List<User> getUsers() {
        return new ArrayList<>(List.of(
                new User("Andrey", 22, "PSTU", "Perm"),
                new User("Denis", 22, "PCBK", "Perm"),
                new User("Vlad", 21, "HSE", "Perm")
        ));
    }
}
