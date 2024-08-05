package faang.school.godbless.BJS2_18923;

import lombok.AllArgsConstructor;

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
