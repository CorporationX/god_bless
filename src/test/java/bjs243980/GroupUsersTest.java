package bjs243980;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import school.faang.bjs243980.Main;
import school.faang.bjs243980.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GroupUsersTest {

    @Test
    public void success() {
        List<User> users = new ArrayList<>();
        users.addAll(Main.createUsers(3, 30));
        users.addAll(Main.createUsers(4, 20));
        users.addAll(Main.createUsers(2, 30));
        users.addAll(Main.createUsers(3, 31));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        Assertions.assertEquals(3, groupedUsers.size());
        Assertions.assertEquals(5, groupedUsers.get(30).size());
    }
}
