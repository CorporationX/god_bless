package school.faang.bjs2_82041;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Game game = new Game(10);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 100; i++) {
            executor.submit(() -> {
                try {
                    game.update();
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    log.error("InterruptedException", e);
                    Thread.currentThread().interrupt();
                }

                if (game.getLives() == 0) {
                    executor.shutdownNow();
                }
            });
        }

        executor.shutdown();
    }
}
