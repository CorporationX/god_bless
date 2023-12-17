package faang.school.godbless.HeroesOfMagic;

import lombok.Getter;

import java.util.Objects;

@Getter
public abstract class Creature {
    protected final String name;
    protected final int level;
    protected final int attack;
    protected final int protection; //защита
    protected final int speed;
    protected final int health;
    protected int quantity;  //количество
    public Creature(String name, int level, int attack, int protection, int speed, int health, int quantity) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.protection = protection;
        this.speed = speed;
        this.health = health;
        this.quantity = quantity;
    }


    public int getDamage() {
        return this.level * this.attack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return Objects.equals(name, creature.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return '\''+ name + '\'';
    }
}
