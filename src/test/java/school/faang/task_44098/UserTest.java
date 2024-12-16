package school.faang.task_44098;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {

    @Test
    @DisplayName("findHobbyLovers: should find users with matching hobbies")
    void findHobbyLovers_shouldFindUsersWithMatchingHobbies() {
        // Arrange
        List<User> users = List.of(
                new User("Alice", 25, Set.of("Reading", "Hiking")),
                new User("Bob", 30, Set.of("Cooking", "Cycling")),
                new User("Charlie", 22, Set.of("Reading", "Painting")),
                new User("David", 28, Set.of("Fishing", "Cooking"))
        );
        Set<String> testHobbies = Set.of("Reading", "Hiking", "Cycling");

        // Act
        Map<User, String> result = User.findHobbyLovers(users, testHobbies);

        // Assert
        assertAll("Check result size",
                () -> assertEquals(3, result.size(), "There should be 3 users with matching hobbies")
        );

        assertAll("Check users are present",
                () -> assertTrue(result.containsKey(users.get(0)), "Alice should be included"),
                () -> assertTrue(result.containsKey(users.get(1)), "Bob should be included"),
                () -> assertTrue(result.containsKey(users.get(2)), "Charlie should be included")
        );

        assertAll("Check hobby matching",
                () -> assertEquals("Cycling", result.get(users.get(1)), "Bob should love Cycling"),
                () -> assertEquals("Reading", result.get(users.get(2)), "Charlie should love Reading")
        );
    }

    @Test
    @DisplayName("findHobbyLovers: should return empty map when no hobbies match")
    void findHobbyLovers_shouldReturnEmptyWhenNoHobbiesMatch() {
        // Arrange
        List<User> users = List.of(
                new User("Alice", 25, Set.of("Reading", "Hiking")),
                new User("Charlie", 22, Set.of("Reading", "Painting"))
        );
        Set<String> testHobbies = Set.of("Cycling", "Fishing");

        // Act
        Map<User, String> result = User.findHobbyLovers(users, testHobbies);

        // Assert
        assertAll("Empty result when no hobbies match",
                () -> assertTrue(result.isEmpty(), "Result should be empty if no hobbies match")
        );
    }

    @Test
    @DisplayName("findHobbyLovers: should find only users with specific hobby")
    void findHobbyLovers_shouldFindOnlyUsersWithSpecificHobby() {
        // Arrange
        List<User> users = List.of(
                new User("Alice", 25, Set.of("Reading", "Hiking")),
                new User("Bob", 30, Set.of("Cooking", "Cycling")),
                new User("Charlie", 22, Set.of("Reading", "Painting")),
                new User("David", 28, Set.of("Fishing", "Cooking"))
        );
        Set<String> testHobbies = Set.of("Cooking");

        // Act
        Map<User, String> result = User.findHobbyLovers(users, testHobbies);

        // Assert
        assertAll("Check result size",
                () -> assertEquals(2, result.size(), "There should be 2 users who like Cooking")
        );

        assertAll("Check users with Cooking hobby",
                () -> assertTrue(result.containsKey(users.get(1)), "Bob should be included"),
                () -> assertTrue(result.containsKey(users.get(3)), "David should be included")
        );

        assertAll("Check hobby matching for Cooking",
                () -> assertEquals("Cooking", result.get(users.get(1)), "Bob should love Cooking"),
                () -> assertEquals("Cooking", result.get(users.get(3)), "David should love Cooking")
        );
    }
}
