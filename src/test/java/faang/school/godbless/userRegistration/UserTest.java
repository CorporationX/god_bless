package faang.school.godbless.userRegistration;

import faang.school.godbless.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @Test
    public void shouldThrowIllegalArgException() {
        assertThrows(IllegalArgumentException.class, () ->
                new User("Vlad", 26, "DataArt", "Amsterdam"));
    }

}
