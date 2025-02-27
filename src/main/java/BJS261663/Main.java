package BJS261663;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        House house = new House();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        User firstUser = new User("First User", "A");
        User secondUser = new User("Second User", "B");
        User thirdUser = new User("Third User", "C");

        List<User> users = Arrays.asList(firstUser, secondUser, thirdUser);

        users.forEach(user ->
                executor.submit(() -> {
                    try {
                        user.joinHouse(house);
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        log.error("Main err{}", e.getMessage());
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    } finally {
                        user.leaveHouse();
                    }
                })
        );
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                log.warn("Поток не был остановлен. Принудительно останавливаю...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток прерван во время остановки ", e);
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}

