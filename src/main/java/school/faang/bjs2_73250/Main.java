package school.faang.bjs2_73250;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREADS_COUNT = 5;
    private static final int TERMINATION_TIMEOUT = 10;
    private static final int SLEEP_TIMEOUT = 10;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);

    public static void main(String[] args) {
        List<String> roles = new ArrayList<>();
        roles.add("Knight");
        roles.add("Mage");
        roles.add("Lord");
        House lannisters = new House(roles);
        for (int i = 0; i < THREADS_COUNT; i++) {
            int iterator = i;
            executorService.execute(() -> {
                User user = new User("user_%d".formatted(iterator));
                user.joinHouse(lannisters);
                try {
                    Thread.sleep(SLEEP_TIMEOUT);
                } catch (InterruptedException e) {
                    log.error("Interrupted exception with message {} was thrown during sleep", e.getMessage());
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                } finally {
                    user.leaveHouse();
                }
            });
        }
        dispose();
    }

    private static void dispose() {
        log.info("Start disposing executor service");
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.SECONDS)) {
                log.warn("Not all tasks was stopped successfully");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Interrupted exception with message {} was thrown", e.getMessage());
            executorService.shutdownNow();
        }
    }
}