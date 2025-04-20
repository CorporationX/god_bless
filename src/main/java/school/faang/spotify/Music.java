package school.faang.spotify;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Music {
    private static final int MIN_SLEEP_MS = 0;
    private static final int MAX_SLEEP_MS = 100;

    public static void main(String[] args) {
        Player player = new Player();

        Thread[] userThreads = createUserThreads(player);

        startAndJoinThreads(userThreads);
    }

    private static Thread[] createUserThreads(Player player) {
        return new Thread[]{
                new Thread(() -> {
                    player.play();
                    randomSleep();
                    player.skip();
                }),
                new Thread(() -> {
                    randomSleep();
                    player.pause();
                    randomSleep();
                    player.play();
                }),
                new Thread(() -> {
                    randomSleep();
                    player.previous();
                    player.skip();
                }),
                new Thread(() -> {
                    player.pause();
                    randomSleep();
                    player.pause();
                })
        };
    }

    private static void randomSleep() {
        try {
            int sleepTime = ThreadLocalRandom.current().nextInt(MIN_SLEEP_MS, MAX_SLEEP_MS);
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void startAndJoinThreads(Thread[] threads) {
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Ошибка", e);
                Thread.currentThread().interrupt();
            }
        }
    }
}