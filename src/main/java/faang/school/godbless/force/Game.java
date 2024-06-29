package faang.school.godbless.force;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Game {
    public final static Object lock = new Object();
    private int score = 0;
    private int lives;

    public Game(int lives) {
        if (lives == 0) {
            throw new IllegalArgumentException("The game cannot start with zero lives!");
        }
        this.lives = lives;
    }

    public void update() {
        synchronized (lock) {
            addScope();
            difLives();
            System.out.println("count increased");
            if (lives == 0) {
                gameOver();
            }
        }
    }

    private void addScope() {
        score++;
    }

    private void difLives() {
        lives--;
    }

    private void gameOver() {
        System.out.println("Game over, you have scored: " + score);
        throw new IllegalArgumentException("Game over");
    }
}
