package bjs2_61639;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final int THREAD_COUNT = 10;
    private static final int ITERATIONS_PER_THREAD = 10;

    public static void main(String[] args) {
        Game game = new Game();

        Thread[] gameThreads = new Thread[THREAD_COUNT];
        for (int i = 0; i < gameThreads.length; i++) {
            gameThreads[i] = new Thread(() -> {
                gameThreadProc(game);
            });
            gameThreads[i].start();
        }

        for (Thread gameThread : gameThreads) {
            try {
                gameThread.join();
            } catch (InterruptedException e) {
                log.error("Не удалось дождаться завершения потока: {}", e.getMessage(), e);
            }
        }

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
