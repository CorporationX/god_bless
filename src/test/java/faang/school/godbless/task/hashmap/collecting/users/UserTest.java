package faang.school.godbless.task.hashmap.collecting.users;


import faang.school.godbless.task.hashmap.collecting.users.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    private User user;
    private List<User> users;
    private Map<User, String> actual;
    private Map<User, String> expected;
    private Set<String> activitiesForMethod;

    User user1 = new User(1, "Mike", 34, new HashSet<>(Set.of("Some activities", "Some activities1", "Some activities3", "Some activities2")));
    User user2 = new User(2, "Bob", 23, new HashSet<>(Set.of("Some activities", "Some activities1", "Gym")));
    User user3 = new User(3, "Jack", 41, new HashSet<>(Set.of("Some activities", "Some activities1")));
    User user4 = new User(4, "Sam", 18, new HashSet<>(Set.of("Some activities", "Playing", "Some activities1")));
    User user5 = new User(5, "Amanda", 24, new HashSet<>(Set.of("Some activities4", "Some activities", "Some activities1")));
    User user6 = new User(6, "Mary", 19, new HashSet<>(Set.of("Some activities", "Some activities1", "Some activities2", "Some activities3")));
    User user7 = new User(7, "Abby", 34, new HashSet<>(Set.of("Some activities", "Some activities1", "Some activities3", "Some activities2")));
    User user8 = new User(8, "Tom", 23, new HashSet<>(Set.of("Some activities", "Some activities1", "Gym")));
    User user9 = new User(9, "Petter", 41, new HashSet<>(Set.of("Some activities", "Some activities1")));
    User user10 = new User(10, "Sam", 18, new HashSet<>(Set.of("Some activities", "Cooking", "Some activities1")));
    User user11 = new User(11, "Lucy", 24, new HashSet<>(Set.of("Some activities3", "Some activities", "Some activities1")));
    User user12 = new User(12, "Katy", 19, new HashSet<>(Set.of("Some activities", "Some activities1", "Some activities2", "Sleeping")));

    @BeforeEach
    public void setUp() {
        activitiesForMethod = new HashSet<>(Set.of("Gym", "Cooking", "Playing", "Sleeping"));
        user = new User(0, "Name", 0, activitiesForMethod);
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
                user11,
                user12
        );
    }

    @Test
    public void testFindHobbyLovers() {
        expected = Map.of(
                user12, "Sleeping",
                user10, "Cooking",
                user8, "Gym",
                user4, "Playing",
                user2, "Gym"
        );
        actual = user.findHobbyLovers(users, activitiesForMethod);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindHobbyLovers_nullUsers() {
        expected = null;
        actual = user.findHobbyLovers(null, activitiesForMethod);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindHobbyLovers_nullActivities() {
        expected = null;
        actual = user.findHobbyLovers(users, null);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindHobbyLovers_emptyActivities() {
        expected = new HashMap<>();
        actual = user.findHobbyLovers(users, new HashSet<>());
        assertEquals(expected, actual);
    }

    @Test
    public void testFindHobbyLovers_emptyUsers() {
        expected = new HashMap<>();
        actual = user.findHobbyLovers(new ArrayList<User>(), activitiesForMethod);
        assertEquals(expected, actual);
    }
}
