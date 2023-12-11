package faang.school.godbless.BJS2_511.creatures;

import lombok.Data;

@Data
public abstract class Creature {
    private static final double COEFFICIENT = 0.5;
    private String name;
    private int level;
    private int attack;
    private int defence;
    private int speed;
    private int quantity;

    public Creature(String name, int level, int attack, int defence, int speed, int quantity) {
        if (name == null || level < 1 || attack < 0 || defence < 0 || speed < 1 || quantity < 0)
            throw new IllegalArgumentException("Invalid parameter values");

        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
        this.quantity = quantity;
    }

    public int getDamage() {
        int baseDamage = this.attack + this.speed;
        return (int) ((baseDamage + baseDamage * COEFFICIENT * (this.level - 1)) * quantity);
    }

    public int getPower () {
        return getDamage() + getDefence();
    }
}
