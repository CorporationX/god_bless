package broForce;

public class Game {
    private int score;
    private int lives;
    private volatile boolean gameOver = false;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public Game(int score, int lives) {
        this.score = score;
        this.lives = lives;
    }

    public void update(boolean playerScored, boolean playerLostLives) {
        synchronized (scoreLock) {
            if (playerScored && !gameOver) {
                score++;
                System.out.println("Игрок намрал очки " + score);
            }
        }
        synchronized (livesLock) {
            if (playerLostLives && !gameOver) {
                lives--;
                if (lives == 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        gameOver = true;
        System.out.println("Игрок мЕртв!");
    }
}
