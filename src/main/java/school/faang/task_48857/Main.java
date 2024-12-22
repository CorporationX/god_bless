package school.faang.task_48857;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 10;

    public static void main(String[] args) {
        House house = new House("House-1", Arrays.asList(Role.LORD, Role.KNIGHT, Role.MAGE));
        List<User> users = Arrays.asList(new User("User1"), new User("User2"), new User("User3"));

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        users.forEach(user -> {
            executorService.execute(() -> {
                user.joinHouse(house);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
                user.leaveHouse();
            });
        });

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(15, TimeUnit.SECONDS)) {
                log.info("All users have completed their actions.");
            } else {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
