package faang.school.godbless.homm;

import lombok.Data;

@Data
public abstract class Creature {
    private final int ATTACK;
    private final int DEFENCE;
    private final int SPEED;
    private String name;
    private int lvl;
    private int quantity;

    public Creature(int ATTACK, int DEFENCE, int SPEED, String name, int lvl, int quantity) {
        this.ATTACK = ATTACK;
        this.DEFENCE = DEFENCE;
        this.SPEED = SPEED;
        this.name = name;
        this.lvl = lvl;
        this.quantity = quantity;
    }

    public abstract boolean getDamage(Creature creature);
}
