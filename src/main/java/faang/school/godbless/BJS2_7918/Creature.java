package faang.school.godbless.BJS2_7918;

import lombok.AllArgsConstructor;
import lombok.ToString;


@AllArgsConstructor @ToString
public abstract class Creature {
    protected String name;
    protected int level;
    protected int attack;
    protected int defence;
    protected int speed;
    protected int quantity;

    public abstract int getDamage();

}
