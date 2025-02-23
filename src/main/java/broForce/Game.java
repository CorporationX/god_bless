package broForce;

public class Game {
    public int score = 0;
    public int lives = 5;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();


    public void update(Player player, boolean isPointEarned, boolean isLifeLost) {
        synchronized (scoreLock) {
            if (isPointEarned) {
                score++;
                System.out.printf("Player %s earned a point! Current score: %d. Remaining lives: %d.%n",
                        player.getName(), score, lives);
            }
        }

        synchronized (livesLock) {
            if (isLifeLost) {
                lives--;
                System.out.printf("Player %s lost a life! Current score: %d. Remaining lives: %d.%n",
                        player.getName(), score, lives);
            }

            if (lives <= 0) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        System.out.printf("Game Over! Final score: %d%n", score);
    }
}
