package faang.school.godbless.dolbahlop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
public class UserTest {

    @ParameterizedTest
    @CsvSource({
            "John, 25, Google, London",
            "Alice, 30, Uber, New York",
            "Bob, 22, Amazon, Amsterdam"
    })
    @DisplayName("Valid Data Should Not Throw Exceptions")
    void ValidData_ShouldNotThrowExceptions(String name, int age, String workplace, String address){
        // Arrange
        User user = null;

        // Act
        try {
            user = new User(name, age, workplace, address);
        } catch (IllegalArgumentException e) {
            fail("User creation failed for valid data: " + e.getMessage());
        }

        // Assert
        assertNotNull(user);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Invalid Name Should Throw Exception")
    void InvalidName_ShouldThrowException(String name){
        // Arrange
        User user = null;
        Exception exception = null;

        // Act
        try {
            user = new User(name, 25, "Google", "London");
        }catch (IllegalArgumentException e){
            exception = e;
        }

        // Assert
        assertNotNull(exception);
        assertEquals("Name can't be empty or null, you'd better check it", exception.getMessage());
        assertNull(user);
    }

    @ParameterizedTest
    @ValueSource(ints = {17, 10, 0, -5})
    @DisplayName("Invalid Age Should Throw Exception")
    void InvalidAge_ShouldThrowException(int age){
        // Arrange
        User user = null;
        Exception exception = null;

        // Act
        try {
            user = new User("John", age, "Google", "London");
        }catch (IllegalArgumentException e){
            exception = e;
        }

        // Assert
        assertNotNull(exception);
        assertEquals("You must be 18 or older", exception.getMessage());
        assertNull(user);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Facebook", "Apple", "Intel", "Oracle"})
    @DisplayName("Invalid Workplace Should Throw Exception")
    void InvalidWorkplace_ShouldThrowException(String workplace){
        // Arrange
        User user = null;
        Exception exception = null;

        // Act
        try {
            user = new User("John", 25, workplace, "London");
        }catch (IllegalArgumentException e){
            exception = e;
        }

        // Assert
        assertNotNull(exception);
        assertEquals("Invalid workplace: " + workplace, exception.getMessage());
        assertNull(user);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Paris", "Tokyo", "Rome", "Berlin"})
    @DisplayName("Invalid Address Should Throw Exception")
    void InvalidAddress_ShouldThrowException(String address){
        // Arrange
        User user = null;
        Exception exception = null;

        // Act
        try {
            user = new User("John", 25, "Uber", address);
        }catch (IllegalArgumentException e){
            exception = e;
        }

        // Assert
        assertNotNull(exception);
        assertEquals("Invalid address: " + address, exception.getMessage());
        assertNull(user);
    }
}
