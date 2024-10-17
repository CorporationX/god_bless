package school.faang.broforce;

import java.util.Random;

public record Player(String name, int hitPoints, int chance) {

    public int getScore() {
        return new Random().nextInt(chance) + 1;
    }
}