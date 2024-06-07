package heroesofswordandmagic;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Creature {
    protected String name;
    protected int level;
    protected int damage;
    protected int defense;
    protected int speed;
    protected int quantity;

    public abstract int getDamage();

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }
}
