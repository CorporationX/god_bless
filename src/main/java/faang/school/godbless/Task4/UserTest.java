package faang.school.godbless.Task4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {

    private List<User> users;
    private Set<String> hobbies;

    @BeforeEach
    void setUp() {
        User user1 = new User(1, "Alice", 30, new HashSet<>(Arrays.asList("Reading", "Swimming")));
        User user2 = new User(2, "Bob", 25, new HashSet<>(Arrays.asList("Cooking", "Reading")));
        User user3 = new User(3, "Charlie", 35, new HashSet<>(Arrays.asList("Cycling", "Swimming")));

        users = Arrays.asList(user1, user2, user3);
        hobbies = new HashSet<>(Arrays.asList("Reading", "Swimming"));
    }

    @Test
    public void testFindHobbyLovers() {
        Map<User, String> hobbyLovers = User.findHobbyLovers(users, hobbies);

        assertEquals(3, hobbyLovers.size());
        assertTrue(hobbyLovers.containsKey(users.get(0)));
        assertTrue(hobbyLovers.containsKey(users.get(1)));
        assertTrue(hobbyLovers.containsKey(users.get(2)));
        assertEquals("Reading", hobbyLovers.get(users.get(0)));
        assertEquals("Reading", hobbyLovers.get(users.get(1)));
        assertEquals("Swimming", hobbyLovers.get(users.get(2)));
    }

}