package faang.school.godbless.alexbulgakoff.multithreading.synchronization.broforce;

import lombok.Getter;
import lombok.ToString;

/**
 * @author Alexander Bulgakov
 */
@Getter
@ToString
public class Player {
    private final String name;
    private int health;
    private boolean alive;

    public Player(String name, int health) {
        this.name = name;
        this.health = health;
        alive = true;
    }

    public void damageToPlayer() {
        System.out.println("Игрок " + name + " получает урон!");
        health--;
        if (health == 0) {
            alive = false;
        }
    }
}
