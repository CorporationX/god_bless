package faang.school.godbless.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {

    private static final String USER_NAME = "Username";
    private static final byte VALID_AGE = 18;
    private static final String VALID_JOB = "Uber";
    private static final String VALID_ADDRESS = "New York";
    private static final byte INVALID_AGE = 17;
    private static final String INVALID_JOB = "Invalid job";
    private static final String INVALID_ADDRESS = "Invalid address";


    @Nested
    @DisplayName("User creation")
    class UserCreationTest {

        @Test
        void whenValidUserThenCreate() {
            assertDoesNotThrow(() -> new User(USER_NAME, VALID_AGE, VALID_JOB, VALID_ADDRESS));
        }

        @Test
        void whenInvalidUserThenThrowExc() {
            assertThrows(IllegalArgumentException.class, () -> new User(USER_NAME, INVALID_AGE, INVALID_JOB, INVALID_ADDRESS));
        }
    }

    @Nested
    @DisplayName("groupUsers")
    class GroupUsersTest {

        @Test
        void whenValidUserThenReturnMap() {
            Map<Byte, List<User>> actual = User.groupUsers(getValidUsers());

            assertEquals(1, actual.size());

            assertAll("Grouped users by age 18",
                () -> assertTrue(actual.containsKey(VALID_AGE)),
                () -> assertEquals(3, actual.get(VALID_AGE).size()),
                () -> assertTrue(actual.get(VALID_AGE).stream().anyMatch(user -> user.getName().equals(USER_NAME))),
                () -> assertTrue(actual.get(VALID_AGE).stream().anyMatch(user -> user.getName().equals(USER_NAME))),
                () -> assertTrue(actual.get(VALID_AGE).stream().anyMatch(user -> user.getName().equals(USER_NAME)))
            );
        }

        @Test
        void whenInvalidUserThenThrowExc() {
            assertThrows(IllegalArgumentException.class, () -> User.groupUsers(getInvalidUsers()));
        }

        private List<User> getValidUsers() {
            return List.of(
                User.builder().name(USER_NAME).age(VALID_AGE).job(VALID_JOB).address(VALID_ADDRESS).build(),
                User.builder().name(USER_NAME).age(VALID_AGE).job(VALID_JOB).address(VALID_ADDRESS).build(),
                User.builder().name(USER_NAME).age(VALID_AGE).job(VALID_JOB).address(VALID_ADDRESS).build()
            );
        }

        private List<User> getInvalidUsers() {
            return List.of(
                User.builder().name(USER_NAME).age(INVALID_AGE).job(INVALID_JOB).address(INVALID_ADDRESS).build(),
                User.builder().name(USER_NAME).age(INVALID_AGE).job(INVALID_JOB).address(INVALID_ADDRESS).build(),
                User.builder().name(USER_NAME).age(INVALID_AGE).job(INVALID_JOB).address(INVALID_ADDRESS).build()
            );
        }
    }
}