package school.faang.broforce;

import java.util.Random;

public class Game {
    private int score;
    private int lives;
    private final Object lockScore = new Object();
    private final Object lockLive = new Object();

    public Game(int score, int lives) {
        this.score = score;
        this.lives = lives;
    }

    public void update() {
        while (lives > 0) {
            Random random = new Random();
            boolean isLostLive = random.nextBoolean();
            boolean isGetScorePoint = random.nextBoolean();

            synchronized (lockScore) {
                if (isGetScorePoint) {
                    score++;
                    System.out.println("Total score: " + score);
                }
            }

            synchronized (lockLive) {
                if (isLostLive) {
                    lives = Math.max(lives-1, 0);
                    System.out.println("Total lives count: " + lives);
                }
            }
        }

        gameOver();
    }

    private void gameOver() {
        System.out.println("Game Over!");
    }
}
