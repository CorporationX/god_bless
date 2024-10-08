package school.faang.t16;

import lombok.Getter;

abstract class Creature {
    @Getter
    protected String name;
    protected int level;
    protected int attack;
    protected int defense;
    @Getter
    protected int speed;

    public Creature(String name, int level, int attack, int defense, int speed) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

    public abstract int getDamage();
}