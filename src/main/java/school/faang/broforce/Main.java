package school.faang.broforce;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final Game GAME = new Game();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            boolean isEarnedPoints = Math.random() >= 0.5;
            boolean isLostLife = Math.random() >= 0.5;

            try {
                Thread thread = new Thread(() -> GAME.update(isEarnedPoints, isLostLife));
                thread.start();
            } catch (RuntimeException e) {
                log.error(e.getMessage(), e.getStackTrace(), e);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e.getStackTrace(), e);
            }
        }
    }
}