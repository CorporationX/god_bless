package school.faang.bjs2_90291;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int MAX_COUNT_PLAYERS = 2;
    private static final int COUNT_THREADS = 4;
    private static final int AWAIT_THREADS_MIN = 1;

    public static void main(String[] args) {
        Boss boss = new Boss(MAX_COUNT_PLAYERS);

        List<Player> players = List.of(
                new Player("Игрок 1"),
                new Player("Игрок 2"),
                new Player("Игрок 3"),
                new Player("Игрок 4")
        );

        ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREADS);

        try {
            players.forEach(player -> executor.submit(() -> player.doBattle(boss)));
        } finally {
            executor.shutdown();

            try {
                if (!executor.awaitTermination(AWAIT_THREADS_MIN, TimeUnit.MINUTES)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }
}
