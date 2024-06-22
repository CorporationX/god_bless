package faang.school.godbless.force;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Game {
    public final static Object lock = new Object();
    private int scope = 0;
    private int lives;

    public Game(int lives) {
        if (lives == 0) {
            throw new IllegalArgumentException("The game cannot start with zero lives!");
        }
        this.lives = lives;
    }

    public void update() {
        synchronized (lock) {
            scope++;
            lives--;
            System.out.println("count increased");
            if (lives == 0) {
                gameOver();
            }
        }
    }


    private void gameOver() {
        System.out.println("Game over, you have scored: " + scope);
        throw new IllegalArgumentException("Game over");
    }
}
