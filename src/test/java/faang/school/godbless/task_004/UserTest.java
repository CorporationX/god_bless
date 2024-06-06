package faang.school.godbless.task_004;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @Test
    void testInitUser() {
        // Arrange
        String name = "Sam";
        int age = 18;
        String workPlace = "Google";
        String address = "London";

        // Act
        User user = new User(name, age, workPlace, address);

        // Assert
        assertEquals(name, user.name(), "wrong name");
        assertEquals(age, user.age(), "wrong age");
        assertEquals(workPlace, user.placework(), "wrong workPlace");
        assertEquals(address, user.address(), "wrong address");
    }

    @Test
    void testInvalidParameters() {
        // Arrange
        String validName = "Sam";
        String invalidName = null;
        int validAge = 18;
        int invalidAge = 17;
        String validWorkPlace = "Google";
        String invalidWorkPlace = "invalid";
        String validAddress = "London";
        String invalidAddress = "invalid";

        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> new User(invalidName, validAge, validWorkPlace, validAddress),
                "An invalid name should have thrown an exception");
        assertThrows(IllegalArgumentException.class,
                () -> new User(validName, invalidAge, validWorkPlace, validAddress),
                "An invalid age should have thrown an exception");
        assertThrows(IllegalArgumentException.class,
                () -> new User(validName, validAge, invalidWorkPlace, validAddress),
                "An invalid work place should have thrown an exception");
        assertThrows(IllegalArgumentException.class,
                () -> new User(validName, validAge, validWorkPlace, invalidAddress),
                "An invalid address should have thrown an exception");
    }

}
