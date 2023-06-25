package faang.school.godbless.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void groupUsersEmptyMap() {
        var result = User.group(null);

        assertTrue(result.isEmpty());
        assertEquals(0, result.size());
    }
}