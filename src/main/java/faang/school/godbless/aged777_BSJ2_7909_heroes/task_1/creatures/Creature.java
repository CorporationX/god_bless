package faang.school.godbless.aged777_BSJ2_7909_heroes.task_1.creatures;

import lombok.Getter;

public abstract class Creature {
    protected String name;
    protected int level;
    protected int attack;
    @Getter
    protected int defense;
    protected int speed;
    @Getter
    protected int damage;

    public Creature(String name, int level, int attack, int defense, int speed, int damage) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.damage = damage;
    }
}
