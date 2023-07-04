package faang.school.godbless.Sprint4.task7_Synch;

import lombok.Getter;

@Getter
public class Game {
    private final Object updateLock = new Object();
    private int score;
    private int lives;

    public Game(int lives) {
        this.lives = lives;
    }

    public void update() {
        synchronized (updateLock) {
            if (lives == 0) {
                gameOver();
            } else {
                score++;
                System.out.println("Current score: " + score);
                lives--;
                System.out.println("Current lives: " + lives);
            }
        }
    }

    private void gameOver() {
        System.out.println("Game over");
    }
}
