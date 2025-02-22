package got;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HouseTest {

    private House house;

    @BeforeEach
    void setUp() {
        Set<String> roles = new HashSet<>(Arrays.asList("Lord", "Knight", "Mage"));
        house = new House(roles);
    }

    @Test
    void testAssignRoleReturnsValidRole() throws InterruptedException {
        String role = house.assignRole();
        assertNotNull(role, "Assigned role should not be null");
        Set<String> validRoles = new HashSet<>(Arrays.asList("Lord", "Knight", "Mage"));
        assertTrue(validRoles.contains(role), "Assigned role must be one of the valid roles");
    }

    @Test
    void testAssignAndReleaseRole() throws InterruptedException {
        String role = house.assignRole();
        house.releaseRole(role);
        String role2 = house.assignRole();
        assertNotNull(role2, "After release, a role should be assigned");
        Set<String> validRoles = new HashSet<>(Arrays.asList("Lord", "Knight", "Mage"));
        assertTrue(validRoles.contains(role2), "Re-assigned role must be valid");
    }

    @Test
    void testAssignRoleWaitsWhenNoneAvailable() throws InterruptedException {
        House singleRoleHouse = new House(new HashSet<>(Collections.singleton("Lord")));
        final String role = singleRoleHouse.assignRole();

        Thread waitingThread = new Thread(() -> {
            try {
                String r = singleRoleHouse.assignRole();
                singleRoleHouse.releaseRole(r);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        waitingThread.start();

        waitingThread.join(100);
        assertTrue(waitingThread.isAlive(), "Waiting thread should be waiting for a role");

        singleRoleHouse.releaseRole(role);
        waitingThread.join();
        assertTrue(true);
    }

    @Test
    void testReleaseRoleWithNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> house.releaseRole(null));
    }
}
