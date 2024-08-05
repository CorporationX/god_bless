package faang.school.godbless.groupingUsersByAge;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private User user1;
    private User user2;
    private User user3;
    private User user4;

    @BeforeEach
    public void setUp(){
        user1 = new User("Daddy",18,"kiowr","Amazon");
        user2 = new User("Baddy",12,"kiowr","Amazon");
        user3 = new User("Caddy",12,"kiowr","Amazon");
        user4 = new User("Raddy",14,"kiowr","Amazon");

    }

    @Test
    public void groupingUsersByAge_test(){
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        assertEquals(3, groupedUsers.size());
        assertEquals(1, groupedUsers.get(18).size());
        assertEquals(2, groupedUsers.get(12).size());
        assertEquals(1, groupedUsers.get(14).size());

        assertEquals(user1, groupedUsers.get(18).get(0));
        assertEquals(user2, groupedUsers.get(12).get(0));
        assertEquals(user3, groupedUsers.get(12).get(1));
        assertEquals(user4, groupedUsers.get(14).get(0));
    }
}
