package faang.school.godbless.BJS2_1240;

import lombok.Data;

import java.util.Random;

@Data
public class Player {
    private String name;
    private int lives;
    private int score = 0;

    public Player(String name, int lives) {
        this.name = name;
        this.lives = lives;
    }

    public boolean isAlive() {
        return new Random().nextBoolean();
    }

    public void upScore() {
        this.score++;
    }

    public void downLives() {
        this.lives--;
    }
}