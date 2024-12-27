package school.faang.sprint_3.task_48988;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUMBERS_OF_THREADS = 6;
    private static final int AWAIT_TIME_MINUTES = 1;

    public static void main(String[] args) {

        List<Roles> roles = List.of(Roles.KNIGHT, Roles.LORD, Roles.NOBLEMAN, Roles.MAGE);
        House house = new House(roles);

        User user1 = new User("Bob");
        User user2 = new User("Max");
        User user3 = new User("Alex");
        User user4 = new User("Ray");

        ExecutorService executor = Executors.newScheduledThreadPool(NUMBERS_OF_THREADS);

        try {
            executor.submit(() -> user1.joinHouse(house));
            executor.submit(() -> user2.joinHouse(house));
            executor.submit(() -> user3.joinHouse(house));
            executor.submit(() -> user4.joinHouse(house));
            executor.submit(() -> user2.leaveHouse(house));
            executor.submit(() -> user3.leaveHouse(house));

            executor.shutdown();
            if (executor.awaitTermination(AWAIT_TIME_MINUTES, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (Exception e) {
            log.error("Error message: ", e);
        }
    }
}
