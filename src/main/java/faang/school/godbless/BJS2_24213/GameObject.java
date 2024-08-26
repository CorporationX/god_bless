package faang.school.godbless.BJS2_24213;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class GameObject {
    private String name;
    private int lives;
    private int score = 0;
    private boolean isAlive = true;

    public GameObject(String name, int lives) {
        this.name = name;
        this.lives = lives;
    }

    public boolean isAlive() {
        return new Random().nextBoolean();
    }
}
