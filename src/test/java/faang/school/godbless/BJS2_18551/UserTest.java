package faang.school.godbless.BJS2_18551;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static faang.school.godbless.BJS2_18551.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private static final Map<User, String> FIND_HOBBY_LOVERS_RESULT = User.findHobbyLovers(USERS, Set.of("Swimming", "Yoga"));

    @Test
    void testFindHobbyLoversCorrect() {
        assertEquals(CORRECT_USER_MAP, FIND_HOBBY_LOVERS_RESULT);
    }

    @Test
    void testFindHobbyLoversIncorrect() {
        assertNotEquals(INCORRECT_USER_MAP, FIND_HOBBY_LOVERS_RESULT);
    }
}