package faang.school.godbless.BJS2_24270;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Getter
@Setter
@ToString
class Bro {
    private String name;
    private int lives;
    private int score = 0;
    private boolean alive;

    public Bro(String name, int lives, boolean alive) {
        this.name = name;
        this.lives = lives;
        this.alive = alive;
    }
    public boolean getAlive() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
