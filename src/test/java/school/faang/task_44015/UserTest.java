package school.faang.task_44015;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {
    private List<User> users;
    private Map<Integer, List<User>> usersByAge;

    @BeforeEach
    void setUp() {
        users = User.createUsers();
        usersByAge = User.groupUsersByAge(users);
    }

    @Test
    @DisplayName("createUsers: should return a non-null")
    void createUsers_shouldReturnNonNull() {
        assertNotNull(users, "Users list should not be null");
    }

    @Test
    @DisplayName("createUsers: should return a non-empty list")
    void createUsers_shouldReturnNonEmptyList() {
        assertFalse(users.isEmpty(), "Users list should not be empty");
    }

    @Test
    @DisplayName("createUsers: should return a list with exactly 5 users")
    void createUsers_shouldReturnListWithExactly5Users() {
        assertEquals(5, users.size(), "Users list should have exactly 5 elements");
    }

    @Test
    @DisplayName("createUsers: should not contains unknown users")
    void createUsers_shouldNotContainUnknownUsers() {
        assertTrue(users.stream().noneMatch(user -> "Unknown".equals(user.name())),
                "Users list should not contain unknown users");
    }

    @Test
    @DisplayName("groupUsersByAge: Users list by age should not be null")
    void groupUsersByAge_shouldNotBeNull() {
        assertNotNull(usersByAge, "Users list by age should not be null");
    }

    @ParameterizedTest
    @ValueSource(ints = {40, 41, 47})
    @DisplayName("groupUsersByAge: should contains the age group")
    void groupUsersByAge_shouldContainAgeGroup(int age) {
        assertTrue(usersByAge.containsKey(age),
                "Age group " + age + " should exist");
    }

    @ParameterizedTest
    @CsvSource({
            "40, 2",
            "41, 1",
            "47, 2"
    })
    @DisplayName("groupUsersByAge: age group should have correct number of users")
    void groupUsersByAge_shouldHaveCorrectNumberOfUsers(int age, int expected) {
        assertEquals(expected, usersByAge.get(age).size(),
                "Age group " + age + " should have " + expected + " users");
    }

    @Test
    @DisplayName("groupUsersByAge: should throw exception for empty list")
    void groupUsersByAge_shouldThrowExceptionForEmptyList() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> User.groupUsersByAge(List.of())
        );

        assertEquals("Users cannot be empty!", exception.getMessage(), "Exception message should match");
    }

    @Test
    @DisplayName("printUsersByAge: should throw exception for empty map")
    void printUsersByAge_shouldThrowExceptionForEmptyMap() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> User.printUsersByAge(Map.of())
        );
    }

    @Test
    @DisplayName("printUsersByAge: should not throw exception for valid map")
    void printUsersByAge_shouldNotThrowExceptionForValidMap() {
        assertDoesNotThrow(() -> User.printUsersByAge(usersByAge));
    }
}