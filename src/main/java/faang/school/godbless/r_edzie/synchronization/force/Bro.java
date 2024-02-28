package faang.school.godbless.r_edzie.synchronization.force;

import lombok.Data;

import java.util.Random;

@Data
public class Bro {
    private final Random random = new Random();

    private String name;
    private int lives;
    private int score = 0;
    private boolean isAlive;

    public Bro(String name, int lives, boolean isAlive) {
        this.name = name;
        this.lives = lives;
        this.isAlive = isAlive;
    }

    public boolean getAlive() {
        return random.nextBoolean();
    }
}
