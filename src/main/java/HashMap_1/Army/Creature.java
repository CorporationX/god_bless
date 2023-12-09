package HashMap_1.Army;

import java.util.Objects;

public abstract class Creature {

    public Creature(String name, int level, int attack, int defend, int speed, int quantity) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defend = defend;
        this.speed = speed;
        this.quantity = quantity;
    }

    private String name;
    private int level;
    private int attack;
    private int defend;
    private int speed;
    private int quantity;

    public abstract int getDamage(Creature creature);

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefend() {
        return defend;
    }

    public int getSpeed() {
        return speed;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return attack == creature.attack && defend == creature.defend && speed == creature.speed && name.equals(creature.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, attack, defend, speed);
    }

}
