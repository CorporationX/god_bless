package faang.school.godbless.Task18288;

import lombok.Data;

@Data
public abstract class Creature {

    protected String name;
    protected int level;
    protected int attack;
    protected int defense;
    protected int speed;
    protected int quantity;

    public abstract int getDamage();
}
