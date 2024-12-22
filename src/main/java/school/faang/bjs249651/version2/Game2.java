package school.faang.bjs249651.version2;

import lombok.Getter;

public class Game2 {

    @Getter
    private boolean isGameOver;
    private int score;
    private int lives;
    private Object lockForScore = new Object();
    private Object lockForLives = new Object();

    public Game2(int lives) {
        this.score = 0;
        this.lives = lives;
    }

    public void update(Player player) {
        synchronized (lockForScore) {
            if (player.earnedPoint) {
                score++;
                System.out.println(Thread.currentThread().getName() + ". Point gained. Total point is: " + score);
            }
        }

        synchronized (lockForLives) {
            if (player.lostLife) {
                lives--;
                System.out.println(Thread.currentThread().getName() + ". Live lost. Current health is: " + lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.println(Thread.currentThread().getName() + " culprit of loss. Game is over");
        System.out.println("Total score is: " + score);
        isGameOver = true;
    }

}
