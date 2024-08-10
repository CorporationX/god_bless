package faang.school.godbless.BJS2_18565;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static faang.school.godbless.BJS2_18565.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class UserTest {

    private static final Map<Integer, List<User>> GROUP_USERS_RESULT = User.groupUsers(USER_LIST);

    @Test
    public void groupUsersCorrect() {
        assertEquals(CORRECT_USER_MAP, GROUP_USERS_RESULT);
    }

    @Test
    public void groupUsersIncorrect() {
        assertNotEquals(INCORRECT_USER_MAP, GROUP_USERS_RESULT);
    }
}