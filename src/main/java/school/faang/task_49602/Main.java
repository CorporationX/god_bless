package school.faang.task_49602;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        Thread gameThread = new Thread(() -> {
            for(int i = 0; i < 20; i++) {
                boolean scored = Math.random() > 0.5;
                boolean lostLife = Math.random() > 0.7;
                game.update(scored, lostLife);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Main thread is interrupted");
                }
            }
        });

        gameThread.start();

        try {
            gameThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Main thread is interrupted");
        }

        log.info("Game over");
    }
}
