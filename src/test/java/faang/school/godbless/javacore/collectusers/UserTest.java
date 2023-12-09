package faang.school.godbless.javacore.collectusers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private static final List<User> TEST_USERS = Arrays.asList(
            new User(1, "Alice", 25, new HashSet<>(Arrays.asList("Reading", "Cycling", "Chess"))),
            new User(2, "Bob", 30, new HashSet<>(Arrays.asList("Hiking", "Chess", "Running"))),
            new User(3, "Charlie", 35, new HashSet<>(Arrays.asList("Swimming", "Running", "Photography"))),
            new User(4, "David", 40, new HashSet<>(Arrays.asList("Cooking", "Photography", "Painting"))),
            new User(5, "Eva", 22, new HashSet<>(Arrays.asList("Gaming", "Painting", "Hiking"))),
            new User(6, "Frank", 28, new HashSet<>(Arrays.asList("Reading", "Hiking", "Swimming"))),
            new User(7, "Grace", 31, new HashSet<>(Arrays.asList("Chess", "Swimming", "Cooking"))),
            new User(8, "Hannah", 26, new HashSet<>(Arrays.asList("Running", "Cooking", "Gaming"))),
            new User(9, "Ivan", 33, new HashSet<>(Arrays.asList("Photography", "Gaming", "Reading"))),
            new User(10, "Julia", 29, new HashSet<>(Arrays.asList("Painting", "Reading", "Cycling")))
    );

    @Test
    void findHobbyLovers_shouldReturnMapUsersWithMatchingActivities_whenGetCorrectUsersAndActivities() {
        Map<User, String> expectedHobbyLovers = Map.of(
                TEST_USERS.get(2), "Swimming",
                TEST_USERS.get(3), "Cooking",
                TEST_USERS.get(4), "Gaming",
                TEST_USERS.get(5), "Swimming",
                TEST_USERS.get(6), "Swimming",
                TEST_USERS.get(7), "Gaming",
                TEST_USERS.get(8), "Gaming"
        );
        Set<String> activities = Set.of("Gaming", "Swimming", "Cooking");

        Map<User, String> hobbyLovers = User.findHobbyLovers(TEST_USERS, activities);

        assertEquals(expectedHobbyLovers.size(), hobbyLovers.size());
        assertEquals(expectedHobbyLovers, hobbyLovers);
    }

    @Test
    void findHobbyLovers_shouldReturnEmptyMap_whenGetActivitiesWithoutMatchingWithUsers() {
        Set<String> activities = Set.of("Fishing", "Skying", "Climbing");
        int emptySize = 0;

        Map<User, String> hobbyLovers = User.findHobbyLovers(TEST_USERS, activities);

        assertEquals(emptySize, hobbyLovers.size());
    }

    @Test
    void findHobbyLovers_shouldReturnEmptyMap_whenGetEmptyUsersList() {
        List<User> emptyUserList = new ArrayList<>();
        Set<String> activities = Set.of("Fishing", "Skying", "Climbing");
        int emptySize = 0;

        Map<User, String> hobbyLovers = User.findHobbyLovers(emptyUserList, activities);

        assertEquals(emptySize, hobbyLovers.size());
    }

    @Test
    void findHobbyLovers_shouldReturnEmptyMap_whenGetEmptyActivitiesSet() {
        int emptySize = 0;

        Map<User, String> hobbyLovers = User.findHobbyLovers(TEST_USERS, new HashSet<>());

        assertEquals(emptySize, hobbyLovers.size());
    }

}