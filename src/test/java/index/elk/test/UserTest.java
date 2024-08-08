package index.elk.test;

import index.elk.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    @Test
    @DisplayName("Testing create User with null arguments")
    void userTest_createWithNullArguments() {
        assertThrows(NullPointerException.class, () -> new User(null));
    }
}
