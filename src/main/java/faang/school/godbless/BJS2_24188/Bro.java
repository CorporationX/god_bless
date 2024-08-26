package faang.school.godbless.BJS2_24188;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
public class Bro {

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
