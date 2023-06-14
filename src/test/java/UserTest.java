import faang.school.godbless.bc223.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private User user;
    private final static String FIRST_NAME = "name";
    private final static int AGE = 20;
    private final static String JOB = "Google";
    private final static String ADDRESS = "London";


    @BeforeEach
    public void setUp() {
        user = new User(FIRST_NAME, AGE, JOB, ADDRESS);
    }

    @Test
    public void testUserConstructor() {
        assertEquals(FIRST_NAME, user.getName());
        assertEquals(AGE, user.getAge());
        assertEquals(JOB, user.getWorkPlace());
        assertEquals(ADDRESS, user.getAddress());
    }

    @Test
    public void testGroupUsers() {
        User user1 = new User("Вася", 25, "Google", "New York");
        User user2 = new User("коля", 25, "Uber", "London");
        User user3 = new User("галина", 30, "Google", "London");
        User user4 = new User("Person", 30, "Amazon", "Amsterdam");
        User user5 = new User("Джордж", 24, "Amazon", "New York");

        List<User> users = List.of(user1, user2, user3, user4, user5);

        Map<Integer, List<User>> expectedGroups = new HashMap<>();

        expectedGroups.put(24, List.of(user5));
        expectedGroups.put(25, List.of(user1, user2));
        expectedGroups.put(30, List.of(user3, user4));

        Map<Integer, List<User>> actualUsersAgeToUsersResult = User.groupUsers(users);

        assertEquals(expectedGroups, actualUsersAgeToUsersResult);
    }

    @Test
    public void shouldThrownException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("", 25, "Uber", "London"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("галина", 30, "Google", "Chita"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("Person", 8, "Amazon", "Amsterdam"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("Джордж", 24, "Apple", "New York"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("    ", 24, "Apple", "New York"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User(null, 24, "Apple", "New York"));
    }
}
