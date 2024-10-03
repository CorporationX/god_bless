package ru.kraiush.BJS2_32817;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class Creature {
    protected String name;
    protected int level;
    protected int attack;
    protected int defense;
    protected int speed;

    public int getDamage() {
        return this.attack;
    }
}
