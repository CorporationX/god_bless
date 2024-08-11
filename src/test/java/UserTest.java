import faang.school.godbless.BJS2_18525.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {
    private List<User> users;
    private Map<Integer, List<User>> groupedUsers;

    @BeforeEach
    public void setUp() {
        users = new ArrayList<>();
    }

    @Test
    public void testGroupUsers_SingleAgeGroup() {
        users.add(new User("Maxim", 25, "Uber", "Amsterdam"));
        users.add(new User("Ivan", 25, "Google", "Paris"));
        users.add(new User("Artem", 25, "Yandex", "Moscow"));

        groupedUsers = User.groupUsers(users);

        assertNotNull(groupedUsers);
        assertEquals(1, groupedUsers.size());
        assertTrue(groupedUsers.containsKey(25));
        assertEquals(3, groupedUsers.get(25).size());
        assertTrue(groupedUsers.get(25).contains(new User("Maxim", 25, "Uber", "Amsterdam")));
        assertTrue(groupedUsers.get(25).contains(new User("Ivan", 25, "Google", "Paris")));
        assertTrue(groupedUsers.get(25).contains(new User("Artem", 25, "Yandex", "Moscow")));
    }

    @Test
    public void testGroupUsers_MultipleAgeGroups() {
        users.add(new User("Maxim", 25, "Uber", "Amsterdam"));
        users.add(new User("Ivan", 30, "Google", "Paris"));
        users.add(new User("Artem", 25, "Yandex", "Moscow"));
        users.add(new User("Anna", 30, "Microsoft", "London"));

        groupedUsers = User.groupUsers(users);

        assertNotNull(groupedUsers);
        assertEquals(2, groupedUsers.size());
        assertTrue(groupedUsers.containsKey(25));
        assertTrue(groupedUsers.containsKey(30));
        assertEquals(2, groupedUsers.get(25).size());
        assertEquals(2, groupedUsers.get(30).size());

        assertTrue(groupedUsers.get(25).contains(new User("Maxim", 25, "Uber", "Amsterdam")));
        assertTrue(groupedUsers.get(25).contains(new User("Artem", 25, "Yandex", "Moscow")));
        assertTrue(groupedUsers.get(30).contains(new User("Ivan", 30, "Google", "Paris")));
        assertTrue(groupedUsers.get(30).contains(new User("Anna", 30, "Microsoft", "London")));
    }

    @Test
    public void testGroupUsers_EmptyList() {
        groupedUsers = User.groupUsers(users);

        assertNotNull(groupedUsers);
        assertEquals(0, groupedUsers.size());
    }

    @Test
    public void testGroupUsers_DifferentAges() {
        users.add(new User("Maxim", 25, "Uber", "Amsterdam"));
        users.add(new User("Ivan", 30, "Google", "Paris"));
        users.add(new User("Artem", 35, "Yandex", "Moscow"));

        groupedUsers = User.groupUsers(users);

        assertNotNull(groupedUsers);
        assertEquals(3, groupedUsers.size());
        assertTrue(groupedUsers.containsKey(25));
        assertTrue(groupedUsers.containsKey(30));
        assertTrue(groupedUsers.containsKey(35));
        assertEquals(1, groupedUsers.get(25).size());
        assertEquals(1, groupedUsers.get(30).size());
        assertEquals(1, groupedUsers.get(35).size());

        assertTrue(groupedUsers.get(25).contains(new User("Maxim", 25, "Uber", "Amsterdam")));
        assertTrue(groupedUsers.get(30).contains(new User("Ivan", 30, "Google", "Paris")));
        assertTrue(groupedUsers.get(35).contains(new User("Artem", 35, "Yandex", "Moscow")));
    }
}