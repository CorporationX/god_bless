package faang.school.godbless.broforce;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Bro {

    private String name;
    private int lives;
    private int score;

    public Bro(String name, int lives) {
        this.name = name;
        this.lives = lives;
    }

    public boolean getAlive() {
        return new Random().nextBoolean();
    }
}
