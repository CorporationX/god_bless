package iron.throne;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int TIMEOUT = 1000;
    private static final int TIMEOUT_SEC = 3;
    private static final int POOL_SIZE = 4;
    private static final List<String> ROLES = new ArrayList<>(Arrays.asList("Knight", "Guardian", "Lord", "Vaniucika"));
    private static final List<User> USERS = new ArrayList<>(
            Arrays.asList(new User("Vasea"),
                    new User("Stici"),
                    new User("Lilo"),
                    new User("John"),
                    new User("Tony")));

    public static void main(String[] args) {
        House houseLanister = new House(ROLES);
        final ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);
        for (User user : USERS) {
            executorService.submit(() -> {
                try {
                    user.joinHouse(houseLanister);
                    Thread.sleep(TIMEOUT);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    user.leaveHouse();
                }
            });
        }
        softShutdown(executorService);
    }

    private static void softShutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT_SEC, TimeUnit.SECONDS)) {
                log.warn("Execution is not terminated in time. Forced shutdown!");
                executor.shutdownNow();
            } else {
                log.info("Execution is terminated successful!");
            }
        } catch (InterruptedException e) {
            log.error("Executor is interrupted {}", e.getMessage());
            executor.shutdownNow();
        }
    }
}
