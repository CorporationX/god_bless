package school.faang.forcebro;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ForceBroTesting {
    public static void main(String[] args) {
        Game game = new Game();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        while (!game.isGameOver()) {
            boolean isAddScore = Math.random() < 0.7;
            boolean isHealthLost = Math.random() < 0.5;
            executor.submit(() -> game.update(isAddScore, isHealthLost));

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                log.info("Истекло время ожидания. Принудительная остановка задач.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
