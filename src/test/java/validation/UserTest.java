package validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    @Test
    @DisplayName("Positive case")
    public void testUser() {
        User user = new User("Lily", 18, "Google", "London");
        User result = new User("Lily", 18, "Google", "London");
        assertEquals(user, result);
    }

    @Test
    @DisplayName("Negative case: name is null")
    public void testNullName() {
        assertThrows(IllegalArgumentException.class, () -> new User(null, 18, "Google", "London"));
    }

    @Test
    @DisplayName("Negative case: name is empty")
    public void testEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new User(" ", 18, "Google", "London"));
    }

    @Test
    @DisplayName("Negative case: age is less than 18")
    public void testAgeValidation() {
        assertThrows(IllegalArgumentException.class, () ->
                new User("Lily", 17, "Google", "London"));
    }

    @Test
    @DisplayName("Negative case: job is not valid")
    public void testJobValidation() {
        assertThrows(IllegalArgumentException.class, () -> new User("Lily", 18, "Facebook", "London"));
    }

    @Test
    @DisplayName("Negative case: address is not valid")
    public void testAddressValidation() {
        assertThrows(IllegalArgumentException.class, () -> new User("Lily", 18, "Google", "Paris"));
    }
}
