package school.faang.iron_thron;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_COUNT = 5;
    private static final int TIMEOUT = 10;

    public static void main(String[] args) {
        House house = new House(new HashMap<>(Map.of(Role.MAGE, true, Role.KNIGHT, true, Role.LORD, true)));
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        List<User> users = List.of(new User("Ilya"), new User("Bob"), new User("Alice"),
                new User("Carol"), new User("Pheon"));

        users.forEach(user -> executorService.execute(() -> {
            try {
                user.joinHouse(house);
            } catch (InterruptedException e) {
                log.error("Thread interrupted", e);
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                log.error("Thread interrupted during sleep", e);
                Thread.currentThread().interrupt();
            }
            user.leaveHouse(house);
        }));

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.warn("Thread timed out");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread interrupted", e);
            executorService.shutdownNow();
        }
        System.out.println("The end of the program");
    }
}
