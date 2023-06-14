package faang.school.godbless.user_registration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class UserFieldValidateTest {

    @Test
    public void testUserFieldValidation() {
        assertThrows(IllegalArgumentException.class, () -> User.validateName(""));
        assertThrows(IllegalArgumentException.class, () -> User.validateAge(10));
        assertThrows(IllegalArgumentException.class, () -> User.validateJob("VTB"));
        assertThrows(IllegalArgumentException.class, () -> User.validateAddress("Moscow"));
    }
}
