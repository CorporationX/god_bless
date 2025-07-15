package school.faang.module1.bjs2_82060;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Game game = new Game();
        for (int i = 0; i < 100; i++) {
            executor.execute(() -> game.update(generateType()));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                log.warn("Некоторые задачи не завершились вовремя, принудительное завершение");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Главный поток прерван при ожидании завершения", e);
            executor.shutdownNow();
        }
    }

    public static UpdaterType generateType() {
        return ThreadLocalRandom.current().nextBoolean() ? UpdaterType.SCORE : UpdaterType.LIVES;
    }
}