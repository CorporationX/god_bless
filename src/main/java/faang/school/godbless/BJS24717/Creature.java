package faang.school.godbless.BJS24717;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int defense;
    private int speed;
    private int quantity;

    public abstract int getDamage();
}
