package faang.school.godbless;

import lombok.*;


@ToString
@Getter
@Setter

public abstract class Creature {
    protected String name;
    protected int level;
    protected int attack;
    protected int protection;
    protected int speed;
    protected int peekNumber;

    public Creature(String name, int level, int attack, int protection, int speed, int peekNumber) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.protection = protection;
        this.speed = speed;
        this.peekNumber = peekNumber;
    }


    int getDamage() {
        return (int) (attack + (speed * 0.4) + (level * 0.8));
    }
}
