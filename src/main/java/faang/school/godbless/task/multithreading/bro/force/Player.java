package faang.school.godbless.task.multithreading.bro.force;

import lombok.Getter;

import java.util.Random;

@Getter
public class Player implements Runnable {
    private static final int DEFAULT_LIVES = 5;
    private static final int DEFAULT_SCORE = 2;

    private final String name;
    private final Game game;
    private final Random random;
    private boolean isAlive;
    private long lives;
    private long score;

    public Player(String name, Game game) {
        this.name = name;
        this.game = game;
        this.random = new Random();
        this.isAlive = true;
        this.lives = DEFAULT_LIVES;
        this.score = DEFAULT_SCORE;
    }

    @Override
    public void run() {
        while (isAlive) {
            game.update(this);
        }
    }

    public boolean battleSuccessful() {
        return random.nextBoolean();
    }

    public void decrementLive() {
        lives--;
        if (lives <= 0) {
            isAlive = false;
        }
    }

    public void incrementScore() {
        score++;
    }
}
