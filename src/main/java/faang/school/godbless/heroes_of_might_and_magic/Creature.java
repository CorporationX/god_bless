package faang.school.godbless.heroes_of_might_and_magic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
abstract public class Creature {
    private String name;
    private int level;
    private int protection;
    private int speed;
    private int quantity;

    public Creature(String name, int level, int protection, int speed, int quantity) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (level < 0) {
            throw new IllegalArgumentException("Level cannot be negative");
        }
        if (protection < 0) {
            throw new IllegalArgumentException("Protection cannot be negative");
        }
        if (speed < 0) {
            throw new IllegalArgumentException("Speed cannot be negative");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
        this.level = level;
        this.protection = protection;
        this.speed = speed;
        this.quantity = quantity;
    }

    abstract public int getDamage();
}
