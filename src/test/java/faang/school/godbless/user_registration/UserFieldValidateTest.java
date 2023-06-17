package faang.school.godbless.user_registration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class UserFieldValidateTest {

    private User userOne;
    private User userTwo;
    private User userThree;
    private static List<User> users;
    private static Map<Integer, List<User>> usersForCheck;

    @BeforeEach
    public void setUp() {
        userOne = new User("Kirill", 21, "Google", "Amsterdam");
        userTwo = new User("Ivan", 22, "Google", "London");
        userThree = new User("Maria", 23, "Amazon", "New York");
        users = Arrays.asList(userOne, userTwo, userThree);
    }

    @Test
    public void testGroupUsers() {
        usersForCheck = User.groupUsers(users);
        assertEquals(3, usersForCheck.size());
    }

    @Test
    public void testUserFieldValidationNegative() {
        assertThrows(IllegalArgumentException.class, () -> User.validateName(""));
        assertThrows(IllegalArgumentException.class, () -> User.validateAge(10));
        assertThrows(IllegalArgumentException.class, () -> User.validateJob("VTB"));
        assertThrows(IllegalArgumentException.class, () -> User.validateAddress("Moscow"));
    }

    @Test
    public void testUserFieldValidationPositive() {
        assertEquals("Kirill", userOne.getName());
        assertEquals(21, userOne.getAge());
        assertEquals("Google", userOne.getJob());
        assertEquals("Amsterdam", userOne.getAddress());
    }
}
