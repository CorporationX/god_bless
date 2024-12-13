package school.faang.task_43777;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserFactoryTest {
    private static final int EXPECTED_NUMBER_OF_USERS = 5;

    private List<User> users;

    @BeforeEach
    void setUp() {
        users = UserFactory.createUsers();
    }

    @Test
    @DisplayName("createUsers: should not return a null list")
    void createUsers_shouldNotReturnNullList() {
        assertNotNull(users, "The users list should not be null");
    }

    @Test
    @DisplayName("createUsers: should not return an empty list")
    void createUsers_shouldNotReturnAnEmptyList() {
        assertFalse(users.isEmpty(), "The users list should not be empty");
    }

    @Test
    @DisplayName("createUsers: should return a list with 5 users")
    void createUsers_shouldReturnListWith5Users() {
        assertEquals(EXPECTED_NUMBER_OF_USERS, users.size(),
                "The users list should contain exactly " + EXPECTED_NUMBER_OF_USERS + " users");
    }
}