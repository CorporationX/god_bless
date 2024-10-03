package userRegistrationTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import userRegistration.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @Test
    @DisplayName("positive test")
    void testUserConstructor_positive() {
        // Arrange
        String name = "Vlad";
        int age = 26;
        String workplace = "Uber";
        String address = "Amsterdam";
        // Act
        User user = new User(name, age, workplace, address);
        // Assert
        assertEquals(new User("Vlad", 26, "Uber", "Amsterdam"), user);
    }

    @Test
    @DisplayName("name - invalid value, null")
    void testUserConstructor_nameInvalid_null() {
        // Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new User(null, 22, "Amazon", "New York"));
        assertEquals("Invalid name", exception.getMessage());
    }

    @Test
    @DisplayName("name - invalid value, empty")
    void testUserConstructor_nameInvalid_empty() {
        // Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new User("", 22, "Amazon", "New York"));
        assertEquals("Invalid name", exception.getMessage());
    }

    @Test
    @DisplayName("age - invalid value, < 18")
    void testUserConstructor_ageInvalid() {
        // Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new User("Denis", 12, "Amazon", "New York"));
        assertEquals("Invalid age", exception.getMessage());
    }

    @Test
    @DisplayName("workplace - invalid value")
    void testUserConstructor_workplaceInvalid() {
        // Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new User("Denis", 22, "Sber", "New York"));
        assertEquals("Invalid workplace", exception.getMessage());
    }

    @Test
    @DisplayName("address - invalid value")
    void testUserConstructor_addressInvalid() {
        // Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new User("Denis", 23, "Google", "Moscow"));
        assertEquals("Invalid address", exception.getMessage());
    }
}
