package faang.school.godbless.bro_force;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Setter
@Getter
public class Player {

    private String name;
    private int lives;
    private int score = 0;
    private boolean alive;

    public Player(String name, int lives, boolean alive) {
        this.name = name;
        this.lives = lives;
        this.alive = alive;
    }

    public boolean getAlive() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public void killing() {
        alive = false;
    }
}
