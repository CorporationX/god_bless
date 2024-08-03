package faang.school.godbless.units;

import lombok.Data;

@Data
public abstract class Creature {

    private String name;
    private int level;
    private int attack;
    private int defense;
    private int speed;
    private int quantity = 0;

    public Creature(String name, int level, int attack, int defense, int speed) {

        if (level <= 0 || attack <= 0 || defense <= 0 || speed <= 0) {
            throw new IllegalArgumentException("You can't input value lover than 1");
        }

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Incorrect name");
        }
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

    public abstract int getDamage();
}
