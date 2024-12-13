package school.faang.task_43777;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserValidatorTest {

    @Test
    @DisplayName("validateName: should throw exception for null or empty name")
    void validateName_shouldThrowExceptionForNullOrEmptyName() {
        assertAll("Invalid name should throw IllegalArgumentException",
                () -> assertThrows(IllegalArgumentException.class, () -> UserValidator.validateName(null)),
                () -> assertThrows(IllegalArgumentException.class, () -> UserValidator.validateName("")),
                () -> assertDoesNotThrow(() -> UserValidator.validateName("Alice"))
        );
    }

    @Test
    @DisplayName("validatorAge: should throw exception for invalid age")
    void validateAge_shouldThrowExceptionForInvalidAge() {
        assertAll("Invalid age should throw IllegalArgumentException",
                () -> assertThrows(IllegalArgumentException.class, () -> UserValidator.validateAge(-1)),
                () -> assertThrows(IllegalArgumentException.class, () -> UserValidator.validateAge(17)),
                () -> assertDoesNotThrow(() -> UserValidator.validateAge(18))
        );
    }

    @Test
    @DisplayName("validateJob: should throw exception for null, empty or invalid job")
    void validateJob_shouldThrowExceptionForNullOrEmptyOrInvalidJob() {
        assertAll("Invalid job should throw IllegalArgumentException",
                () -> assertThrows(IllegalArgumentException.class, () -> UserValidator.validateJob(null)),
                () -> assertThrows(IllegalArgumentException.class, () -> UserValidator.validateJob("")),
                () -> assertThrows(IllegalArgumentException.class, () -> UserValidator.validateJob("job")),
                () -> assertDoesNotThrow(() -> UserValidator.validateJob("Google")),
                () -> assertDoesNotThrow(() -> UserValidator.validateJob("Uber"))
        );
    }

    @Test
    @DisplayName("validateAddress: should throw exception for null, empty or invalid address")
    void validateAddress_shouldThrowExceptionForNullOrEmptyOrInvalidAddress() {
        assertAll("Invalid address should throw IllegalArgumentException",
                () -> assertThrows(IllegalArgumentException.class, () -> UserValidator.validateAddress(null)),
                () -> assertThrows(IllegalArgumentException.class, () -> UserValidator.validateAddress("")),
                () -> assertThrows(IllegalArgumentException.class, () -> UserValidator.validateAddress("address")),
                () -> assertDoesNotThrow(() -> UserValidator.validateAddress("London")),
                () -> assertDoesNotThrow(() -> UserValidator.validateAddress("Amsterdam"))
        );
    }
}