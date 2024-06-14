package faang.school.godbless;

import lombok.Data;

import java.util.Objects;

@Data
public abstract class Creature{
    protected String name;
    protected int level;
    protected int damage;
    protected int protection;
    protected int speed;
    protected int quantity;

    public Creature(String name) {
        this.name = name;
    }

    public Creature(String name, int level, int damage, int protection, int speed, int quantity) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.protection = protection;
        this.speed = speed;
        this.quantity = quantity;
    }

    public abstract int getDamage();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return level == creature.level && damage == creature.damage && protection == creature.protection && speed == creature.speed && quantity == creature.quantity && Objects.equals(name, creature.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, damage, protection, speed, quantity);
    }


}
