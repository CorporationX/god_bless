package school.faang.sprint_3.task_48859;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserTest {
    House house;

    @BeforeEach
    void setUp() {
        house = new House(new ArrayDeque<>(List.of(Role.MAGE, Role.ARCHER, Role.SWORDSMAN)));
    }

    @RepeatedTest(5)
    void testHouseLogic() {
        User user1 = new User("John");
        User user2 = new User("Alex");
        User user3 = new User("Steve");
        User user4 = new User("Peter");
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.submit(() -> user1.joinHouse(house));
        executorService.submit(() -> user2.joinHouse(house));
        executorService.submit(() -> user3.joinHouse(house));
        executorService.submit(() -> user4.joinHouse(house));
        executorService.submit(user1::leaveHouse);
        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        } finally {
            assertNotNull(user4.getRole());
            assertNotNull(user2.getRole());
            assertNotNull(user3.getRole());
            assertNull(user1.getRole());
        }
    }
}
