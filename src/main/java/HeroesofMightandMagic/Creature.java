package HeroesofMightandMagic;

import java.util.Objects;

public abstract class Creature {// имя, уровень, атака, защита, скорость и количество
    private String name;
    private int level;
    private int damage;
    private int defence;
    private int speed;
    private int amount;

    public Creature(String name, int level, int damage, int defence, int speed, int amount) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.defence = defence;
        this.speed = speed;
        this.amount = amount;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return level == creature.level && damage == creature.damage && defence == creature.defence && speed == creature.speed && amount == creature.amount && Objects.equals(name, creature.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, damage, defence, speed, amount);
    }

    public int defence() {
        return defence;
    }

    public int amount() {
        return amount;
    }
}
