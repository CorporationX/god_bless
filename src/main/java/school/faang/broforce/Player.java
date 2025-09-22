package school.faang.broforce;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player implements Runnable {
    private final Game game;
    private final String name;
    private int score = 0;
    private int lives;

    public Player(Game game, String name, int lives) {
        this.game = game;
        this.name = name;
        this.lives = lives;
    }

    public void addScore(int amount) {
        score += amount;
    }

    public void loseLife(int amount) {
        lives -= amount;
    }


    @Override
    public void run() {
        while (game.isRunning() && lives > 0) {
            game.update(this);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(name + " finished the game. Score=" + score + ", Lives=" + lives);
    }
}
