package faang.school.godbless.collecting_users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private Set<String> activities;

    @BeforeEach
    void setUp() {
        activities = new HashSet<>(Arrays.asList("Football", "Volleyball", "Basketball"));
    }

    @Test
    public void testCollectingUsers() {
        User userOne = new User(1, "Ivan", 19, new HashSet<>(Arrays.asList("Football", "Yoga")));
        User userTwo = new User(2, "Petr", 28, new HashSet<>(Arrays.asList("Gym", "Basketball")));
        User userThree = new User(3, "Zhenya", 31, new HashSet<>(Arrays.asList("Running", "Volleyball")));
        List<User> users = new ArrayList<>(Arrays.asList(userOne, userTwo, userThree));

        Map<User, String> userMap = User.findHobbyLovers(users, activities);

        assertEquals(3, userMap.size());
        assertEquals("Volleyball", userMap.get(userThree));
    }
}