package heroesofswordandmagic;

import lombok.AllArgsConstructor;
import lombok.Data;

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

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
