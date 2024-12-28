package school.faang.bjs249349;

import lombok.Getter;

@Getter
public class Game {
    private int score;
    private int lives;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public Game(int score, int lives) {
        this.score = score;
        this.lives = lives;
    }

    public void update(boolean earnedPoints, boolean lostLife) {
        synchronized (scoreLock) {
            if (earnedPoints) {
                score++;
                System.out.println("Score: " + score);
            }
        }
        synchronized (livesLock) {
            if (lostLife) {
                lives--;

                System.out.println("Lives: " + lives);
                if (lives < 1) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("Game over!");
    }
}
