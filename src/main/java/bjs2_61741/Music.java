package bjs2_61741;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class Music {
    public static final int TRACK_COUNT = 30;
    public static final int THREAD_COUNT = 5;
    public static final int ITERATION_COUNT = 20;
    public static final int DELAY_MS = 200;

    public static void main(String[] args) {
        var player = new Player(TRACK_COUNT);

        var playerMethods = new Runnable[]{
                player::play,
                player::pause,
                player::skip,
                player::previous
        };

        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> userThreadProc(playerMethods));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Ожидание потока завершилось ошибкой: {}", e.getMessage(), e);
            }
        }

        log.info("Всё закончилось");
    }

    private static void userThreadProc(Runnable[] playerMethods) {
        var random = new Random();

        for (int i = 0; i < ITERATION_COUNT; i++) {
            playerMethods[random.nextInt(playerMethods.length)].run();

            try {
                Thread.sleep(DELAY_MS);
            } catch (InterruptedException e) {
                log.error("Ожидание завершилось ошибкой: {}", e.getMessage(), e);

                return;
            }
        }
    }
}
