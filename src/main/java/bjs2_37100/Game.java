package bjs2_37100;

import lombok.Getter;

import java.util.Random;

public class Game {
    private int score;
    private int scoreToWin;
    private int lives;
    @Getter
    private boolean isPlaying;
    private final Random random;
    private final Object scoreLock;
    private final Object livesLock;

    public Game() {
        this.score = 0;
        this.scoreToWin = 10;
        this.lives = 10;
        this.isPlaying = true;
        this.random = new Random();
        this.scoreLock = new Object();
        this.livesLock = new Object();
    }

    public Game(int lives, int scoreToWin) {
        this();
        this.lives = lives;
        this.scoreToWin = scoreToWin;
    }

    public void update() {
        synchronized (scoreLock) {
            if (random.nextBoolean() && isPlaying) {
                score++;
                System.out.println("Total score: " + score);
                if (score >= scoreToWin) {
                    gameOver(true);
                }
            }

            synchronized (livesLock) {
                if (random.nextBoolean() && random.nextBoolean() && isPlaying) {
                    lives--;
                    System.out.println("Lives: " + lives);
                    if (lives <= 0) {
                        gameOver(false);
                    }
                }
            }
        }
    }

    public void gameOver(boolean isWin) {
        if (isWin) {
            System.out.println("You win!");
        } else {
            System.out.println("Game over!");
        }
        isPlaying = false;
    }
}
