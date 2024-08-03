import user.registration.User;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    @Test
    @DisplayName("Testing user creation")
    void userTest_userCreationWithCorrectParameters() {
        assertDoesNotThrow(() -> new User("Kolya", 21, "Google", "New York"));
    }

    @ParameterizedTest
    @DisplayName("Testing user creation with incorrect parameters")
    @CsvSource({
            "'',24,Google,New York",
            "Vasya,17,Uber,Amsterdam",
            "Katya,21,Yandex,London",
            "Olya,25,Amazon,Montreal"
    })
    void userTest_userCreationWithIncorrectParameters(String name, int age, String workPlace, String address) {
        assertThrows(IllegalArgumentException.class, () -> new User(name, age, workPlace, address));
    }
}
