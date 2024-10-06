package school.faang.usersRegistration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    void nameValidationTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new User("", 30, "Amazon", "London"));
        assertEquals("name is null or empty", exception.getMessage());
    }

    @Test
    void ageValidationTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new User("Kirill", 12, "Amazon", "London"));
        assertEquals("age can`t be less then 18", exception.getMessage());
    }

    @Test
    void jobValidationTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new User("Kirill", 30, "Sber", "London"));
        assertEquals("workPlace can be only \"Google\", \"Uber\" or \"Amazon\"", exception.getMessage());
    }

    @Test
    void addressValidationTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new User("Kirill", 30, "Amazon", "Rostov-on-Don"));
        assertEquals("address can be only \"London\", \"New York\" or \"Amsterdam\"", exception.getMessage());
    }
}
