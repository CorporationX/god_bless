package school.faang.broforce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int AWAIT_TERMINATION = 5;
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Game game = new Game();
        Random random = new Random();

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 200; i++) {
            executor.submit(() -> game.update(random.nextBoolean(), random.nextBoolean()));
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION, TimeUnit.SECONDS)) {
                LOGGER.warn("Потоки не завешились за {} секунд. Завершаю принудительно...", AWAIT_TERMINATION);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            LOGGER.error("Поток прерван во время завершения работы ", e);
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
