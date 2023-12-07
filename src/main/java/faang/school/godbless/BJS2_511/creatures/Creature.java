package faang.school.godbless.BJS2_511.creatures;

import lombok.Data;

import java.util.Objects;

@Data
public abstract class Creature {
    private static final double COEFFICIENT = 0.5;
    private String name;
    private int level;
    private int attack;
    private int defence;
    private int speed;
    private int quantity;

    public Creature(String name, int level, int damage, int defence, int speed, int quantity) {
        if (level < 1 || damage < 0 || defence < 0 || speed < 1 || quantity < 0) {
            throw new IllegalArgumentException("Invalid parameter values");
        }

        this.name = name;
        this.level = level;
        this.attack = damage;
        this.defence = defence;
        this.speed = speed;
        this.quantity = quantity;
    }

    public int getDamage() {
        int baseDamage = this.attack + this.speed;
        return (int) ((baseDamage + baseDamage * COEFFICIENT * (this.level - 1)) * quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return name.equals(creature.name)
                && level == creature.level
                && attack == creature.attack
                && defence == creature.defence
                && speed == creature.speed
                && quantity == creature.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, attack, defence, speed, quantity);
    }
}
