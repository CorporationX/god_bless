package faang.school.godbless.task.user.grouping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {
    private List<User> users;
    private Map<Integer, List<User>> actual;
    private Map<Integer, List<User>> expected;

    User user1 = new User("Bob", 24, "Google", "New York");
    User user2 = new User("Patrik", 19, "Google", "Amsterdam");
    User user3 = new User("Amanda", 27, "Uber", "London");
    User user4 = new User("Lucy", 24, "Uber", "Amsterdam");
    User user5 = new User("Mike", 27, "Google", "London");
    User user6 = new User("John", 24, "Amazon", "Amsterdam");
    User user7 = new User("Sam", 19, "Amazon", "New York");
    User user8 = new User("Berg", 27, "Uber", "New York");
    User user9 = new User("Harr", 19, "Google", "London");
    User user10 = new User("Katy", 31, "Uber", "Amsterdam");
    User user11 = new User("Mia", 24, "Google", "London");

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
    void testConstructorAllValueNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new User(null, 0, null, null));
    }

    @Test
    void testConstructorAllValueEmpty() {
        assertThrows(IllegalArgumentException.class, () ->
                new User("", 0, "", ""));
    }

    @Test
    void testConstructorNameNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new User(null, 19, "Amazon", "Amsterdam"));
    }

    @Test
    void testConstructorNameEmpty() {
        assertThrows(IllegalArgumentException.class, () ->
                new User(" ", 19, "Amazon", "Amsterdam"));
    }

    @Test
    void testConstructorName() {
        assertThrows(IllegalArgumentException.class, () ->
                new User("", 19, "Amazon", "Amsterdam"));
    }

    @Test
    void testConstructorAgeZero() {
        assertThrows(IllegalArgumentException.class, () ->
                new User("Barry", 0, "Amazon", "Amsterdam"));
    }

    @Test
    void testConstructorPlaceOfJobNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new User("Barry", 19, null, "Amsterdam"));
    }

    @Test
    void testConstructorPlaceOfJobEmpty() {
        assertThrows(IllegalArgumentException.class, () ->
                new User("Barry", 19, "", "Amsterdam"));
    }

    @Test
    void testConstructorAddressNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new User("Barry", 19, "Amazon", null));
    }

    @Test
    void testConstructorAddressEmpty() {
        assertThrows(IllegalArgumentException.class, () ->
                new User("Barry", 19, "Amazon", ""));
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
