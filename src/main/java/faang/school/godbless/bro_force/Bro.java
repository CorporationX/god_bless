package faang.school.godbless.bro_force;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;
@Setter
@Getter
public class Bro {
    private String name;
    private int broLives;
    private int broScores = 0;

    public Bro(String name, int broLives) {
        this.name = name;
        this.broLives = broLives;
    }

    public boolean getDamage() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
