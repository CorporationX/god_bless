package faang.school.godbless.userregistration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUser {

    @Test
    @DisplayName("Test throw IllegalArgumentException at User creation")
    public void testUser() {

        assertAll(
                () -> assertEquals("Name cannot be null or empty",
                        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> new User(null, 17, "RZHD", "Murmansk"))
                                .getMessage()),
                () -> assertEquals("Name cannot be null or empty",
                        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> new User("", 17, "RZHD", "Murmansk"))
                                .getMessage()),
                () -> assertEquals("Age cannot be less than 18",
                        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> new User("User Name", 17, "RZHD", "Murmansk"))
                                .getMessage()),
                () -> assertEquals("Work Company Name must be one of: " + User.getValidJobs().toString(),
                        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> new User("User Name", 18, "RZHD", "Murmansk"))
                                .getMessage()),
                () -> assertEquals("Home Address must be one of: " + User.getValidAddresses().toString(),
                        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> new User("User Name", 18, "Google", "Murmansk"))
                                .getMessage())
        );
    }
}
