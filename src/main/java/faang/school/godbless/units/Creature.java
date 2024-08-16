package faang.school.godbless.units;

import lombok.Data;

@Data
public abstract class Creature {

    private final int MIN_PARAM = 0;

    private String name;
    private int level;
    private int attack;
    private int defense;
    private int speed;
    private int quantity;

    public Creature(String name, int level, int attack, int defense, int speed) {

        if (level <= MIN_PARAM || attack <= MIN_PARAM || defense <= MIN_PARAM || speed <= MIN_PARAM) {
            throw new IllegalArgumentException("You can't input value lower than 1");
        }

        if (name == null || name.isBlank()) {
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
