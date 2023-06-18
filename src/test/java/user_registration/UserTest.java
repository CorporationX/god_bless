package user_registration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void userConstructor_shouldReturnExceptionWithNullName(){
        IllegalArgumentException result = assertThrows(IllegalArgumentException.class, () -> new User("", 20, "Google", "London"));
        assertEquals("Incorrect name!", result.getMessage());
    }

    @Test
    void userConstructor_shouldReturnExceptionWithWrongAge() {
        IllegalArgumentException result = assertThrows(IllegalArgumentException.class, () -> new User("Ivan", 17, "Google", "London"));
        assertEquals("Incorrect age!", result.getMessage());
    }

    @Test
    void userConstructor_shouldReturnExceptionWithWrongJob() {
        IllegalArgumentException result = assertThrows(IllegalArgumentException.class, () -> new User("Ivan", 19, "FBI", "London"));
        assertEquals("Incorrect job!", result.getMessage());
    }

    @Test
    void userConstructor_shouldReturnExceptionWithWrongAddress() {
        IllegalArgumentException result = assertThrows(IllegalArgumentException.class, () -> new User("Ivan", 19, "Google", "Moscow"));
        assertEquals("Incorrect address!", result.getMessage());
    }
}