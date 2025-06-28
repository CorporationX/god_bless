package school.faang.bjs2_82112;

public class Game {
    private int score = 0;
    private int lives = 10;

    private final Object scoreLock = new Object();
    private static final Object livesLock = new Object();

    public void update(boolean isGetScore, boolean isLoseLive) {
        if (isLoseLive) {
            synchronized (livesLock) {
                if (lives <= 0) {
                    gameOver();
                    return;
                }
                lives--;
                System.out.printf("Lives: %s%n", lives);
            }
        }
        if (isGetScore) {
            synchronized (scoreLock) {
                if (lives > 0) {
                    score++;
                    System.out.printf("Score: %s%n", score);
                }
            }
        }
    }

    private void gameOver() {
        System.out.printf("Game over, total score: %s%n", score);
        Thread.currentThread().stop();
    }
}
