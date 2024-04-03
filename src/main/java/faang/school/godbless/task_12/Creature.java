package faang.school.godbless.task_12;

import lombok.Data;


@Data
public abstract class Creature {
    private String name;
    private int level;
    private int strength;
    private int protection;
    private int speed;

    public Creature(String name, int level, int strength, int protection, int speed) {
        this.name = name;
        this.level = level;
        this.strength = strength;
        this.protection = protection;
        this.speed = speed;
    }

    public abstract int getDamage();
}
