package faang.school.godbless.bro_force;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Getter
@Setter
@ToString
public class Player implements Runnable {
    private final Random fightResultTeller = new Random();
    private final String playerName;
    private int lives;
    private int score;
    private boolean isAlive;
    private Game game;

    public Player(String playerName, int initialLives, Game game) {
        this.playerName = playerName;
        this.lives = initialLives;
        this.isAlive = true;
        this.score = 0;
        this.game = game;
    }

    @Override
    public void run() {
        while (isAlive && !Thread.currentThread().isInterrupted()) {
            game.update(this);
        }
    }

    public boolean isFightSuccessful() {
        return fightResultTeller.nextBoolean();
    }

    public void incrementScore() {
        if (isAlive) {
            score++;
        }
    }

    public void decrementLives() {
        if (isAlive) {
            lives--;
            if (lives == 0) {
                isAlive = false;
                System.out.println(playerName + " died. Let's wrap up the mission ");
            }
        }
    }
}
