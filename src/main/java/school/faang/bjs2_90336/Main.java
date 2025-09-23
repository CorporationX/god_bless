package school.faang.bjs2_90336;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final long TIMEOUT_MINUTES = 1L;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Boss boss = new Boss(2);

        Player player1 = new Player("Игрок 1");
        Player player2 = new Player("Игрок 2");
        Player player3 = new Player("Игрок 3");
        Player player4 = new Player("Игрок 4");

        executor.execute(() -> player1.doBattle(boss));
        executor.execute(() -> player2.doBattle(boss));
        executor.execute(() -> player3.doBattle(boss));
        executor.execute(() -> player4.doBattle(boss));

        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIMEOUT_MINUTES, TimeUnit.MINUTES)) {
                log.warn("Время ожидания истекло, принудительно завершаем...");
                executor.shutdownNow();
            } else {
                log.info("Все игроки завершили сражение!");
            }
        } catch (InterruptedException e) {
            log.error("Сражение прервано");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}