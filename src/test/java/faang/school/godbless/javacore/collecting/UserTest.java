package faang.school.godbless.javacore.collecting;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {

    private static final String GARDENING = "Gardening";
    private static final String READING = "Reading";
    private static final String GAMING = "Gaming";
    private static final String PAINTING = "Painting";
    private static final String COOKING = "Cooking";

    @Test
    void testFindHobbyLovers() {
        User user1 = new User(1, "Alice", 25, Set.of(READING, GARDENING));
        User user2 = new User(2, "Bob", 30, Set.of(GAMING, PAINTING));
        User user3 = new User(3, "Charlie", 28, Set.of(READING, COOKING));
        User user4 = new User(4, "David", 35, Set.of(GARDENING, PAINTING));
        User user5 = new User(5, "Eve", 27, Set.of(GAMING, PAINTING, COOKING));

        List<User> users = List.of(user1, user2, user3, user4, user5);
        Set<String> activities = Set.of(READING, GARDENING);

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, activities);

        assertEquals(3, hobbyLovers.size());
        assertTrue(activities.contains(hobbyLovers.get(user1)));
        assertTrue(activities.contains(hobbyLovers.get(user3)));
        assertTrue(activities.contains(hobbyLovers.get(user4)));
    }

    @Test
    void testFindHobbyLoversNoMatch() {
        User user1 = new User(1, "Alice", 25, Set.of(GARDENING));
        User user2 = new User(2, "Bob", 30, Set.of(GAMING, PAINTING));
        User user3 = new User(3, "Charlie", 28, Set.of(COOKING));
        User user4 = new User(4, "David", 35, Set.of(GARDENING, PAINTING));
        User user5 = new User(5, "Eve", 27, Set.of(GAMING, PAINTING, COOKING));

        List<User> users = List.of(user1, user2, user3, user4, user5);
        Set<String> activities = Set.of(READING);

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, activities);

        assertEquals(0, hobbyLovers.size());
    }

    @Test
    void testFindHobbyLoversNoUsers() {
        List<User> users = Collections.emptyList();
        Set<String> activities = Set.of(READING);

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, activities);

        assertEquals(0, hobbyLovers.size());
    }

    @Test
    void testFindHobbyLoversNoActivities() {
        User user1 = new User(1, "Alice", 25, Set.of(GARDENING));
        User user2 = new User(2, "Bob", 30, Set.of(GAMING, PAINTING));
        User user3 = new User(3, "Charlie", 28, Set.of(COOKING));
        User user4 = new User(4, "David", 35, Set.of(GARDENING, PAINTING));
        User user5 = new User(5, "Eve", 27, Set.of(GAMING, PAINTING, COOKING));

        List<User> users = List.of(user1, user2, user3, user4, user5);
        Set<String> activities = Set.of();

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, activities);

        assertEquals(0, hobbyLovers.size());
    }
}