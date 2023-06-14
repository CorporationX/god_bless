package faang.school.godbless.collecting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectingUsersTest {

    private User userOne;
    private User userTwo;
    private User userThree;
    private User userFour;
    private Set<String> activities;
    private List<User> users;

    @BeforeEach
    public void setUp() {
        activities = new HashSet<>(Arrays.asList("Box", "MMA", "Football"));
        userOne = new User(1, "Kirill", 23, new HashSet<>(Arrays.asList("Football", "Box", "MMA")));
        userTwo = new User(2, "Diana", 22, new HashSet<>(Arrays.asList("Box", "Baseball", "Basketball")));
        userThree = new User(3, "Liza", 18, new HashSet<>(Arrays.asList("Athletic")));
        userFour = new User(3, "Vladimir", 24, new HashSet<>(Arrays.asList("Gym", "Athletic")));
        users = new ArrayList<>(Arrays.asList(userOne, userTwo, userThree, userFour));
    }

    @Test
    public void testCollectingUsers() {
        Map<User, String> userMap = User.findHobbyLovers(users, activities);
        assertEquals(2, userMap.size());
        assertEquals("Box", userMap.get(userTwo));
    }
}
