package faang.school.godbless.task.user.grouping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    private List<User> users;
    private Map<Integer, List<User>> actual;
    private Map<Integer, List<User>> expected;

    User user1 = new User("Bob", 24, "McDonald's", "Brown.st");
    User user2 = new User("Patrik", 19, "LeroyMerlin", "Harlem");
    User user3 = new User("Amanda", 27, "Uber", "Brown.st");
    User user4 = new User("Lucy", 24, "McDonald's", "Brown.st");
    User user5 = new User("Mike", 27, "Amazon", "Harlem");
    User user6 = new User("John", 24, "McDonald's", "Harlem");
    User user7 = new User("Sam", 19, "McDonald's", "Brown.st");
    User user8 = new User("Berg", 27, "Uber", "Brown.st");
    User user9 = new User("Harr", 19, "LeroyMerlin", "NorthSide");
    User user10 = new User("Katy", 31, "LeroyMerlin", "NorthSide");
    User user11 = new User("Mia", 24, "Google", "SiliconeWalli");

    @BeforeEach
    void setUp() {
        users = List.of(
                user1,
                user2,
                user3,
                user4,
                user5,
                user6,
                user7,
                user8,
                user9,
                user10,
                user11
        );
    }

    @Test
    void testGroupUsers() {
        expected = new HashMap<>(Map.of(
                19, List.of(user2, user7, user9),
                24, List.of(user1, user4, user6, user11),
                27, List.of(user3, user5, user8),
                31, List.of(user10)
        ));
        actual = user1.groupUsers(users);

        assertEquals(expected, actual);
    }

    @Test
    void testGroupUsersNullUsers(){
        expected = null;
        actual = user1.groupUsers(null);

        assertEquals(expected, actual);
    }

    @Test
    void testGroupUsersEmptyUsers(){
        expected = new HashMap<>();
        actual = user1.groupUsers(new ArrayList<>());

        assertEquals(expected, actual);
    }
}
