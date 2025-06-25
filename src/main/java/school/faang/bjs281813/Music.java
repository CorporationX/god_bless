package school.faang.bjs281813;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Music {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();

        Thread[] threads = {
                new Thread(() -> {
                    for (int i = 0; i < 3; i++) {
                        player.play();
                        ThreadUtils.sleep(100);
                    }
                }, "PlayUser"),

                new Thread(() -> {
                    for (int i = 0; i < 3; i++) {
                        player.pause();
                        ThreadUtils.sleep(100);
                    }
                }, "PauseUser"),

                new Thread(() -> {
                    for (int i = 0; i < 3; i++) {
                        player.skip();
                        ThreadUtils.sleep(100);
                        player.previous();
                        ThreadUtils.sleep(100);
                    }
                }, "NavigationUser"),

                new Thread(() -> {
                    for (int i = 0; i < 3; i++) {
                        player.play();
                        ThreadUtils.sleep(100);
                        player.skip();
                        ThreadUtils.sleep(100);
                        player.pause();
                        ThreadUtils.sleep(100);
                    }
                }, "MixedUser"),
        };

        for (Thread thread : threads) {
            thread.start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        log.info("🎵 Все потоки завершили работу. Финал.");
    }
}