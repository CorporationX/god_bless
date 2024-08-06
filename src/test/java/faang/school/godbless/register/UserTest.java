package faang.school.godbless.register;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void shouldValidateName() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new User("", 20, "Google", "London"));
        assertEquals("incorrect name", exception.getMessage());
    }

    @Test
    void shouldValidateAge() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new User("a", 2, "Google", "London"));
        assertEquals("incorrect age", exception.getMessage());
    }

    @Test
    void shouldValidateAddress() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new User("a", 20, "Google", "Moscow"));
        assertEquals("incorrect address", exception.getMessage());
    }

    @Test
    void shouldValidateWorkPlace() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new User("a", 20, "Sber", "London"));
        assertEquals("incorrect workplace", exception.getMessage());
    }

}
