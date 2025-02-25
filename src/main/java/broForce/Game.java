package broForce;

import lombok.Getter;

@Getter
public class Game {
    private int score = 0;
    private int lives = 5;
    private boolean isGameOver = false;
    private final Object lock = new Object();

    public void update(Player player, boolean isPointEarned, boolean isLifeLost) {
        synchronized (lock) {
            if (isGameOver) {
                return;
            }

            System.out.printf("Player %s is battling.\n", player.getName());

            if (isPointEarned) {
                score++;
                System.out.printf("Player %s earned a point! Current score: %d. Remaining lives: %d.%n",
                        player.getName(), score, lives);
            }

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
        isGameOver = true;
        System.out.printf("Game Over! Final score: %d%n", score);
    }
}
