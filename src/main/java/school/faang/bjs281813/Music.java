package school.faang.bjs281813;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Music {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                player.play();
                ThreadUtils.sleep(100);
            }
        }, "PlayUser");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                player.pause();
                ThreadUtils.sleep(100);
            }
        }, "PauseUser");

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                player.skip();
                ThreadUtils.sleep(100);
                player.previous();
                ThreadUtils.sleep(100);
            }
        }, "NavigationUser");

        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                player.play();
                ThreadUtils.sleep(100);
                player.skip();
                ThreadUtils.sleep(100);
                player.pause();
                ThreadUtils.sleep(100);
            }
        }, "MixedUser");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        log.info("🎵 Все потоки завершили работу. Финал.");
    }
}