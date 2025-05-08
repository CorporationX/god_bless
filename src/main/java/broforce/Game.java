package broforce;

public class Game {
    private int score;
    private int lives = 10;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean isScored, boolean isLifeLost) {
        if (isScored) {
            synchronized (scoreLock) {
                score++;
                System.out.println(Thread.currentThread().getName() + " scored! Total score: " + score);
            }
        }
        if (isLifeLost) {
            synchronized (livesLock) {
                lives--;
                System.out.println(Thread.currentThread().getName() + " lost a life! Remaining lives: " + lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("Game over, you lost!");
        System.exit(0);
    }
}
