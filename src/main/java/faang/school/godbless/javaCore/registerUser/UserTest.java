package faang.school.godbless.javaCore.registerUser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void validateUserTest() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> new User("", 19, "Google", "New York")),
                () -> assertThrows(IllegalArgumentException.class, () -> new User("Name", 10, "Uber", "London")),
                () -> assertThrows(IllegalArgumentException.class, () -> new User("Name", 19, "Ozon", "Amsterdam")),
                () -> assertThrows(IllegalArgumentException.class, () -> new User("Name", 19, "Amazon", "Berlin"))
        );
    }
}