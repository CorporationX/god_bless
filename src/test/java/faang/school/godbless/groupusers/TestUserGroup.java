package faang.school.godbless.groupusers;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUserGroup {

    @Test
    @DisplayName("Grouping users by Age")
    public void testGroupUsers() {
        User user;
        List<User> usersList = new ArrayList<>();

        user = new User("Vika", 19, "Google", "London");
        usersList.add(user);

        user = new User("Dima", 19, "Facebook", "Russia");
        usersList.add(user);

        user = new User("Fedya", 20, "Instagram", "USA");
        usersList.add(user);

        user = new User("Frosya", 20, "VK", "USA");
        usersList.add(user);

        user = new User("Marusya", 20, "Yandex", "Russia");
        usersList.add(user);

        Map<Integer, List<User>> usersMap;
        usersMap = User.groupUsers(usersList);

        assertAll(
                () -> assertEquals(2, usersMap.size()),
                () -> assertEquals(2, usersMap.get(19).size()),
                () -> assertEquals(3, usersMap.get(20).size())
        );
    }
}
