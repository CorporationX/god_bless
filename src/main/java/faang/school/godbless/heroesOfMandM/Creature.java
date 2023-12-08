package faang.school.godbless.heroesOfMandM;

import lombok.Getter;

import java.util.Objects;

public abstract class Creature {
    protected String name;
    protected int level;
    @Getter
    protected int attack;
    protected int Armor;
    protected int speed;
    @Getter
    protected int amount;

    public Creature(String name, int level, int attack, int armor, int speed, int amount) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        Armor = armor;
        this.speed = speed;
        this.amount = amount;
    }

    void getDamage(Creature creature) {
        amount = amount - creature.getAttack();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Creature creature)) return false;
        return level == creature.level && attack == creature.attack && Armor == creature.Armor
                && speed == creature.speed && amount == creature.amount && Objects.equals(name, creature.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, attack, Armor, speed, amount);
    }

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                '}';
    }
}
