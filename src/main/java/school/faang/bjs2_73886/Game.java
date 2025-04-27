package school.faang.bjs2_73886;

public class Game {
    private int score = 0;
    private int lives;
    private volatile boolean isRunning = true;

    public Game(int startingLives) {
        lives = startingLives;
    }

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(int scoreChange, int lifeChange) {
        synchronized (scoreLock) {
            synchronized (livesLock) {
                score += scoreChange;
                lives -= lifeChange;
                if (lives <= 0) {
                    isRunning = false;
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("Game over.");
    }

    public boolean isRunning() {
        return isRunning;
    }
}
