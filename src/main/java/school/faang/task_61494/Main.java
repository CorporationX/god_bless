package school.faang.task_61494;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Player.class);
    private static final int THREAD_TIMEOUT = 2;

    public static void main(String[] args) {
        Boss boss = new Boss(2);
        ExecutorService pool = Executors.newFixedThreadPool(4);
        List<Player> players = List.of(
                new Player("Игрок 1"),
                new Player("Игрок 2"),
                new Player("Игрок 3"),
                new Player("Игрок 4")
        );

        players.forEach(player -> pool.submit(() -> player.doBattle(boss)));

        pool.shutdown();
        try {
            if (!pool.awaitTermination(THREAD_TIMEOUT, TimeUnit.MINUTES)) {
                LOG.info("Thread execution time exceeded the limit.");
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            LOG.error("Thread execution was interrupted.", e);
            pool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
