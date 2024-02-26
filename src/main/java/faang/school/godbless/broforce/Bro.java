package faang.school.godbless.broforce;

import lombok.Data;

import java.util.Random;

@Data
public class Bro {

    private String name;
    private long score = 0;
    private int lives = 4;
    private Random random = new Random();

    public Bro(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return random.nextBoolean();
    }
}
