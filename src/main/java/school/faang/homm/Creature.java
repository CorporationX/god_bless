package school.faang.homm;

import lombok.Getter;

@Getter
public abstract class Creature {
    private String name;
    private int level;
    private int damage;
    private int defense;
    private int speed;

    public Creature(String name, int level, int damage, int defense, int speed) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
    }

    public Integer getAmountOfDamage() {
        return this.level * this.damage * this.speed - defense;
    }
}
