package faang.school.godbless.BroForce;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Player {
    private static final Random random = new Random();

    private String name;
    private int score = 0;
    private int lives;

    public Player(String name, int lives) {
        this.name = name;
        this.lives = lives;
    }

    public boolean won() {
        return random.nextBoolean();
    }
}
