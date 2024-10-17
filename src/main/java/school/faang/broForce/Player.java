package school.faang.broForce;

import lombok.Data;

@Data
public class Player {
    private final String name;
    private int lives;
    private int isAlive;
    private int score = 0;

    public Player(String name, int lives) {
        this.name = name;
        this.lives = lives;
    }

    public boolean isAlive() {
        return lives > 0;
    }
}
