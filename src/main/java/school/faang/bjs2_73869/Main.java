package school.faang.bjs2_73869;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int TERMINATION_TIMEOUT = 30;
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        Boss raidBoss = new Boss(1);
        executorService.execute(() -> new Player("Mage").doBattle(raidBoss));
        executorService.execute(() -> new Player("Warrior").doBattle(raidBoss));
        executorService.execute(() -> new Player("Rogue").doBattle(raidBoss));
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