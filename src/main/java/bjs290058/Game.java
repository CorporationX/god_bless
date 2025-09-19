package bjs290058;

import lombok.Getter;

@Getter
public class Game {
    private int score;
    private int lives;
    private boolean gameInProgress = true;

    private final Object lockScore = new Object();
    private final Object lockLives = new Object();

    public Game(int lives) {
        this.lives = lives;
    }

    public void update(boolean isGamerGotPoints, boolean isGamerLostLive) {
        synchronized (lockScore) {
            if (isGamerGotPoints) {
                score++;
                System.out.println("Got the point!");
            }
        }

        synchronized (lockLives) {
            if (isGamerLostLive && lives > 0) {
                lives--;
                System.out.println("Lost the life!");
            }
            if (lives <= 0) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        gameInProgress = false;
        System.out.println("GAME OVER!");

    }
}
