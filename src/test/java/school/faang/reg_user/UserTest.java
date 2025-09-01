package school.faang.reg_user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static school.faang.reg_user.User.VALID_ADDRESSES;
import static school.faang.reg_user.User.VALID_JOBS;

class UserTest {

    @Test
    void testUserValidation_whenNameIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new User("", 30, "Google", "London"));

        Assertions.assertEquals("name cannot be empty", exception.getMessage());
    }

    @Test
    void testUserValidation_whenAgeIsUnder18() {
        int age = 17;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new User("Mister", age, "Google", "London"));

        Assertions.assertEquals("age is under 18, actual value: %s".formatted(age), exception.getMessage());
    }

    @Test
    void testUserValidation_whenJobIsInvalid() {
        String job = "Roga & Kopita";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new User("Mister", 30, job, "London"));

        Assertions.assertEquals("job %s is not valid, permitted values: %s".formatted(job, VALID_JOBS),
                exception.getMessage());
    }

    @Test
    void testUserValidation_whenAddressIsInvalid() {
        String address = "Samara";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new User("Mister", 30, "Google", address));

        Assertions.assertEquals("address %s is not valid, permitted values: %s".formatted(address, VALID_ADDRESSES),
                exception.getMessage());
    }

    @Test
    void testUserValidationPositive() {
        User user = Assertions.assertDoesNotThrow(() -> new User("Mister", 33, "Google", "London"));

        Assertions.assertEquals("Mister", user.getName());
        Assertions.assertEquals(33, user.getAge());
        Assertions.assertEquals("Google", user.getJob());
        Assertions.assertEquals("London", user.getAddress());
    }

}