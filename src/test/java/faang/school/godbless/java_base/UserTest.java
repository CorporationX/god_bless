package faang.school.godbless.java_base;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void testGroupUsers() {

        List<User> users = new ArrayList<>();
        users.add(new User("Petr", 30, "Google", "Moscow st 84"));
        users.add(new User("Anna", 25, "Amazon", "Piter st 15"));
        users.add(new User("Elena", 30, "Microsoft", "Penza st 45"));
        users.add(new User("Vadim", 25, "Apple", "Ekb st 22"));
        users.add(new User("Nikita", 40, "Facebook", "Tomsk st 59"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        assertEquals(3, groupedUsers.size());

        assertEquals(2, groupedUsers.get(30).size());
        assertEquals(2, groupedUsers.get(25).size());
        assertEquals(1, groupedUsers.get(40).size());

        assertEquals("Petr", groupedUsers.get(30).get(0).getName());
        assertEquals("Elena", groupedUsers.get(30).get(1).getName());
        assertEquals("Anna", groupedUsers.get(25).get(0).getName());
        assertEquals("Vadim", groupedUsers.get(25).get(1).getName());
        assertEquals("Nikita", groupedUsers.get(40).get(0).getName());
    }

}
