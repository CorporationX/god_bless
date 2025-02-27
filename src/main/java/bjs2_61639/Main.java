package bjs2_61639;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int MAX_LIVES = 35;
    private static final int THREAD_COUNT = 10;
    private static final int ITERATIONS_PER_THREAD = 10;
    private static final int WAITING_FOR_TERMINATION_SECONDS = 3;

    public static void main(String[] args) {
        Game game = new Game(MAX_LIVES);

        var executor = Executors.newFixedThreadPool(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            executor.submit(() -> gameThreadProc(game));
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(WAITING_FOR_TERMINATION_SECONDS, TimeUnit.SECONDS)) {
                log.error("Операция не завершилась за {} секунды", WAITING_FOR_TERMINATION_SECONDS);
            }
        } catch (InterruptedException e) {
            log.error("Ошибка ожидания завершения потоков: {}", e.getMessage(), e);
        }

        executor.shutdownNow();

        log.info(game.isGameOver() ? "Игра завершилась" : "Игра не успела закончиться");
    }

    private static void gameThreadProc(Game game) {
        for (int j = 0; j < ITERATIONS_PER_THREAD; j++) {
            boolean isScoreIncremented = Math.random() < 0.7;
            boolean isLiveLost = Math.random() < 0.4;

            if (!game.update(isScoreIncremented, isLiveLost)) {
                return;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                log.error("Ожидание в потоке завершилось с ошибкой: {}", e.getMessage(), e);

                return;
            }
        }
    }
}
