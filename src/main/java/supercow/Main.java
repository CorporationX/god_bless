package supercow;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int POOL_SIZE = 2;
    private static final int TIMEOUT = 30;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(POOL_SIZE);
    private static List<Player> players =
            List.of(
                    new Player("Dan"),
                    new Player("Nazar"),
                    new Player("Lera"),
                    new Player("Kiril"),
                    new Player("John"),
                    new Player("Andreas")
            );

    public static void main(String[] args) {
        Boss boss = new Boss();
        boss.setMaxPlayers(5);

        for (Player player : players) {
            EXECUTOR.submit(() -> player.doBattle(boss));
        }

        softShutdown();
    }

    private static void softShutdown() {
        EXECUTOR.shutdown();
        try {
            if (!EXECUTOR.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.warn("Execution is not terminated in time. Forced shutdown!");
                EXECUTOR.shutdownNow();
            } else {
                log.info("Execution is terminated successful!");
            }
        } catch (InterruptedException e) {
            log.error("Executor is interrupted {}", e.getMessage());
            EXECUTOR.shutdownNow();
        }
    }
}
