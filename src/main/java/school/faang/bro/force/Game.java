package school.faang.bro.force;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private int score = 0;
    private int lives = 10;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean isPointsEarned, boolean isLifeLost) {
        if (isPointsEarned) {
            synchronized (scoreLock) {
                try {
                    score++;
                    log.info("Очки увеличены, текущий счёт: {}", score);
                } finally {
                    scoreLock.notify();
                }
            }
        }

        if (isLifeLost) {
            synchronized (livesLock) {
                try {
                    if (lives <= 0) {
                        gameOver();
                    }
                    lives--;
                    log.info("Жизни уменьшены, оставшиеся жизни: {}", lives);
                } finally {
                    livesLock.notify();
                }
            }
        }
    }

    public void gameOver() {
        log.info("GAMEOVER!");
        System.exit(0);
    }

    public static void main(String[] args) {
        Game game = new Game();

        for (int i = 0; i < 100; i++) {
            boolean earnedPoints = Math.random() < 0.5;
            boolean lostLife = Math.random() < 0.3;

            game.update(earnedPoints, lostLife);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
