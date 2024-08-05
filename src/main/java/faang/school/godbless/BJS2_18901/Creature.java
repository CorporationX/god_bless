package faang.school.godbless.BJS2_18901;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int defense;
    private int speed;
    private int quantity;

    public int getDamage() {
        return attack * quantity;
    }
}
