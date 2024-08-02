package faang.school.godbless.collectingUsers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    private Set<String> activitiesForMethod;
    private User user;
    private List<User> users;
    private Map<User, String> expected;
    private Map<User, String> actual;

    @BeforeEach
    public void setUp() {
        activitiesForMethod = new HashSet<>(Set.of("Gym", "Cooking", "Playing", "Sleeping"));
        user = new User(0, "Name", 0, activitiesForMethod);
        users = List.of(
                new User(1, "Mike", 34, new HashSet<>(Set.of("Some activities", "Some activities1", "Some activities3", "Some activities2"))),
                new User(2, "Bob", 23, new HashSet<>(Set.of("Some activities", "Some activities1", "Gym"))),
                new User(3, "Jack", 41, new HashSet<>(Set.of("Some activities", "Some activities1"))),
                new User(4, "Sam", 18, new HashSet<>(Set.of("Some activities", "Playing", "Some activities1"))),
                new User(5, "Amanda", 24, new HashSet<>(Set.of("Some activities4", "Some activities", "Some activities1"))),
                new User(6, "Mary", 19, new HashSet<>(Set.of("Some activities", "Some activities1", "Some activities2", "Some activities3"))),
                new User(7, "Abby", 34, new HashSet<>(Set.of("Some activities", "Some activities1", "Some activities3", "Some activities2"))),
                new User(8, "Tom", 23, new HashSet<>(Set.of("Some activities", "Some activities1", "Gym"))),
                new User(9, "Petter", 41, new HashSet<>(Set.of("Some activities", "Some activities1"))),
                new User(10, "Sam", 18, new HashSet<>(Set.of("Some activities", "Cooking", "Some activities1"))),
                new User(11, "Lucy", 24, new HashSet<>(Set.of("Some activities3", "Some activities", "Some activities1"))),
                new User(12, "Katy", 19, new HashSet<>(Set.of("Some activities", "Some activities1", "Some activities2", "Sleeping")))
        );
    }

    @Test
    public void testFindHobbyLovers() {
        expected = Map.of(
                new User(12, "Katy", 19, new HashSet<>(Set.of("Some activities", "Some activities1", "Some activities2", "Sleeping"))), "Sleeping",
                new User(10, "Sam", 18, new HashSet<>(Set.of("Some activities", "Cooking", "Some activities1"))), "Cooking",
                new User(8, "Tom", 23, new HashSet<>(Set.of("Some activities", "Some activities1", "Gym"))), "Gym",
                new User(4, "Sam", 18, new HashSet<>(Set.of("Some activities", "Playing", "Some activities1"))), "Playing",
                new User(2, "Bob", 23, new HashSet<>(Set.of("Some activities", "Some activities1", "Gym"))), "Gym"
        );

        actual = user.findHobbyLovers(users, activitiesForMethod);

        assertEquals(expected, actual);
    }
}
