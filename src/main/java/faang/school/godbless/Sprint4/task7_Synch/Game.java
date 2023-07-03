package faang.school.godbless.Sprint4.task7_Synch;

import lombok.Getter;

@Getter
public class Game {
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private int score;
    private int lives;

    public Game(int lives) {
        this.lives = lives;
    }

    public void update() {
        increaseScore();
        reduceLives();
    }

    private void increaseScore() {
        synchronized (livesLock) {
            score++;
            System.out.println("Current score: " + score);
        }
    }

    private void reduceLives() {
        synchronized (livesLock) {
            lives--;
            System.out.println("Current lives: " + lives);
            if (lives == 0) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        synchronized (livesLock) {
            System.out.println("Game over");
        }
    }
}
