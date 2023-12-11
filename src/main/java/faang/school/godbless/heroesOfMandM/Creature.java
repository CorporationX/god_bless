package faang.school.godbless.heroesOfMandM;

import lombok.Getter;

import java.util.Objects;

public abstract class Creature {
    protected String name;
    protected int level;
    @Getter
    protected int attack;
    protected int armor;
    protected int speed;
    @Getter
    protected int amount;
    protected int health;
    @Getter
    protected boolean isDeath;

    public Creature(String name, int level, int attack, int armor, int speed, int amount) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.armor = armor;
        this.speed = speed;
        this.amount = amount;
        this.health = 100;
    }

    void getDamageFrom(Creature creature) {
        setHealth(health - creature.getAttack()*creature.getAmount());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Creature creature)) return false;
        return level == creature.level && attack == creature.attack && armor == creature.armor
                && speed == creature.speed && Objects.equals(name, creature.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, attack, armor, speed);
    }

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setHealth(int health) {
        if (health <=0) {
            isDeath = true;
        }
        this.health = health;
    }
}
