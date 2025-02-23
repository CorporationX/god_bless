package school.faang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final int TIMEOUT_SECONDS = 5;

    public static void main(String[] args) {
        House house = new House(new ArrayList<>(Arrays.asList("role 1", "role 2", "role 3")));
        List<User> users = List.of(
                new User("User 1"),
                new User("User 2"),
                new User("User 3"),
                new User("User 4")
        );

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (User user : users) {
            executorService.submit(() -> {
                user.joinHouse(house);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    logger.error("Sleep was interrupted.");
                    throw new RuntimeException(e);
                }
                user.leaveHouse();
            });
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                logger.warn("Not all tasks have been completed on time.");
            }
        } catch (InterruptedException e) {
            logger.error("awaitTermination was interrupted.");
            executorService.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}
