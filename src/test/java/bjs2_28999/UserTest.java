package bjs2_28999;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserTest {
    User user1;
    User user2;
    User user3;

    @BeforeEach
    void setUp() {
        user1 = new User(0, "John", 22, Set.of("Football", "Java", "Video games"));
        user2 = new User(1, "Jack", 19, Set.of("Basketball", "Java"));
        user3 = new User(2, "Jess", 24, Set.of());
    }

    @Test
    @DisplayName("Test empty users list")
    void testEmptyUsers() {
        // arrange
        List<User> users = new ArrayList<>();
        Set<String> activities = Set.of("Java", "Football");
        Map<User, String> expectedHobbyLovers = new HashMap<>();

        // act
        Map<User, String> hobbyLovers = User.findHobbyLovers(users, activities);

        // assert
        assertEquals(expectedHobbyLovers, hobbyLovers);
    }

    @Test
    @DisplayName("Test empty activities set")
    void testEmptyActivities() {
        // arrange
        List<User> users = List.of(user1, user2, user3);
        Set<String> activities = new HashSet<>();
        Map<User, String> expectedHobbyLovers = new HashMap<>();

        // act
        Map<User, String> hobbyLovers = User.findHobbyLovers(users, activities);

        // assert
        assertEquals(expectedHobbyLovers, hobbyLovers);
    }

    @Test
    @DisplayName("Test single user")
    void testSingleUser() {
        // arrange
        List<User> users = List.of(user1);
        Set<String> activities = Set.of("Java", "Hockey", "Languages");
        Map<User, String> expectedHobbyLovers = Map.of(user1, "Java");

        // act
        Map<User, String> hobbyLovers = User.findHobbyLovers(users, activities);

        // assert
        assertEquals(expectedHobbyLovers, hobbyLovers);
    }

    @Test
    @DisplayName("Test multiple users")
    void testMultipleUsers() {
        // arrange
        List<User> users = List.of(user1, user2, user3);
        Set<String> activities = Set.of("Java", "Hockey", "Languages", "Filming");
        Map<User, String> expectedHobbyLovers = Map.of(
                user1, "Java",
                user2, "Java"
        );

        // act
        Map<User, String> hobbyLovers = User.findHobbyLovers(users, activities);
        System.out.println(hobbyLovers);
        // assert
        assertEquals(expectedHobbyLovers, hobbyLovers);
    }
}
