package faang.school.godbless.sprint3.bro_force;

import lombok.Data;

@Data
public class Game {
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private int score;
    private int lives = 5;

    public void update() {
        synchronized (scoreLock) {
            synchronized (livesLock) {
                if (lives > 0) {
                    ++score;
                    --lives;
                } else {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("Game Over");
    }

    public static void main(String[] args) {
        Game game = new Game();
        while (game.lives > 0) {
            game.update();
            System.out.println(String.format("Score: %d, Lives: %d", game.score, game.lives));
        }
    }
}
