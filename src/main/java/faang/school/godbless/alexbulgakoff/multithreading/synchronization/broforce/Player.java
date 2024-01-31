package faang.school.godbless.alexbulgakoff.multithreading.synchronization.broforce;

import lombok.Getter;
import lombok.ToString;

import java.util.Random;

/**
 * @author Alexander Bulgakov
 */
@Getter
@ToString
public class Player {

    private final String name;
    private int health;
    private final boolean alive;

    public Player(String name, int health) {
        this.name = name;
        this.health = health;
        alive = true;
    }

    public boolean isAlive() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public void damageToPlayer() {
        health--;
    }
}
