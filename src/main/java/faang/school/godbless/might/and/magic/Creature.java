package faang.school.godbless.might.and.magic;

import lombok.Data;

@Data
public abstract class Creature {

    private String name;
    private int level;
    private int attack;
    private int defense;
    private int speed;
    private int quantity;

    public Creature(String name, int level, int attack, int defense, int speed, int quantity) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.quantity = quantity;
    }
}
