package faang.school.godbless.bro_force;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Getter
@Setter
@ToString
public class Player implements Runnable {
    private Game game;
    private int lives;
    private int score;
    private boolean isAlive;
    private final String playerName;
    private final Random fightResultTeller = new Random();
    private UpdateResult lastUpdatedResult = UpdateResult.GAME_NOT_STARTED;

    public Player(String playerName, int initialLives, Game game) {
        this.playerName = playerName;
        this.lives = initialLives;
        this.game = game;
        this.isAlive = true;
        this.score = 0;
    }

    @Override
    public void run() {
        while (isAlive && !Thread.currentThread().isInterrupted()) {
            lastUpdatedResult = game.update(this);
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
