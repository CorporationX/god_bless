package school.faang.spotify;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread user1 = new Thread(() -> {
            player.play();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
            player.pause();
        }, "First user ");

        Thread user2 = new Thread(() -> {
            player.skip();
            try {
                Thread.sleep(50);
            } catch (InterruptedException ignored) {
            }
            player.play();
        }, " Second user ");

        Thread user3 = new Thread(() -> {
            player.previous();
            try {
                Thread.sleep(70);
            } catch (InterruptedException ignored) {
            }
            player.pause();
        }, "Third user ");

        user1.start();
        user2.start();
        user3.start();

        try {
            user1.join();
            user2.join();
            user3.join();
        } catch (InterruptedException ignored) {
        }

        log.info("Group session has ended.");
    }
}
