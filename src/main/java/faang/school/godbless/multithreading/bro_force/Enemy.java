package faang.school.godbless.multithreading.bro_force;

import java.util.Random;

public record Enemy() {

    public boolean hit() {
        return new Random().nextBoolean();
    }
}