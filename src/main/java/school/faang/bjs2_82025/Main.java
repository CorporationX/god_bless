package school.faang.bjs2_82025;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static ExecutorService executor = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        Game game = new Game();

        try {
            while (!game.isGameOver()) {
                boolean isScored = Math.random() < 0.5;
                executor.execute(() -> game.update(isScored));
            }

            executor.shutdownNow();

            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                log.info("Игра не завершена");
                executor.shutdownNow();
            }

        } catch (InterruptedException e) {
            log.error("Поток был прерван", e);
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }
    }
}
