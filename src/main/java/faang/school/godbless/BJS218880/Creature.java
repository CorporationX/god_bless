package faang.school.godbless.BJS218880;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class Creature {
    String name;
    int level;
    int attack;
    int defence;
    int speed;
    int quantity;

    public Creature(String name, int level, int attack, int defence, int speed, int quantity) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
        this.quantity = quantity;

        if (quantity < 1 || level < 1 || attack < 1 || defence < 1 || speed < 1 ) {
            throw new IllegalArgumentException("Bad parameters");
        }
    }

    int getDamage() {
        return attack * quantity;
    }
}
