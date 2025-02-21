package school.faang.bjs2_61502;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) {
        House house = new House();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        List<User> users = List.of(
                new User("Jon Snow"),
                new User("Arya Stark"),
                new User("Bran Stark"),
                new User("Jaime Lannister")
        );

        users.forEach(user -> executor.execute(() -> {
            try {
                user.joinHouse(house);
                TimeUnit.SECONDS.sleep(2 + (int) (Math.random() * 3));
                user.leaveHouse(house);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.warn("Thread interrupted: {}", e.getMessage());
            }
        }));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                log.warn("Forcing shutdown...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Executor interrupted: {}", e.getMessage());
        }

        log.info("All users have finished.");
    }
}
