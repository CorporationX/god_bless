package got;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

    private House house;
    private User user;

    @BeforeEach
    void setUp() {
        Set<String> roles = new HashSet<>(Arrays.asList("Lord", "Knight", "Mage"));
        house = new House(roles);
        user = new User("TestUser", house);
    }

    @Test
    void testJoinAndLeaveHouse() {
        user.joinHouse();
        assertNotNull(user.getAssignedRole(), "User should have an assigned role after joining");
        user.leaveHouse();
        assertNull(user.getAssignedRole(), "User's role should be null after leaving the house");
    }

    @Test
    void testLeaveHouseWithoutJoining() {
        assertDoesNotThrow(() -> user.leaveHouse());
        assertNull(user.getAssignedRole(), "User's role remains null if they never joined");
    }

    @Test
    void testUserRunMethod() throws InterruptedException {
        User threadUser = new User("ThreadUser", house);
        Thread t = new Thread(threadUser);
        t.start();
        t.join();
        assertNull(threadUser.getAssignedRole(), "After running, user's role should be released");
    }
}
