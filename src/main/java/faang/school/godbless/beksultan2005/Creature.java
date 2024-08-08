package faang.school.godbless.beksultan2005;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int defense;
    private int speed;
    private int quantity;

    public int getDamage() {
        return attack * speed * quantity;
    }

    public String getName() {
        return name;
    }
}
