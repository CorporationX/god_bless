package shcool.faang;

import school.faang.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class UserTest {

    private static User user1;
    private static User user2;
    private static List<User> users;
    private static Set<String> activities;

    @BeforeAll
    static void setUp() {
        user1 = new User(1L, "Alex", 35, new HashSet<>(Arrays.asList("reading", "swimming")));
        user2 = new User(2L, "John", 39, new HashSet<>(Arrays.asList("cooking", "hiking")));
        users = List.of(user1, user2);
        activities = Set.of("reading", "cooking");
    }

    @Test
    void testFindHobbyLovers_WhenUsersAndActivitiesAreValid() {
        Map<User, String> result = User.findHobbyLovers(users, activities);

        assertEquals(2, result.size());
        assertEquals("reading", result.get(user1));
        assertEquals("cooking", result.get(user2));
    }

    @Test
    void testFindHobbyLovers_WhenUsersListIsEmpty() {
        List<User> emptyUsers = List.of();
        Map<User, String> result = User.findHobbyLovers(emptyUsers, activities);

        assertTrue(result.isEmpty(), "Result should be empty when user list is empty.");
    }

    @Test
    void testFindHobbyLovers_WhenActivitiesSetIsEmpty() {
        Set<String> emptyActivities = Set.of();
        Map<User, String> result = User.findHobbyLovers(users, emptyActivities);

        assertTrue(result.isEmpty(), "Result should be empty when activities set is empty.");
    }

    @Test
    void testFindHobbyLovers_WhenActivitiesSetIsNull() {
        Map<User, String> result = User.findHobbyLovers(users, null);

        assertTrue(result.isEmpty(), "Result should be empty when activities set is null.");
    }

    @Test
    void testFindHobbyLovers_WhenUserHasNoHobbies() {
        User userWithoutHobbies = new User(3L, "Charlie", 44, null);
        List<User> usersWithNoHobbies = List.of(userWithoutHobbies);
        Map<User, String> result = User.findHobbyLovers(usersWithNoHobbies, activities);

        assertTrue(result.isEmpty(), "Result should be empty when user has no hobbies.");
    }

    @Test
    void testFindHobbyLovers_WhenDuplicateUserIds() {
        User duplicateUser = new User(1L, "Alex", 35, new HashSet<>(List.of("reading")));
        List<User> usersWithDuplicates = List.of(user1, duplicateUser);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                User.findHobbyLovers(usersWithDuplicates, activities)
        );

        assertEquals("Duplicate user IDs detected: 1", exception.getMessage());
    }
}
